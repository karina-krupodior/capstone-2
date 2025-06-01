package models;

public class Chips implements MenuItem {
    private final String flavor;
    private final double price = 1.50;

    public Chips(String flavor) {
        this.flavor = flavor;
    }


    @Override
    public String getName() {
        return this.flavor;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return flavor + " Chips - $" + price;
    }
}
