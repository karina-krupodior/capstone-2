package services;

import models.Drink;
import models.enums.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DrinkService {

    public List<String> getAvailableDrinkNames() {
        List<String> drinks = new ArrayList<>();
        drinks.add("Coke");
        drinks.add("Sprite");
        drinks.add("Water");
        drinks.add("Juice");
        return drinks;
    }

    public Drink chooseDrink(Scanner scanner) {
        List<String> drinkNames = getAvailableDrinkNames();

        System.out.println("Choose a drink (or 0 to skip):");
        for (int i = 0; i < drinkNames.size(); i++) {
            System.out.println((i + 1) + ". " + drinkNames.get(i));
        }

        System.out.print("Your choice: ");
        int drinkChoice = Integer.parseInt(scanner.nextLine());

        if (drinkChoice == 0) return null;
        if (drinkChoice < 1 || drinkChoice > drinkNames.size()) {
            System.out.println("Invalid drink choice.");
            return null;
        }

        String selectedDrink = drinkNames.get(drinkChoice - 1);

        System.out.println("Select size:");
        System.out.println("1. SMALL ($2.00)");
        System.out.println("2. MEDIUM ($2.50)");
        System.out.println("3. LARGE ($3.00)");

        int sizeChoice = Integer.parseInt(scanner.nextLine());
        Size size;

        switch (sizeChoice) {
            case 1:
                size = Size.SMALL;
                break;
            case 2:
                size = Size.MEDIUM;
                break;
            case 3:
                size = Size.LARGE;
                break;
            default:
                System.out.println("Invalid size choice.");
                return null;
        }

        return new Drink(size, selectedDrink);
    }
}
