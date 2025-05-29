package models;

import models.enums.*;

import java.util.List;

//The sandwich is the core of our business.
public class Sandwich implements MenuItem {
    private String name;
    private double price;
    private Size size;
    private BreadType breadType;
    private boolean toasted;
    private List<Meat> meats;
    private List<Cheese> cheeses;
    private List<RegularTopping> regularToppings;
    private List<Sauce> sauces;

    public Sandwich(String name, double price, Size size, BreadType bread, boolean toasted, List<Meat> meatList, List<Cheese> cheeseList, List<RegularTopping> regularToppingList, List<Sauce> saucesList) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.breadType = bread;
        this.toasted = toasted;
        this.meats = meatList;
        this.cheeses = cheeseList;
        this.regularToppings = regularToppingList;
        this.sauces = saucesList;
    }

    public Size getSize() {
        return this.size;
    }

    public BreadType getBread() {
        return this.breadType;
    }

    public boolean isToasted() {
        return this.toasted;
    }

    public List<Meat> getMeats() {
        return this.meats;

    }

    public List<Cheese> getCheeses() {
        return this.cheeses;
    }

    public List<RegularTopping> getRegularToppings() {
        return this.regularToppings;
    }

    public List<Sauce> getSauces() {
        return this.sauces;
    }

    @Override
    public String toString() {

        return "Sandwich{" +
                "price=$" + price + ", size=" + size +
                ", breadType=" + breadType +
                ", toasted=" + toasted +
                ", meats=" + meats +
                ", cheeses=" + cheeses +
                ", toppings=" + regularToppings +
                ", sauces=" + sauces +
                '}';
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

}
