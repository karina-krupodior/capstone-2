package models.enums;
//Customers can order sandwiches in 3 sizes (4", 8" and 12")
public enum Size {
    SMALL(4,5.50 ), MEDIUM(8,7.00), LARGE(12,8.50);

    private final int inches;
    private  final  double basePrice;

    Size(int inches, double basePrice) {
        this.inches = inches;
        this.basePrice = basePrice;

    }

    public int getInches() {
        return inches;
    }

    public double getBasePrice () {
        return this.basePrice;
    }

}
