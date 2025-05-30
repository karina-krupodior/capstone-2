import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SandwichBuilderSimple {
    private String size;
    private String breadType;
    private boolean toasted;
    private List<String> meats = new ArrayList<>();
    private List<String> cheeses = new ArrayList<>();

    public void setSize(String size) { this.size = size; }
    public void setBreadType(String breadType) { this.breadType = breadType; }
    public void setToasted(boolean toasted) { this.toasted = toasted; }
    public void addMeat(String meat) { this.meats.add(meat); }
    public void addCheese(String cheese) { this.cheeses.add(cheese); }

    public void build(Scanner scanner) {
        System.out.println("Let's build your sandwich!");

        System.out.println("Choose size (small, medium, large):");
        size = scanner.nextLine();

        System.out.println("Choose bread (white, wheat, rye):");
        breadType = scanner.nextLine();

        System.out.println("Do you want it toasted? (yes/no):");
        toasted = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.println("Add meats (type 'done' when finished):");
        while (true) {
            String meat = scanner.nextLine();
            if (meat.equalsIgnoreCase("done")) break;
            meats.add(meat);
            System.out.println(meat + " added.");
        }

        System.out.println("Add cheeses (type 'done' when finished):");
        while (true) {
            String cheese = scanner.nextLine();
            if (cheese.equalsIgnoreCase("done")) break;
            cheeses.add(cheese);
            System.out.println(cheese + " added.");
        }

        showSummary();
    }

    private void showSummary() {
        System.out.println("\nYour sandwich:");
        System.out.println("Size: " + size);
        System.out.println("Bread: " + breadType);
        System.out.println("Toasted: " + (toasted ? "Yes" : "No"));
        System.out.println("Meats: " + String.join(", ", meats));
        System.out.println("Cheeses: " + String.join(", ", cheeses));
    }

}
