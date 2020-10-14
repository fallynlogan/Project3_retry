package restaurant;

public abstract class Customer {
    protected String name;
    public String getName() { return name; }
    public FoodItem[] rollOrder;
    public double totalOrderCost = 0.0;

}
