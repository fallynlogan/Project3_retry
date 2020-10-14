package restaurant;

public abstract class FoodItem {
    protected String rollName; 
    protected double rollPrice;

    String description = "Unknown FoodItem";

    public String getDescription()
    {
        return description;
    }

    public abstract double cost();
    
}
