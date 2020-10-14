package restaurant;
import java.util.*; 

public class Casual extends Customer{

    public Casual(String n){
        Random rand = new Random();
        this.name = n;
        this.rollsWanted = rand.nextInt(3)+1;
        this.numRollsBought = 0;
    }

    public void calculateInitialOrder(){
        Random rand = new Random();

        initialOrder = new FoodItem[rollsWanted];
        for(int i=0 ; i<rollsWanted ; i++){
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

        rollOrder = new FoodItem[rollsWanted];

        calculateInitialOrder();
        currentEvent = "desired order";
        notifyObservers();

        int index=0;        // current rollOrder index

        /*while(index<rollsWanted){
            int currentRollInventoryVal;       //value to save the inventory amount of a specific roll type
            if(initialOrder[index].getDescription()=="Spring Roll"){
                currentRollInventoryVal = Store.inventory.get("numSprRolls");
                if(currentRollInventoryVal==1){
                    Store.inventory.put("numSprRolls",0);
                    currentEvent = "sold out single roll";
                    notifyObservers();
                    numRollsBought++;
                }
                else if(currentRollInventoryVal>0){
                    Store.inventory.put("numSprRolls",currentRollInventoryVal-1);
                    rollOrder[index] = initialOrder[index];
                    numRollsBought++;
                }
                else if(currentRollInventoryVal==0){
                    currentEvent = "casual order modified";
                    notifyObservers();
                    index--;
                }
            }
            else if(initialOrder[index].getDescription()=="Egg Roll"){
                currentRollInventoryVal = Store.inventory.get("numEggRolls");
                if(currentRollInventoryVal==1){
                    Store.inventory.put("numEggRolls",0);
                    currentEvent = "sold out single roll";
                    notifyObservers();
                    numRollsBought++;
                }
                else if(currentRollInventoryVal>0){
                    Store.inventory.put("numEggRolls",currentRollInventoryVal-1);
                    rollOrder[index] = initialOrder[index];
                    numRollsBought++;
                }
                else if(currentRollInventoryVal==0){
                    currentEvent = "casual order modified";
                    notifyObservers();
                    index--;
                }
            }
            else if(initialOrder[index].getDescription()=="Pastry Roll"){
                currentRollInventoryVal = Store.inventory.get("numPastryRolls");
                if(currentRollInventoryVal==1){
                    Store.inventory.put("numPastryRolls",0);
                    currentEvent = "sold out single roll";
                    notifyObservers();
                    numRollsBought++;
                }
                else if(currentRollInventoryVal>0){
                    Store.inventory.put("numPastryRolls",currentRollInventoryVal-1);
                    rollOrder[index] = initialOrder[index];
                    numRollsBought++;
                }
                else if(currentRollInventoryVal==0){
                    currentEvent = "casual order modified";
                    notifyObservers();
                    index--;
                }
            }
            else if(initialOrder[index].getDescription()=="Sausage Roll"){
                currentRollInventoryVal = Store.inventory.get("numSausageRolls");
                if(currentRollInventoryVal==1){
                    Store.inventory.put("numSausageRolls",0);
                    currentEvent = "sold out single roll";
                    notifyObservers();
                    numRollsBought++;
                }
                else if(currentRollInventoryVal>0){
                    Store.inventory.put("numSausageRolls",currentRollInventoryVal-1);
                    rollOrder[index] = initialOrder[index];
                    numRollsBought++;
                }
                else if(currentRollInventoryVal==0){
                    currentEvent = "casual order modified";
                    notifyObservers();
                    index--;
                }
            }
            else if(initialOrder[index].getDescription()=="Jelly Roll"){
                currentRollInventoryVal = Store.inventory.get("numJellyRolls");
                if(currentRollInventoryVal==1){
                    Store.inventory.put("numJellyRolls",0);
                    currentEvent = "sold out single roll";
                    notifyObservers();
                    numRollsBought++;
                }
                else if(currentRollInventoryVal>0){
                    Store.inventory.put("numJellyRolls",currentRollInventoryVal-1);
                    rollOrder[index] = initialOrder[index];
                    numRollsBought++;
                }
                else if(currentRollInventoryVal==0){
                    currentEvent = "casual order modified";
                    notifyObservers();
                    index--;
                }
            }
            index++;
        }
        currentEvent = "actual order";
        notifyObservers();*/


        //First Attempt
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
