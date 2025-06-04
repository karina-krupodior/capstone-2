package services;

import models.Sandwich;
import models.enums.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SandwichBuilder {
    private Size size;
    private BreadType breadType;
    private boolean toasted;
    private List<Meat> meats = new ArrayList<>();
    private List<Cheese> cheeses = new ArrayList<>();
    private List<RegularTopping> regularToppings = new ArrayList<>();
    private List<Sauce> sauces = new ArrayList<>();

    public void setSize(Size size) { this.size = size; }
    public void setBreadType(BreadType breadType) { this.breadType = breadType; }
    public void setToasted(boolean toasted) { this.toasted = toasted; }
    public void addMeat(Meat meat) { this.meats.add(meat); }
    public void addCheese(Cheese cheese) { this.cheeses.add(cheese); }
    public void addRegularTopping(RegularTopping topping) { this.regularToppings.add(topping); }
    public void addSauce(Sauce sauce) { this.sauces.add(sauce); }

    public double calculatePrice() {
        double total = 0;

        total += size.getBasePrice();

        if (!meats.isEmpty()) {
            for (int i = 0; i < meats.size(); i++) {
                if (i == 0) {
                    total += meats.get(i).getPrice(size);
                } else {
                    total += Meat.EXTRA_MEAT.getPrice(size);
                }
            }
        }

        if (!cheeses.isEmpty()) {
        for (int i = 0; i < cheeses.size(); i++) {
            if (i == 0) {
                total += cheeses.get(i).getPrice(size);
            } else {
                total += Cheese.EXTRA_CHEESE.getPrice(size);
            }

        }


    }
        return total;
        }


    public Sandwich createSandwich() {
        if (size == null || breadType == null) {
            throw new IllegalStateException("Size and bread must be set");
        }
        String name = "Custom Sandwich";
        double price = calculatePrice();
        return new Sandwich(name, price, size, breadType, toasted, meats, cheeses, regularToppings, sauces);
    }

    public void build(Scanner scanner) {
        System.out.println("Let's build your delicious sandwich step by step!\n");

        size = promptEnum(scanner, "Choose size", Size.class);

        breadType = promptEnum(scanner, "Choose bread", BreadType.class);

        toasted = promptBoolean(scanner, "Do you want your sandwich toasted? (true/false)");

        meats = promptMultipleChoices(scanner, "Add meats", Meat.class);

        cheeses = promptMultipleChoices(scanner, "Add cheeses", Cheese.class);

        regularToppings = promptMultipleChoices(scanner, "Add toppings", RegularTopping.class);

        sauces = promptMultipleChoices(scanner, "Add sauces", Sauce.class);

        System.out.println("\n✅ Sandwich ingredients collected successfully!");
        System.out.println("Here is your sandwich summary:");
        System.out.println(createSandwich());
    }

    private <T extends Enum<T>> T promptEnum(Scanner scanner, String prompt, Class<T> enumClass) {
        T selection = null;
        String options = enumOptions(enumClass);
        while (selection == null) {
            System.out.println(prompt + " (" + options + "):");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.isEmpty()) {
                System.out.println("⚠️ Input cannot be empty. Please try again.");
                continue;
            }
            try {
                selection = Enum.valueOf(enumClass, input);
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Invalid input. Please choose one of: " + options);
            }
        }
        return selection;
    }

    private <T extends Enum<T>> List<T> promptMultipleChoices(Scanner scanner, String prompt, Class<T> enumClass) {
        List<T> choices = new ArrayList<>();
        String options = enumOptions(enumClass);
        System.out.println(prompt + " (type 'done' to finish). Available: " + options);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("⚠️ Empty input ignored. Please enter a choice or 'done'.");
                continue;
            }
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                T choice = Enum.valueOf(enumClass, input.toUpperCase());
                if (choices.contains(choice)) {
                    System.out.println("⚠️ You already added " + choice + ". Try something else or 'done'.");
                } else {
                    choices.add(choice);
                    System.out.println("Added: " + choice);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Invalid choice. Please pick from: " + options);
            }
        }
        return choices;
    }

    private boolean promptBoolean(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true")) return true;
            if (input.equals("false")) return false;
            System.out.println("❌ Please type 'true' or 'false'.");
        }
    }

    private <T extends Enum<T>> String enumOptions(Class<T> enumClass) {
        T[] constants = enumClass.getEnumConstants();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < constants.length; i++) {
            sb.append(constants[i].name());
            if (i < constants.length - 1) sb.append(", ");
        }
        return sb.toString();
    }
}
