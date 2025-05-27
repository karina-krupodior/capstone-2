package models.enums;

public enum Meat {
    STEAK(1.0, 2.0, 3.0),
    HAM(1.0, 2.0, 3.0),
    SALAMI(1.0, 2.0, 3.0),
    ROAST_BEEF(1.0, 2.0, 3.0),
    CHICKEN(1.0, 2.0, 3.0),
    BACON(1.0, 2.0, 3.0),
    EXTRA_MEAT(0.5, 1.0, 1.5);

    private final double smallPrice;
    private final double mediumPrice;
    private final double largePrice;

    Meat(double smallPrice, double mediumPrice, double largePrice) {
        this.smallPrice = smallPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
    }

    public double getPrice(Size size) {
        return switch (size) {
            case SMALL -> smallPrice;
            case MEDIUM -> mediumPrice;
            case LARGE -> largePrice;
        };
    }
}
