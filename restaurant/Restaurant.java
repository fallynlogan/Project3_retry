package restaurant;
import java.util.*;

public class Restaurant {
    public static HashMap<String, Integer> inventory;
    private HashMap<String, ArrayList<Customer>> dailyCustomers;
    private List<Observer> observers = new ArrayList<Observer>();
    public Cashier cashier;
    public static HashMap<Customer,ArrayList<FoodItem>> dailyCustomerOrders;


    public Restaurant(int numDays, int numRolls)
    {
        inventory = new HashMap<String, Integer>();
        inventory.put("Egg Roll", numRolls);
        inventory.put("Sausage Roll", numRolls);
        inventory.put("Spring Roll", numRolls);
        inventory.put("Pastry Roll", numRolls);
        inventory.put("Jelly Roll", numRolls);

        cashier = new Cashier(this);

        System.out.println("---------- Welcome to Molly's Mouthwatering Rolls! The simulation is about to begin... ----------\n\n");
        for(int i=1 ; i<=numDays ; i++)
        {
            //Day number
            System.out.println("Today is Day " + i + ".");
            //reset rolls at beggining of day if they are 0
            if(inventory.get("Spring Roll")==0){
                inventory.put("Spring Roll", numRolls);
            }
            if(inventory.get("Egg Roll")==0){
                inventory.put("Egg Roll", numRolls);
            }
            if(inventory.get("Pastry Roll")==0){
                inventory.put("Pastry Roll", numRolls);
            }
            if(inventory.get("Sausage Roll")==0){
                inventory.put("Sausage Roll", numRolls);
            }
            if(inventory.get("Jelly Roll")==0){
                inventory.put("Jelly Roll", numRolls);
            }
            //Rolls in inventory at the start of the day by type
            System.out.println("Initial Spring Rolls: " + inventory.get("Spring Roll"));
            System.out.println("Initial Egg Rolls: " + inventory.get("Egg Roll"));
            System.out.println("Initial Pastry Rolls: " + inventory.get("Pastry Roll"));
            System.out.println("Initial Sausage Rolls: " + inventory.get("Sausage Roll"));
            System.out.println("Initial Jelly Rolls: " + inventory.get("Jelly Roll"));
            System.out.println("\n====================================================================================================\n");

            dailyCustomerOrders = new HashMap<Customer,ArrayList<FoodItem>>();
            cashier.resetDailyReportValues();

            //get dailyCustomers
            dailyCustomers = CustomerFactory.getCustomers();
            Iterator<Map.Entry<String, ArrayList<Customer>>> it = dailyCustomers.entrySet().iterator();
            while(it.hasNext())
            {
                Map.Entry<String, ArrayList<Customer>> pair = it.next();
                ArrayList<Customer> customers = pair.getValue();
                customers.forEach((customer) -> customer.purchase(this));

                if(checkInventorySoldOut())
                {
                    notifyAllObservers();
                    cashier.printDailyReport(i);
                    System.out.println("\n================================Store Closing All Sold Out!====================================\n");
                    break;
                }
            }
            //print out the inventory at the end of each day by type
            System.out.println("\nInventory at the end of Day " + i + ".");
            System.out.println("Leftover Spring Rolls: " + inventory.get("Spring Roll"));
            System.out.println("Leftover Egg Rolls: " + inventory.get("Egg Roll"));
            System.out.println("Leftover Pastry Rolls: " + inventory.get("Pastry Roll"));
            System.out.println("Leftover Sausage Rolls: " + inventory.get("Sausage Roll"));
            System.out.println("Leftover Jelly Rolls: " + inventory.get("Jelly Roll"));
            notifyAllObservers();
            cashier.printDailyReport(i);
            //System.out.println("\n====================================================================================================\n");
        }
        System.out.println("\n============================================End Simulation==========================================\n");
        System.out.println("\n====================================================================================================\n");
        cashier.printLifetimeReport();
    }

