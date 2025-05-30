package models;

import models.enums.Size;

public class Drink implements MenuItem{
    private Size size;
    private String name;

    public Drink(Size size, String name) {
        this.size = size;
        this.name = name;
    }

    public Size getSize() {
        return size;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public double getPrice() {
        switch (size) {
            case SMALL:
                return 2.00;
            case MEDIUM:
                return 2.50;
            case LARGE:
                return 3.00;
            default:
                return 0.00;
        }
    }

    @Override
    public String toString() {
        return name + " (" + size + ") - $" + getPrice();
    }
}
