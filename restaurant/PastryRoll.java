package restaurant;

import java.util.Random;

public class PastryRoll extends FoodItem {

    public PastryRoll()
    {
        Random rand = new Random();
        description = "Pastry Roll";
        extraSauce = rand.nextInt(4);
        extraFill  = rand.nextInt(2);
        extraTop  = rand.nextInt(3);
    }

    public double cost()
        {
            return 3.00;
        }
    
    
}
