package restaurant;

public class ToppingDecorator extends ExtraDecorator {

    FoodItem foodItem;
    String newDescription = "";

    public ToppingDecorator(FoodItem foodItem)
    {
        this.foodItem = foodItem;
    }

    @Override
    public String getDescription()
    {
        if (foodItem.getDescription() == "Egg Roll")
        {
            newDescription =  (" Shredded Cabbage");
        }

        if (foodItem.getDescription() == "Spring Roll")
        {
            newDescription = (" Shredded Carrots");
        }

        if (foodItem.getDescription() == "Pastry Roll")
        {
            newDescription = (" Fruit Preserves");
        }

        if (foodItem.getDescription() == "Sausage Roll")
        {
            newDescription = (" Mozzarella Cheese");
        }

        if (foodItem.getDescription() == "Jelly Roll")
        {
            newDescription = (" Powdered Sugar");
        }

        return (foodItem.getDescription() + newDescription);

    }

    public double cost()
    {
       return (foodItem.cost() + 0.50);
    }

}
