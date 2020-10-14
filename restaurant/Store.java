package restaurant;
import java.util.*; 

public class Store {
    public static HashMap<String, Integer> inventory;
    public static int rollStartCount = 30;
    public static int dayNumber = 0;
    public static Customer[] customers;
    public static Bookkeeper bookkeeper;
    public static Announcer announcer;

    public Store(int numDays) 
    {
        inventory = new HashMap<String, Integer>();
        inventory.put("numSprRolls", rollStartCount);
        inventory.put("numEggRolls", rollStartCount);
        inventory.put("numPastryRolls",rollStartCount);
        inventory.put("numSausageRolls", rollStartCount);
        inventory.put("numJellyRolls", rollStartCount);
        
        FoodItem springRoll  = new SpringRoll();
        springRoll =  new ToppingDecorator(springRoll);
        System.out.println(springRoll.getDescription() + " $" + springRoll.cost());

        bookkeeper = new Bookkeeper();
        announcer = new Announcer();

        System.out.println("---------- Welcome to Molly's Mouthwatering Rolls! The simulation is about to begin... ----------\n\n");
        for(int i=1 ; i<=numDays ; i++)
        {
            customers = CustomerFactory.createDailyCustomers();
            //bookkeeper.resetDailyValues();
            //print out each day number
            System.out.println("Today is Day " + i + ".");
            //at the start of each day if the roll is out of stock reset count to 30 (make more)
            if(inventory.get("numSprRolls")==0){
                inventory.put("numSprRolls",rollStartCount);
            }
            if(inventory.get("numEggRolls")==0){
                inventory.put("numEggRolls",rollStartCount);
            }
            if(inventory.get("numPastryRolls")==0){
                inventory.put("numPastryRolls",rollStartCount);
            }
            if(inventory.get("numSausageRolls")==0){
                inventory.put("numSausageRolls",rollStartCount);
            }
            if(inventory.get("numJellyRolls")==0){
                inventory.put("numJellyRolls",rollStartCount);
            }

            //print out the inventory at the start of each day
            System.out.println("Initial Spring Rolls: " + inventory.get("numSprRolls"));
            System.out.println("Initial Egg Rolls: " + inventory.get("numEggRolls"));
            System.out.println("Initial Pastry Rolls: " + inventory.get("numPastryRolls"));
            System.out.println("Initial Sausage Rolls: " + inventory.get("numSausageRolls"));
            System.out.println("Initial Jelly Rolls: " + inventory.get("numJellyRolls"));
            System.out.println("\n====================================================================================================\n");

            for(int j=0 ; j<customers.length ; j++){
                announcer.currentCustomer = customers[j];
                bookkeeper.currentCustomer = customers[j];
                customers[j].arrive();
                customers[j].purchaseRoll();

                if(checkInventorySoldOut()){
                    customers[j].sold_out();
                    bookkeeper.earlyClosure = true;
                    System.out.println("\n====================================================================================================\n");
                    break;
                }
                customers[j].leave();
                System.out.println("\n====================================================================================================\n");
            }
            bookkeeper.printDailyReport(i);

            //print out the inventory at the end of each day
            //System.out.println("\nInventory at the end of Day " + i + ".");
            //System.out.println("Leftover Spring Rolls: " + inventory.get("numSprRolls"));
            //System.out.println("Leftover Egg Rolls: " + inventory.get("numEggRolls"));
            //System.out.println("Leftover Pastry Rolls: " + inventory.get("numPastryRolls"));
            //System.out.println("Leftover Sausage Rolls: " + inventory.get("numSausageRolls"));
            //System.out.println("Leftover Jelly Rolls: " + inventory.get("numJellyRolls"));
            System.out.println("\n====================================================================================================\n");


        }

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
            return true;
        }
        else
        {
            return false;
        }

    }

}
