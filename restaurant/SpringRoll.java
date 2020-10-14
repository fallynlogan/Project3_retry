package restaurant;

import java.util.Random;

public class SpringRoll extends FoodItem {

    public SpringRoll()
    {
        Random rand = new Random();
        description = "Spring Roll";
        extraSauce = rand.nextInt(4);
        extraFill  = rand.nextInt(2);
        extraTop  = rand.nextInt(3);
    }

    public double cost()
    {
        return 3.50;
    }
}
