package restaurant;

public class FillingDecorator extends ExtraDecorator{
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
            newDescription =  (foodItem.getDescription() + ", Shredded Beef");
        }

        if (foodItem.getDescription() == "Jelly Roll")
        {
            newDescription = (foodItem.getDescription() + ", Apricot Jelly");
        }

        if (foodItem.getDescription() == "Pastry Roll")
        {
            newDescription = (foodItem.getDescription() +  ", Cream Cheese");
        }

        if (foodItem.getDescription() == "Spring Roll")
        {
            newDescription = (foodItem.getDescription() + ", Ground Pork");
        }

        if (foodItem.getDescription() == "Sausage Roll")
        {
            newDescription = (foodItem.getDescription() + ", Italian Sausage");
        }

        return (foodItem.getDescription() + newDescription);

    }

    public double cost()
    {
       return (foodItem.cost() + 1.50);
    }

    
}
