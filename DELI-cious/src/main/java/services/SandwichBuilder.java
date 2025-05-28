package services;

import models.Sandwich;
import models.enums.*;

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
    private Side side;

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

    public void setSide ( Side side) {
        this.side = side;
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
    public  void addSauce (Sauce sauce) {
        sauces.add(sauce);
        // Example: addSauce(Sauce.MAYO);

    }

    // Builds the final Sandwich object using all selected options
    public Sandwich build () {
        if (size == null || breadType == null) {
            throw new IllegalStateException("Size and bread must be set");
        }
        // Creates and returns a fully-configured Sandwich object
        return new  Sandwich("my",25);
    }


}
