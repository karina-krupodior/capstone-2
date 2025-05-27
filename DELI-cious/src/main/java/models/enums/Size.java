package models.enums;
//Customers can order sandwiches in 3 sizes (4", 8" and 12")
public enum Size {
    SMALL(4), MEDIUM(8), LARGE(12);

    private final int inches;

    Size(int inches) {
        this.inches = inches;
    }

    public int getInches() {
        return inches;
    }
}
