package models;

import models.enums.Size;

public class Order {
    private final Size size;
    private Sandwich sandwich;

    public Order(Size size, Sandwich sandwich) {
        this.size = size;
        this.sandwich = sandwich;
    }


}
