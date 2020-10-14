package restaurant;
import java.util.*; 

public class Casual extends Customer{

    public Casual(String n){
        Random rand = new Random();
        this.name = n;
        this.rollsWanted = rand.nextInt(2)+1;
    }

    public void purchaseRoll(){

    }
}
