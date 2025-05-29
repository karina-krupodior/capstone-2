package ui;

import models.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import services.SandwichBuilder;


public class OrderScreen {
    private final Scanner scanner = new Scanner(System.in);
    private final List<MenuItem> orderItems = new ArrayList<>();

    public void show() {
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n=== Order Menu ===");
            System.out.println("1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Checkout");
            System.out.println("0. Cancel Order");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:

                    SandwichBuilder builder = new SandwichBuilder();
                    builder.build(scanner);
                    Sandwich sandwich = builder.createSandwich();
                    System.out.println(sandwich);

                    orderItems.add(sandwich);
                    System.out.println("Sandwich added!");
                    break;
                case 2:
                    System.out.print("Enter drink name: ");
                    String drinkName = scanner.nextLine();
                    System.out.print("Enter drink price: ");
                    double drinkPrice = Double.parseDouble(scanner.nextLine());
                    orderItems.add(new Drink(drinkName, drinkPrice));
                    System.out.println("Drink added!");
                    break;
                case 3:
                    System.out.print("Enter chip name: ");
                    String chipName = scanner.nextLine();
                    System.out.print("Enter chip price: ");
                    double chipPrice = Double.parseDouble(scanner.nextLine());
                    orderItems.add(new Chips(chipName, chipPrice));
                    System.out.println("Chips added!");
                    break;
                case 4:
                    checkout();
                    ordering = false;
                    break;
                case 0:
                    System.out.println("Order cancelled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void checkout() {
        double total = 0;
        System.out.println("\n=== Order Summary ===");
        for (MenuItem item : orderItems) {
            System.out.println(item.getName() + " - $" + item.getPrice());
            total += item.getPrice();
        }
        System.out.printf("Total: $%.2f\n", total);
        // TODO: Save receipt to file
    }
}
