package models;

public class Chips implements MenuItem {
    private String name;
    private  double price;

    Chips(String name, double price) {
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
