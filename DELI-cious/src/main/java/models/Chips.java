package models;

public class Chips {
    private final String flavor;
    private final double price = 1.50;

    public Chips(String flavor) {
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return flavor + " Chips - $" + price;
    }
}
