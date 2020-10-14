package restaurant;
import java.util.*; 

public class Store {
    public static HashMap<String, Integer> inventory;
    private Integer rollStartCount = 5;
    public Customer[] customers;
    public static Bookkeeper bookkeeper;
    public static Announcer announcer;


    public Store(int numDays) {
        Random rand = new Random();
        inventory = new HashMap<String, Integer>();
        inventory.put("numSprRolls", rollStartCount);
        inventory.put("numEggRolls", rollStartCount);
        inventory.put("numPastryRolls",rollStartCount);
        inventory.put("numSausageRolls", rollStartCount);
        inventory.put("numJellyRolls", rollStartCount);
        int rollsWanted = 0;

        System.out.println("---------- Welcome to Molly's Mouthwatering Rolls! The simulation is about to begin... ----------\n\n");
        for(int i=1 ; i<=numDays ; i++)
        {
            customers = CustomerFactory.createDailyCustomers();
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
                System.out.println(customers[j].getName() + " the " + customers[j].getClass().getSimpleName() + " Customer has arrived at the store!");
                System.out.println("\n====================================================================================================\n");
            }

            //print out the inventory at the end of each day
            System.out.println("\nInventory at the end of Day " + i + ".");
            System.out.println("Leftover Spring Rolls: " + inventory.get("numSprRolls"));
            System.out.println("Leftover Egg Rolls: " + inventory.get("numEggRolls"));
            System.out.println("Leftover Pastry Rolls: " + inventory.get("numPastryRolls"));
            System.out.println("Leftover Sausage Rolls: " + inventory.get("numSausageRolls"));
            System.out.println("Leftover Jelly Rolls: " + inventory.get("numJellyRolls"));
            System.out.println("\n====================================================================================================\n");
        }

    }
}
