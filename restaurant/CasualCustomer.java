package restaurant;

import java.util.*;

public class CasualCustomer implements Customer {

    @Override
    public void purchase(Restaurant restaurant) {
        while(true)
        {
            if(restaurant.checkInventorySoldOut()){
                break;
            }
            HashMap<String, Integer> purchase = new HashMap<String, Integer>();
            try
            {
                String[] rolls = {"Spring Roll", "Egg Roll", "Sausage Roll", "Pastry Roll", "Jelly Roll"};
                int rnd = new Random().nextInt(rolls.length);
                int numRolls = new Random().nextInt(3) + 1;
                String rollType = rolls[rnd];
                purchase.put(rollType, numRolls);
                System.out.println("Casual Customer: ");
                System.out.println("Original Purchase: " + purchase);
                restaurant.requestPurchase(purchase,this);
                break;
            } catch(OrderNotFilledException ex)
            {
                System.out.println("CASUAL ORDER NOT FULFILLED");
                HashMap<String, Integer> remainingOrderItems = ex.getRemainingOrderItems();
                HashMap<String, Integer> remainingInventoryItems = ex.getRemainingInventoryItems();
                // assuming only one thing in the hashmap, get that thing
                Map.Entry<String, Integer> pair = purchase.entrySet().iterator().next();
                HashMap<String, Integer> newOrder = new HashMap<String, Integer>();
                restaurant.cashier.casualRollOutages++;
                // case: requesting 3 rolls of type X, but only 2/1 rolls of type X in inventory.
                if(purchase.get(pair.getKey()) > remainingOrderItems.get(pair.getKey()))
                {
                    newOrder.put(pair.getKey(), Math.min(remainingInventoryItems.get(pair.getKey()), 3));
                    purchase = newOrder;
                    break;
                }
                // case: our requested roll has 0 stock in the inventory
                Iterator<Map.Entry<String, Integer>> it2 = remainingInventoryItems.entrySet().iterator();

                while(it2.hasNext())
                {
                    Map.Entry<String, Integer> pair2 = it2.next();
                    if(pair2.getValue() > 0)
                    {
                        newOrder.put(pair2.getKey(), Math.min(remainingInventoryItems.get(pair2.getKey()), 3));
                        purchase = newOrder;
                        break;
                    }
                }
            }
        }

    }
}