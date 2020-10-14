package restaurant;

public abstract class SauceDecorator extends ExtraDecorator {
    FoodItem foodItem;
    String newDescription = "";

    public FillingDecorator(FoodItem foodItem)
    {
        this.foodItem = foodItem;
    }

    public String getDescription()
    {
        if (foodItem.getDescription() == "Egg Roll")
        {
            newDescription =  (foodItem.getDescription() + ", Sweet & Sour sauce");
        }

        if (foodItem.getDescription() == "Jelly Roll")
        {
            newDescription = (foodItem.getDescription() + ", Cranberry sauce");
        }

        if (foodItem.getDescription() == "Pastry Roll")
        {
            newDescription = (foodItem.getDescription() +  ", Dark Chocolate sauce");
        }

        if (foodItem.getDescription() == "Spring Roll")
        {
            newDescription = (foodItem.getDescription() + ", Peanut sauce");
        }

        if (foodItem.getDescription() == "Sausage Roll")
        {
            newDescription = (foodItem.getDescription() + ", Marinara sauce");
        }

        return (foodItem.getDescription() + newDescription);

    }

    public double cost()
    {
       return (foodItem.cost() + 1.00);
    }
    
}
