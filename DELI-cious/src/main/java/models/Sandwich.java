package models;

import models.enums.BreadType;
import models.enums.Size;

//The sandwich is the core of our business.
public class Sandwich implements MenuItem {
    private String name;
    private double price;
    private Size size;
    private BreadType bread;
    private  boolean toasted;

    public Sandwich(String name, double price) {
        this.name = name;
        this.price = price;
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
