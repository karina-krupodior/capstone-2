package models.enums;
//When they order, they choose the type of bread that they
//would like (white, wheat, rye, or wrap).
//Customers can order sandwiches in 3 sizes (4", 8" and 12")

public enum BreadType {
    WHITE("White"), WHEAT("Wheat"), RYE("Rye"), WRAP("Wrap");

    private final String displayName;

    BreadType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
