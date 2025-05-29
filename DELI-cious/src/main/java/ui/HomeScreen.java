package ui;

import java.util.Scanner;

public class HomeScreen {
    private final Scanner scanner = new Scanner(System.in);

    public void show() {
        boolean running = true;

        while (running) {
            System.out.println("=== Welcome to DELI-cious Sandwich Shop ===");
            System.out.println("1. Make an Order");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("OrderScreen will be shown here...");
                    //  new OrderScreen().show()
                    break;
                case 0:
                    System.out.println("Thanks for visiting DELI-cious!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
