package restaurant;

public class FillingDecorator extends ExtraDecorator{
    private FoodItem foodItem;
    private String newDescription = "";

    public FillingDecorator(FoodItem foodItem)
    {
        this.foodItem = foodItem;
    }

    @Override
    public String getDescription()
    {
        if (foodItem.getDescription() == "Egg Roll")
        {
            newDescription = (" Shredded Beef");
        }
        if (foodItem.getDescription() == "Spring Roll")
        {
            newDescription = (" Ground Pork");
        }
        if (foodItem.getDescription() == "Pastry Roll")
        {
            newDescription = (" Cream Cheese");
        }
        if (foodItem.getDescription() == "Sausage Roll")
        {
            newDescription = (" Italian Sausage");
        }
        if (foodItem.getDescription() == "Jelly Roll")
        {
            newDescription = (" Apricot Jelly");
        }

        return (foodItem.getDescription() + newDescription);

    }

    public double cost()
    {
       return (foodItem.cost() + 1.50);
    }

    
}
