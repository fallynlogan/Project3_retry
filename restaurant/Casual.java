package restaurant;
import java.util.*; 

public class Casual extends Customer{

    public Casual(String n){
        Random rand = new Random();
        this.name = n;
        this.rollsWanted = rand.nextInt(3)+1;
    }

    public void calculateInitialOrder(){
        Random rand = new Random();

        initialOrder = new FoodItem[this.rollsWanted];
        for(int i=0 ; i<this.rollsWanted ; i++){
            int randomRollType = rand.nextInt(5) + 1;
            if(randomRollType==1){
                initialOrder[i] = new SpringRoll();
            }
            if(randomRollType==2){
                initialOrder[i] = new EggRoll();
            }
            if(randomRollType==3){
                initialOrder[i] = new PastryRoll();
            }
            if(randomRollType==4){
                initialOrder[i] = new SausageRoll();
            }
            if(randomRollType==5){
                initialOrder[i] = new JellyRoll();
            }
        }
    }

    public void purchaseRoll(){
        Random rand = new Random();

        rollOrder = new FoodItem[this.rollsWanted];
        initialOrder = new FoodItem[this.rollsWanted];

        int currentRollInventoryVal = 0;       //value to save the inventory amount of a specific roll for comparison

        int index=0;        //rollOrder index
        boolean finish = false;   //set to true when all possible rolls have been purchased

        calculateInitialOrder();
        currentEvent = "desired order";
        notifyObservers();

        while(!finish){
            if(initialOrder[index].getDescription()=="Spring Roll"){
                if(Store.inventory.get("numSprRolls")>0){
                    rollOrder[index] = initialOrder[index];
                    index++;
                }
                else{
                    this.currentEvent = "";
                }
            }
            else if(initialOrder[index].getDescription()=="Egg Roll"){
                if(Store.inventory.get("numSprRolls")>0){
                    rollOrder[index] = initialOrder[index];
                    index++;
                }
            }
            else if(initialOrder[index].getDescription()=="Pastry Roll"){
                if(Store.inventory.get("numSprRolls")>0){
                    rollOrder[index] = initialOrder[index];
                    index++;
                }
            }
            else if(initialOrder[index].getDescription()=="Sausage Roll"){
                if(Store.inventory.get("numSprRolls")>0){
                    rollOrder[index] = initialOrder[index];
                    index++;
                }
            }
            else if(initialOrder[index].getDescription()=="Jelly Roll"){
                if(Store.inventory.get("numSprRolls")>0){
                    rollOrder[index] = initialOrder[index];
                    index++;
                }
            }
            if(index==rollsWanted){
                finish = true;
            }
            if(checkInventorySoldOut()){
                currentEvent = "sold out all rolls";
                notifyObservers();
                finish = true;
            }
        }
        currentEvent = "actual order";
        notifyObservers();

        /*while(!finish){
            int randomRollType = rand.nextInt(5) + 1;
            if(randomRollType==1){
                if(j<rollsWanted){
                    initialOrder[j] = new SpringRoll(); j++;
                    currentRollInventoryVal = Store.inventory.get("numSprRolls");
                    if(currentRollInventoryVal>0){
                        rollOrder[i] = new SpringRoll();
                        Store.inventory.put("numSprRolls",currentRollInventoryVal-1);
                        i++; currentRollsInOrder++;
                    }
                    else{
                        currentEvent = "casual order modified";
                        notifyObservers();
                    }
                }
            }
            if(randomRollType==2){
                if(j<rollsWanted){
                    initialOrder[j] = new EggRoll(); j++;
                    currentRollInventoryVal = Store.inventory.get("numEggRolls");
                    if(currentRollInventoryVal>0){
                        rollOrder[i] = new EggRoll();
                        Store.inventory.put("numEggRolls",currentRollInventoryVal-1);
                        i++; currentRollsInOrder++;
                    }
                    else{
                        currentEvent = "casual order modified";
                        notifyObservers();
                    }
                }
            }
            if(randomRollType==3){
                if(j<rollsWanted){
                    initialOrder[j] = new PastryRoll(); j++;
                    currentRollInventoryVal = Store.inventory.get("numPastryRolls");
                    if(currentRollInventoryVal>0){
                        rollOrder[i] = new PastryRoll();
                        Store.inventory.put("numPastryRolls",currentRollInventoryVal-1);
                        i++; currentRollsInOrder++;
                    }
                    else{
                        currentEvent = "casual order modified";
                        notifyObservers();
                    }
                }
            }
            if(randomRollType==4){
                if(j<rollsWanted){
                    initialOrder[j] = new SausageRoll(); j++;
                    currentRollInventoryVal = Store.inventory.get("numSausageRolls");
                    if(currentRollInventoryVal>0){
                        rollOrder[i] = new SausageRoll();
                        Store.inventory.put("numSausageRolls",currentRollInventoryVal-1);
                        i++; currentRollsInOrder++;
                    }
                    else{
                        currentEvent = "casual order modified";
                        notifyObservers();
                    }
                }
            }
            if(randomRollType==5){
                if(j<rollsWanted){
                    initialOrder[j] = new JellyRoll(); j++;
                    currentRollInventoryVal = Store.inventory.get("numJellyRolls");
                    if(currentRollInventoryVal>0){
                        rollOrder[i] = new JellyRoll();
                        Store.inventory.put("numJellyRolls",currentRollInventoryVal-1);
                        i++; currentRollsInOrder++;
                    }
                    else{
                        currentEvent = "casual order modified";
                        notifyObservers();
                    }
                }
            }
            if(currentRollInventoryVal==1){
                currentEvent = "sold out single roll";
                notifyObservers();
            }
            if(currentRollsInOrder==rollsWanted){
                finish = true;
            }
            if(checkInventorySoldOut()){
                currentEvent = "sold out all rolls";
                notifyObservers();
                finish = true;
            }
        }
        currentEvent = "desired order";
        notifyObservers();
        currentEvent = "actual order";
        notifyObservers();*/
    }
}
