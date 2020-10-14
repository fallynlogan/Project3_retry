package restaurant;

public class Business extends Customer {

    public Business(String n){
        this.name = n;
        this.rollsWanted = 10;
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

            int currentRollInventoryVal = Store.inventory.get("numSprRolls"); Store.inventory.put("numSprRolls",currentRollInventoryVal-2);
            currentRollInventoryVal = Store.inventory.get("numEggRolls"); Store.inventory.put("numEggRolls",currentRollInventoryVal-2);
            currentRollInventoryVal = Store.inventory.get("numPastryRolls"); Store.inventory.put("numPastryRolls",currentRollInventoryVal-2);
            currentRollInventoryVal = Store.inventory.get("numSausageRolls"); Store.inventory.put("numSausageRolls",currentRollInventoryVal-2);
            currentRollInventoryVal = Store.inventory.get("numJellyRolls"); Store.inventory.put("numJellyRolls",currentRollInventoryVal-2);

            for(int i=0 ; i<this.rollsWanted ; i++){
                FoodItem temp = new ToppingDecorator(new FillingDecorator(new SauceDecorator(rollOrder[i])));
                rollOrder[i] = temp;
            }

            this.currentEvent = "actual order";
            notifyObservers();
        }
    }
}
