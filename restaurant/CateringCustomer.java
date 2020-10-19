package restaurant;

import java.util.*;

public class CateringCustomer implements Customer {

    @Override
    public void purchase(Restaurant restaurant) {
        HashMap<String, Integer> purchase = new HashMap<String, Integer>();
        Random rand = new Random();
        List<String> rolls = Arrays.asList("Spring Roll", "Egg Roll", "Sausage Roll", "Pastry Roll", "Jelly Roll");

        while(true)
        {
            Collections.shuffle(rolls,rand);
            String roll1 = rolls.get(0);
            String roll2 = rolls.get(1);
            String roll3 = rolls.get(2);
            purchase.put(roll1, 5);
            purchase.put(roll2, 5);
            purchase.put(roll3, 5);
            System.out.println("Catering Customer: ");
            System.out.println("Original Purchase: " + purchase);
            try
            {
                restaurant.requestPurchase(purchase,this);
                break;
            } catch(OrderNotFilledException ex)
            {
                HashMap<String, Integer> remainingOrderItems = ex.getRemainingOrderItems();
                HashMap<String, Integer> remainingInventoryItems = ex.getRemainingInventoryItems();
                HashMap<String, Integer> newOrder = new HashMap<String, Integer>();
                int rollsNeeded = 0;
                restaurant.cashier.cateringRollOutages++;

                Iterator<Map.Entry<String, Integer>> it = remainingOrderItems.entrySet().iterator();
                while (it.hasNext())
                {
                    Map.Entry<String, Integer> pair = it.next();
                    newOrder.put(pair.getKey(), purchase.get(pair.getKey()));
                    rollsNeeded += pair.getValue();
                }

                Iterator<Map.Entry<String, Integer>> it2 = remainingInventoryItems.entrySet().iterator();
                while (it2.hasNext() && rollsNeeded > 0)
                {
                    Map.Entry<String, Integer> pair = it2.next();
                    if(pair.getValue() > 0)
                    {
                        if(pair.getValue() - rollsNeeded >= 0 )
                        {
                            newOrder.put(pair.getKey(), rollsNeeded);
                            rollsNeeded --;
                            break;
                        }
                        else
                        {
                            newOrder.put(pair.getKey(), pair.getValue());
                            rollsNeeded -= pair.getValue();
                            break;
                        }
                    }
                }

                if(rollsNeeded > 0)
                {
                    //This isnt working right
                    System.out.println("NOT ENOUGH INVENTORY TO FILL CATERING ORDER");
                    System.out.println("====================================================================================================");
                    break;
                }
                purchase = newOrder;
            }
        }

    }

}