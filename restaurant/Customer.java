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
    public FoodItem[] initialOrder;
    public double totalOrderCost = 0.0;

    public void getInitialOrder(){
        int springCount=0 ; int eggCount=0 ; int pastryCount=0 ; int sausageCount=0 ; int jellyCount=0;
        for(int i=0 ; i<initialOrder.length ; i++){
            if(initialOrder[i].getDescription()=="Spring Roll"){ springCount++; }
            if(initialOrder[i].getDescription()=="Egg Roll"){ eggCount++; }
            if(initialOrder[i].getDescription()=="Pastry Roll"){ pastryCount++; }
            if(initialOrder[i].getDescription()=="Sausage Roll"){ sausageCount++; }
            if(initialOrder[i].getDescription()=="Jelly Roll"){ jellyCount++; }
        }
        String initialOrderString = "";
        /*if(springCount>0) { */initialOrderString += (springCount + " Spring, "); //}
        /*if(eggCount>0) { */initialOrderString += (eggCount + " Egg, "); //}
        /*if(pastryCount>0) {*/ initialOrderString += (pastryCount + " Pastry, "); //}
        /*if(sausageCount>0) { */initialOrderString += (sausageCount + " Sausage, & "); //}
        /*if(jellyCount>0) { */initialOrderString += (jellyCount + " Jelly Roll(s)"); //}
        System.out.println(this.getName() + " wants to purchase " + initialOrderString);
    }

    public void notifyObservers(){
        Store.announcer.update();
        Store.bookkeeper.update();
    }


    public abstract void purchaseRoll();

}
