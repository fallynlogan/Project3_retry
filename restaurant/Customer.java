package restaurant;

public abstract class Customer {
    protected String name;
    public String getName() { return name; }
    protected int rollsWanted;
    public int getRollsWanted() { return rollsWanted; }

    protected String currentEvent;    //observer event flag
    public String getCurrentEvent(){
        return currentEvent;
    }

    public void arrive()
    {
        this.currentEvent = "arrival";
        notifyObservers();
    }

    public void leave()
    {
        this.currentEvent = "leave store";
        notifyObservers();
    }

    public void sold_out()
    {
        this.currentEvent = "sold out all rolls";
        notifyObservers();
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
