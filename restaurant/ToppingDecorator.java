package restaurant;

public abstract class ToppingDecorator extends ExtraDecorator {

    FoodItem foodItem;
    String newDescription = "";

    public ToppingDecorator(FoodItem foodItem)
    {
        this.foodItem = foodItem;
    }

    public String getDescription()
    {
        if (foodItem.getDescription() == "Egg Roll")
        {
            newDescription =  (foodItem.getDescription() + ", Shredded Cabbage");
        }

        if (foodItem.getDescription() == "Jelly Roll")
        {
            newDescription = (foodItem.getDescription() + ", Powdered Sugar");
        }

        if (foodItem.getDescription() == "Pastry Roll")
        {
            newDescription = (foodItem.getDescription() +  ", Fruit Preserves");
        }

        if (foodItem.getDescription() == "Spring Roll")
        {
            newDescription = (foodItem.getDescription() + "Shredded Carrots");
        }

        if (foodItem.getDescription() == "Sausage Roll")
        {
            newDescription = (foodItem.getDescription() + "Mozzarella Cheese");
        }

        return (foodItem.getDescription() + "Mozzarella Cheese");

    }

    public double cost()
    {
       return (foodItem.cost() + 0.50);
    }

}
