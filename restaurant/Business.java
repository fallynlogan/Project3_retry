package restaurant;

public class Business extends Customer {

    public Business(String n){
        this.name = n;
        this.rollsWanted = 10;
        this.numRollsBought = 0;
    }

    private boolean isCompleteOrder(){
        boolean x = true;

        if(Store.inventory.get("numSprRolls") < 2) { x = false; }
        if(Store.inventory.get("numEggRolls") < 2) { x = false; }
        if(Store.inventory.get("numPastryRolls") < 2) { x = false; }
        if(Store.inventory.get("numSausageRolls") < 2) { x = false; }
        if(Store.inventory.get("numJellyRolls") < 2) { x = false; }

        return x;
    }

    public void purchaseRoll(){

        if(!isCompleteOrder()){
            this.currentEvent = "business order failed";
            notifyObservers();
        }
        else{
            this.rollOrder = new FoodItem[this.rollsWanted];

            this.rollOrder[0] = new SpringRoll(); this.rollOrder[1] = new SpringRoll();
            this.rollOrder[2] = new EggRoll(); this.rollOrder[3] = new EggRoll();
            this.rollOrder[4] = new PastryRoll(); this.rollOrder[5] = new PastryRoll();
            this.rollOrder[6] = new SausageRoll(); this.rollOrder[7] = new SausageRoll();
            this.rollOrder[8] = new JellyRoll(); this.rollOrder[9] = new JellyRoll();

            for(int i=0 ; i<this.rollsWanted ; i++){
                rollOrder[i] = new SauceDecorator(rollOrder[i]);
                rollOrder[i] = new FillingDecorator(rollOrder[i]);
                rollOrder[i] = new ToppingDecorator(rollOrder[i]);
            }

            numRollsBought = 10;

            this.currentEvent = "actual order";
            notifyObservers();

            if(Store.inventory.get("numSprRolls")==2){
                this.currentEvent = "sold out single roll";
                this.soldOutName = "Spring Roll";
                notifyObservers();
            }
            if(Store.inventory.get("numEggRolls")==2){
                this.currentEvent = "sold out single roll";
                this.soldOutName = "Egg Roll";
                notifyObservers();
            }
            if(Store.inventory.get("numPastryRolls")==2){
                this.currentEvent = "sold out single roll";
                this.soldOutName = "Pastry Roll";
                notifyObservers();
            }
            if(Store.inventory.get("numSausageRolls")==2){
                this.currentEvent = "sold out single roll";
                this.soldOutName = "Sausage Roll";
                notifyObservers();
            }
            if(Store.inventory.get("numJellyRolls")==2){
                this.currentEvent = "sold out single roll";
                this.soldOutName = "Jelly Roll";
                notifyObservers();
            }

            int currentRollInventoryVal = Store.inventory.get("numSprRolls"); Store.inventory.put("numSprRolls",currentRollInventoryVal-2);
            currentRollInventoryVal = Store.inventory.get("numEggRolls"); Store.inventory.put("numEggRolls",currentRollInventoryVal-2);
            currentRollInventoryVal = Store.inventory.get("numPastryRolls"); Store.inventory.put("numPastryRolls",currentRollInventoryVal-2);
            currentRollInventoryVal = Store.inventory.get("numSausageRolls"); Store.inventory.put("numSausageRolls",currentRollInventoryVal-2);
            currentRollInventoryVal = Store.inventory.get("numJellyRolls"); Store.inventory.put("numJellyRolls",currentRollInventoryVal-2);


        }
    }
}
