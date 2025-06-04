package ui;

import models.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import services.ChipsService;
import services.DrinkService;
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
                    DrinkService drinkService = new DrinkService();
                    Drink selectedDrink = drinkService.chooseDrink(scanner);
                    if (selectedDrink != null) {
                        orderItems.add((MenuItem) selectedDrink);
                        System.out.println("You selected: " + selectedDrink);
                    }
                    break;

                case 3:
                    ChipsService chipsService = new ChipsService();
                    Chips selectedChips = chipsService.chooseChips(scanner);
                    if (selectedChips != null) {
                        orderItems.add((MenuItem) selectedChips);
                        System.out.println("You selected: " + selectedChips);
                    }
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

        StringBuilder receipt = new StringBuilder();
        receipt.append("=== DELI-cious Receipt ===\n");

        for (MenuItem item : orderItems) {
            System.out.println(item.getName() + " - $" + item.getPrice());
            receipt.append(item.getName()).append(" - $").append(String.format("%.2f", item.getPrice())).append("\n");
            total += item.getPrice();
        }

        receipt.append(String.format("Total: $%.2f\n", total));

        System.out.printf("Total: $%.2f\n", total);

        // Save to file
        try {
            String timestamp = java.time.LocalDateTime.now()
                    .format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            java.nio.file.Path receiptDir = java.nio.file.Paths.get("receipts");
            java.nio.file.Files.createDirectories(receiptDir); // create folder if not exists
            java.nio.file.Path receiptPath = receiptDir.resolve(timestamp + ".txt");

            java.nio.file.Files.write(receiptPath, receipt.toString().getBytes());

            System.out.println("Receipt saved to " + receiptPath.toAbsolutePath());
        } catch (Exception e) {
            System.out.println("Failed to save receipt: " + e.getMessage());
        }
    }

}
