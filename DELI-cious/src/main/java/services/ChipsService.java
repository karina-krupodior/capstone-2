package services;

import models.Chips;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChipsService {

    public List<Chips> getAvailableChips() {
        List<Chips> chipsList = new ArrayList<>();
        chipsList.add(new Chips("Lays Chicken"));
        chipsList.add(new Chips("Smoked Paprika"));
        chipsList.add(new Chips("Sour Cream & Fresh Dill"));
        return chipsList;
    }

    public Chips chooseChips(Scanner scanner) {
        List<Chips> chipsList = getAvailableChips();
        System.out.println("Choose a type of chips (or 0 to skip):");

        for (int i = 0; i < chipsList.size(); i++) {
            System.out.println((i + 1) + ". " + chipsList.get(i));
        }

        System.out.print("Your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 0) return null;
        if (choice > 0 && choice <= chipsList.size()) {
            return chipsList.get(choice - 1);
        }

        System.out.println("Invalid choice.");
        return null;
    }
}
