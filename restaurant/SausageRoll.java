package restaurant;

import java.util.Random;

public class SausageRoll extends FoodItem {

    public SausageRoll()
    {
        Random rand = new Random();
        description = "Sausage Roll";
        extraSauce = rand.nextInt(4);
        extraFill  = rand.nextInt(2);
        extraTop  = rand.nextInt(3);
    }

    public double cost()
    {
        return 4.25;
    }
    
}
