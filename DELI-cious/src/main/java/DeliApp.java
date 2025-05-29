import ui.HomeScreen;
import java.util.Scanner;

public class DeliApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            int choice = HomeScreen.show(scanner);

            switch (choice) {
                case 1:
                    System.out.println("Starting new order...");
                    // вызов OrderScreen будет здесь
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Please choose a valid option.");
            }
        }

        scanner.close();
    }
}
