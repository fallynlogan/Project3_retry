package restaurant;

public class SauceDecorator extends ExtraDecorator {
    FoodItem foodItem;
    String newDescription = "";

    public SauceDecorator(FoodItem foodItem)
    {
        this.foodItem = foodItem;
    }


    @Override
    public String getDescription()
    {
        if (foodItem.getDescription() == "Spring Roll") {
            newDescription = (" Peanut Sauce");
        }

        if (foodItem.getDescription() == "Egg Roll") {
            newDescription = (" Sweet & Sour Sauce");
        }

        if (foodItem.getDescription() == "Pastry Roll") {
            newDescription = (" Dark Chocolate Sauce");
        }

        if (foodItem.getDescription() == "Sausage Roll") {
            newDescription = (" Marinara Sauce");
        }

        if (foodItem.getDescription() == "Jelly Roll") {
            newDescription = (" Cranberry Sauce");
        }

        return (foodItem.getDescription() + newDescription);

    }

    public double cost()
    {
       return (foodItem.cost() + 1.00);
    }
    
}
