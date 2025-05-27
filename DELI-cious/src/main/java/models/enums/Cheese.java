package models.enums;

public enum Cheese {
    AMERICAN(0.75, 1.5, 2.25),
    PROVOLONE(0.75, 1.5, 2.25),
    CHEDDAR(0.75, 1.5, 2.25),
    SWISS(0.75, 1.5, 2.25),
    EXTRA_CHEESE(0.3, 0.6, 0.9);

    private final double smallPrice;
    private final double mediumPrice;
    private final double largePrice;

    Cheese(double smallPrice, double mediumPrice, double largePrice) {
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
