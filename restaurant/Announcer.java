package restaurant;

import java.text.DecimalFormat;

public class Announcer extends Employee{
    public Announcer(){

    }

    @Override
    public void update(){
        switch(currentCustomer.getCurrentEvent()){
            case "arrival":
                System.out.println(currentCustomer.getName() + " the " + currentCustomer.getClass().getSimpleName() + " Customer has arrived at the store!");
                break;
            case "desired order":
                currentCustomer.getInitialOrder();
                break;
            case "actual order":
                for(int i=0; i < currentCustomer.rollOrder.length; i++){
                    System.out.println(currentCustomer.getName() +  " purchased 1 " + currentCustomer.rollOrder[i].getDescription() + ".");
                }
                break;
            case "casual order modified":
                System.out.println("Sorry " + currentCustomer.getName() + "! One or more roll types in your order is unavailable.");
                break;
            case "business order failed":
                System.out.println("Sorry " + currentCustomer.getName() + "! The order can not be fulfilled!");
                break;
            case "cater order reduced":
                System.out.println("Sorry " + currentCustomer.getName() + "! Your order cannot be completed entirely!");
                break;
            case "sold out single roll":
                //System.out.println("ATTENTION! Jelly Rolls are now currently unavailable. Sorry for the inconvenience!");
                break;
            case "sold out all rolls":
                System.out.println("THE STORE IS CURRENTLY SOLD OUT OF ROLLS AND IS CLOSING! See you tomorrow!");
                break;
            case "leave store":
                System.out.println(currentCustomer.getName() + " has left the store. Thank you and have a great day!");
                break;
            default:
                System.out.println("There is an incorrect currentEvent key somewhere. Good luck finding it you will need it.");
                break;
        }
    }
}
