package restaurant;

public abstract class Customer {
    protected String name;
    public String getName() { return name; }
    protected int rollsWanted;
    public int getRollsWanted() { return rollsWanted; }

    protected String currentEvent;     //observer event flag
    public String getCurrentEvent(){
        return currentEvent;
    }

    public Boolean checkInventorySoldOut()
    {
        int springRoll, eggRoll, pastryRoll, sausageRoll, jellyRoll;
        springRoll = Store.inventory.get("numSprRolls");
        eggRoll = Store.inventory.get("numEggRolls");
        pastryRoll = Store.inventory.get("numPastryRolls");
        sausageRoll = Store.inventory.get("numSausageRolls");
        jellyRoll = Store.inventory.get("numJellyRolls");
        if(springRoll==0 && eggRoll==0 && pastryRoll==0 && sausageRoll==0 && jellyRoll==0)
        {
            System.out.println("THE STORE IS CURRENTLY SOLD OUT OF ROLLS AND IS CLOSING! See you tomorrow!");
            return true;
        }
        else
        {
            return false;
        }
    }

    public FoodItem[] rollOrder;
    public double totalOrderCost = 0.0;

    public abstract void purchaseRoll();

}
