package restaurant;

import java.util.Random;

public class EggRoll extends FoodItem {

    public EggRoll()
    {
        Random rand = new Random();
        description = "Egg Roll";
        extraSauce = rand.nextInt(4);
        extraFill  = rand.nextInt(2);
        extraTop  = rand.nextInt(3);
    }

    public double cost()
    {
        return 3.50;
    }
    
}
