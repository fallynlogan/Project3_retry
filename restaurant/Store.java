package restaurant;
import java.util.*; 

public class Store {
    public static HashMap<String, Integer> inventory;
    private Integer rollStartCount = 2;

    public Store(int numDays) {
        Random rand = new Random();
        inventory = new HashMap<String, Integer>();
        inventory.put("numSprRolls", rollStartCount);
        inventory.put("numEggRolls", rollStartCount);
        inventory.put("numPastryRolls",rollStartCount);
        inventory.put("numSausageRolls", rollStartCount);
        inventory.put("numJellyRolls", rollStartCount);
        int rollsWanted = 0;

        /*MyUnitTests unitTests = new MyUnitTests();
        unitTests.eggRollCountTest();
        unitTests.eggRollPriceTest();
        unitTests.pastryRollCountTest();
        unitTests.pastryRollPriceTest();
        unitTests.jellyRollCountTest();
        unitTests.jellyRollPriceTest();
        unitTests.sausageRollCountTest();
        unitTests.sausageRollPriceTest();
        unitTests.springRollCountTest();
        unitTests.springRollPriceTest();*/

        System.out.println("---------- Welcome to Molly's Mouthwatering Rolls! The simulation is about to begin... ----------\n\n");
        for(int i=1 ; i<=numDays ; i++)
        {
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
            System.out.println("Spring Roll Stock: " + inventory.get("numSprRolls"));
            System.out.println("Egg Roll Stock: " + inventory.get("numEggRolls"));
            System.out.println("Pastry Roll Stock: " + inventory.get("numPastryRolls"));
            System.out.println("Sausage Roll Stock: " + inventory.get("numSausageRolls"));
            System.out.println("Jelly Roll Stock: " + inventory.get("numJellyRolls"));
            System.out.println("\n====================================================================================================\n");

            //print out the inventory at the end of each day
            System.out.println("\nInventory at the end of Day " + i + ".");
            System.out.println("Spring Roll Stock: " + inventory.get("numSprRolls"));
            System.out.println("Egg Roll Stock: " + inventory.get("numEggRolls"));
            System.out.println("Pastry Roll Stock: " + inventory.get("numPastryRolls"));
            System.out.println("Sausage Roll Stock: " + inventory.get("numSausageRolls"));
            System.out.println("Jelly Roll Stock: " + inventory.get("numJellyRolls"));
            System.out.println("\n====================================================================================================\n");
        }

    }
}