    public void requestPurchase(HashMap<String, Integer> purchase, Customer c) throws OrderNotFilledException
    {
        HashMap<String, Integer> tempInventory = inventory;
        HashMap<String, Integer> purchaseCopy = new HashMap<String, Integer>(purchase);
        Iterator<Map.Entry<String, Integer>> it = purchase.entrySet().iterator();
        boolean successful = true;
        while (it.hasNext())
        {
            HashMap.Entry<String, Integer> pair = it.next();
            while(purchase.get(pair.getKey()) >  0)
            {
                if(tempInventory.get(pair.getKey()) > 0)
                {
                    tempInventory.put(pair.getKey(), tempInventory.get(pair.getKey()) - 1);
                    purchase.put(pair.getKey(), purchase.get(pair.getKey()) - 1);
                } else {
                    successful = false;
                    break;
                }
            }
        }
        if(!successful)
        {
            throw new OrderNotFilledException(purchase, tempInventory);
        } else {
            inventory = tempInventory;
            makeRolls(purchaseCopy,c);
        }
    }

    public void makeRolls(HashMap<String, Integer> purchase, Customer c)
    {
        ArrayList<FoodItem> rolls = new ArrayList<FoodItem>();  //current roll order
        Iterator<Map.Entry<String, Integer>> it = purchase.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<String, Integer> pair = it.next();
            int numOfRolls = pair.getValue();
            for(int i = 0; i < numOfRolls; i++)
            {
                if(pair.getKey() == "Egg Roll")
                {
                    rolls.add(new EggRoll());
                }
                if(pair.getKey() == "Spring Roll")
                {
                    rolls.add(new SpringRoll());
                }
                if(pair.getKey() == "Sausage Roll")
                {
                    rolls.add(new SausageRoll());
                }
                if(pair.getKey() == "Pastry Roll")
                {
                    rolls.add(new PastryRoll());
                }
                if(pair.getKey() == "Jelly Roll")
                {
                    rolls.add(new JellyRoll());
                }
            }
        }
        //System.out.println("order: " +  rolls);
        decorateRolls(rolls);
        dailyCustomerOrders.put(c,rolls);
    }

    public void decorateRolls(ArrayList<FoodItem> order)
    {
        String[] fillings = {" Cream Cheese Filling", " Apricot Jelly Filling", " Italian Sausage Filling", " Shredded Beef Filling", " Ground Pork Filling"};
        String[] sauces = {" Peanut Sauce", " Sweet & Sour Sauce", " Marinara Sauce", " Cranberry Sauce", " Dark Chocolate Sauce"};
        String[] toppings = {" Shredded Cabbage Topping", " Shredded Carrots Topping", " Fruit Preserves Topping", " Mozzarella Cheese Topping", " Powdered Sugar Topping"};

        //go through each element in array list
        for(int i = 0; i< order.size(); i++)
        {
            //choose random number for num of extras
            int numToppings = new Random().nextInt(2);
            int numSauces = new Random().nextInt(3);
            int numFillings = new Random().nextInt(1);
            //get a topping
            int topping = new Random().nextInt(toppings.length);
            int sauce = new Random().nextInt(sauces.length);
            int filling = new Random().nextInt(fillings.length);
            //get list element
            FoodItem roll = order.get(i);
            //wrap in however many toppings
            for(int j = 0; j < numToppings; j++)
            {

                roll = new ToppingDecorator(roll, toppings[topping]);
            }
            //wrap in however many sauces
            for(int j = 0; j < numSauces; j++)
            {

                roll = new SauceDecorator(roll, sauces[sauce]);
            }
            //wrap in however many fillings
            for(int j = 0; j < numFillings; j++)
            {

                roll = new SauceDecorator(roll, fillings[filling]);
            }
            order.set(i,roll);
            System.out.println(roll.getDescription() + " " + roll.cost());
        }

    }


    public Boolean checkInventorySoldOut()
    {
        Iterator<Map.Entry<String, Integer>> it = inventory.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<String, Integer> pair = it.next();
            if(pair.getValue() > 0)
            {
                return false;
            }
        }
        notifyAllObservers();
        return true;
    }

    //subject stuff
    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }

}