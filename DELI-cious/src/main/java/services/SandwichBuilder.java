package services;

import models.enums.BreadType;
import models.enums.Size;

public class SandwichBuilder {
    private Size size;
    private BreadType bread;
    private  boolean toasted;


    public void setSize(Size size) {
        this.size = size;
    }

    public void setBread (BreadType bread) {
        this.bread = bread;

    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

}
