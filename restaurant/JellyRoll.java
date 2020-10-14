package restaurant;

import java.util.Random;

public class JellyRoll extends FoodItem {

    public JellyRoll()
    {
        Random rand = new Random();
        description = "Jelly Roll";
        extraSauce = rand.nextInt(4);
        extraFill  = rand.nextInt(2);
        extraTop  = rand.nextInt(3);
    }

    public double cost()
    {
        return 2.75;
    }

    
}
