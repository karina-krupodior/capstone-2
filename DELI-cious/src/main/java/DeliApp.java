import models.Sandwich;
import models.enums.*;
import services.SandwichBuilder;

public class DeliApp {

    public static void main(String[] args) {
        SandwichBuilder sandwichBuilder = new SandwichBuilder();
        sandwichBuilder.setSize(Size.MEDIUM);
        sandwichBuilder.setBreadType(BreadType.WHEAT);
        sandwichBuilder.setToasted(true);
        sandwichBuilder.addMeat(Meat.HAM);
        sandwichBuilder.addMeat(Meat.BACON);
        sandwichBuilder.addCheese(Cheese.SWISS);
        sandwichBuilder.addRegularTopping(RegularTopping.ONIONS);
        sandwichBuilder.addSauce(Sauce.MAYO);
        Sandwich createSandwich = sandwichBuilder.createSandwich();
        System.out.println("createSandwich:" + createSandwich);

    }
}
