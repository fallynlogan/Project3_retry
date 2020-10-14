package restaurant;

import java.text.DecimalFormat;

public class Announcer extends Employee{
    public Announcer(){

    }

    @Override
    public void update(){
        switch(currentCustomer.getCurrent){
            case "arrival":
                break;
            case "desired order":
                break;
            case "actual order":
                break;
            case "business order failed":
                break;
            case "cater order reduced":
                break;
            case "sold out single roll":
                break;
            case "sold out all rolls":
                break;
            case "leave store":
                break;
        }
    }
}
