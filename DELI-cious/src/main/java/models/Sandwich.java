package models;

import models.enums.*;

import java.util.List;

//The sandwich is the core of our business.
public class Sandwich implements MenuItem {
    private String name;
    private double price;
    private Size size;
    private BreadType bread;
    private boolean toasted;
    private Side side;
    private List<Meat> meats;
    private List<Cheese> cheeses;
    private List<RegularTopping> regularToppings;
    private List<Sauce> sauces;

    public Sandwich(String name, double price, Size size, BreadType bread, boolean toasted, Side side, List<Meat> meatList, List<Cheese> cheeseList, List<RegularTopping> regularToppingList, List<Sauce> saucesList) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        this.side = side;
        this.meats = meatList;
        this.cheeses = cheeseList;
        this.regularToppings = regularToppingList;
        this.sauces  = saucesList;
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
