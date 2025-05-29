package ui;
import java.util.Scanner;

public class HomeScreen {

    public static int show(Scanner scanner) {
        System.out.println("=== DELI-cious ===");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();

        try {
            return Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }
}
