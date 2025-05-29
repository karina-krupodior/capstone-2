package services;

import models.Sandwich;
import models.enums.*;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class SandwichBuilder {
    //  SMALL(4), MEDIUM(8), LARGE(12);
    private Size size;
    //  BreadType WHITE("White"), WHEAT("Wheat"), RYE("Rye"), WRAP("Wrap");
    private BreadType breadType;
    // Should the sandwich be toasted?
    private boolean toasted;
    // Lists to store selected ingredients

    private List<Meat> meats = new ArrayList<>();   // Example: [TURKEY, HAM]

    private List<Cheese> cheeses = new ArrayList<>();  // Example: [CHEDDAR]
    private List<RegularTopping> regularToppings = new ArrayList<>(); // Example: [LETTUCE, TOMATO]
    private List<Sauce> sauces = new ArrayList<>(); // Example: [MAYO, MUSTARD]


    // Sets the sandwich size
    public void setSize(Size size) {
        this.size = size;
        // Example: setSize(Size.MEDIUM);

    }

    // Sets the type of bread
    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
        // Example: setBreadType(BreadType.WHEAT);

    }

    // Sets whether the sandwich is toasted
    public void setToasted(boolean toasted) {
        this.toasted = toasted;
        // Example: setToasted(true);

    }

    // Adds a meat to the sandwich
    public void addMeat(Meat meat) {
        this.meats.add(meat);
        // Example: addMeat(Meat.TURKEY);

    }

    // Adds a cheese to the sandwich
    public void addCheese(Cheese cheese) {
        this.cheeses.add(cheese);
        // Example: addCheese(Cheese.CHEDDAR)

    }

    // Adds a regular topping to the sandwich
    public void addRegularTopping(RegularTopping regularTopping) {
        this.regularToppings.add(regularTopping);

        // Example: addTopping(RegularTopping.LETTUCE);
    }

    // Adds a sauce to the sandwich
    public void addSauce(Sauce sauce) {
        sauces.add(sauce);
        // Example: addSauce(Sauce.MAYO);

    }

    public double calculatePrice() {
        double total = 0;
        total = total + this.size.getBasePrice();

        if (!this.meats.isEmpty()) {
            total = total + meats.get(0).getPrice(this.size);
        }
        int extraMeats = meats.size() - 1;
        if (extraMeats > 0) {
            total += Meat.EXTRA_MEAT.getPrice(size) * extraMeats;
        }

        if (!this.cheeses.isEmpty()) {
            total = total + cheeses.get(0).getPrice(this.size);
            int extraCheese = cheeses.size() - 1;
            if (extraCheese > 0) {
                total = Cheese.EXTRA_CHEESE.getPrice(size) * extraCheese;
            }
        }
        return total;

    }

    // Builds the final Sandwich object using all selected options
    public Sandwich createSandwich() {
        if (size == null || breadType == null) {
            throw new IllegalStateException("Size and bread must be set");
        }
        String name = "Custom Sandwich";
        double price = calculatePrice();
        // Creates and returns a fully-configured Sandwich object
        return new Sandwich(name, price, this.size, this.breadType, this.toasted, this.meats, this.cheeses, this.regularToppings, this.sauces);
    }

    public void build(Scanner scanner) {
        System.out.println("Choose size (SMALL, MEDIUM, LARGE):");
        this.size = Size.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Choose bread (WHITE, WHEAT, RYE, WRAP):");
        this.breadType = BreadType.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Toasted? (true/false):");
        this.toasted = Boolean.parseBoolean(scanner.nextLine());

        // === Meats ===
        System.out.println("Add meat (e.g. TURKEY, HAM) - type 'done' to finish:");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) break;
            try {
                addMeat(Meat.valueOf(input.toUpperCase()));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid meat. Try again:");
            }
        }

        // === Cheeses ===
        System.out.println("Add cheese (e.g. CHEDDAR, SWISS) - type 'done' to finish:");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) break;
            try {
                addCheese(Cheese.valueOf(input.toUpperCase()));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid cheese. Try again:");
            }
        }

        // === Regular Toppings ===
        System.out.println("Add topping (e.g. LETTUCE, TOMATO) - type 'done' to finish:");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) break;
            try {
                addRegularTopping(RegularTopping.valueOf(input.toUpperCase()));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid topping. Try again:");
            }
        }

        // === Sauces ===
        System.out.println("Add sauce (e.g. MAYO, MUSTARD) - type 'done' to finish:");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) break;
            try {
                addSauce(Sauce.valueOf(input.toUpperCase()));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid sauce. Try again:");
            }
        }

        System.out.println("✅ Sandwich ingredients collected successfully.");
    }



}
