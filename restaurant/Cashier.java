package restaurant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.text.DecimalFormat;

public class Cashier extends Observer {
    
    public double dailySpringRevenue, dailyEggRevenue, dailyPastryRevenue, dailySausageRevenue, dailyJellyRevenue;
    public int dailySpringOrders, dailyEggOrders, dailyPastryOrders, dailySausageOrders, dailyJellyOrders;
    public double dailyCasualRevenue, dailyBusinessRevenue, dailyCateringRevenue;
    public double dailyTotalRevenue;

    public int casualRollOutages, businessRollOutages, cateringRollOutages;

    public int allTimeSpringOrders, allTimeEggOrders, allTimePastryOrders, allTimeSausageOrders, allTimeJellyOrders;
    public int allTimeRollOrders;
    public double allTimeRevenue;
    public int allTimeRollOutages;

    public boolean earlyClosure;

    public Cashier(Restaurant restaurant)
    {
        resetDailyReportValues();
        this.restaurant = restaurant;
        this.restaurant.attach(this);
        this.allTimeSpringOrders = 0; this.allTimeEggOrders = 0; this.allTimePastryOrders = 0; this.allTimeSausageOrders = 0; this.allTimeJellyOrders = 0;
        this.allTimeRollOrders = 0;
        this.allTimeRevenue = 0;
        this.allTimeRollOutages = 0;
        this.earlyClosure = false;


    }

    public void resetDailyReportValues(){
        dailySpringRevenue = 0; dailyEggRevenue = 0; dailyPastryRevenue = 0; dailySausageRevenue = 0; dailyJellyRevenue = 0;
        dailySpringOrders = 0; dailyEggOrders = 0; dailyPastryOrders = 0; dailySausageOrders = 0; dailyJellyOrders = 0;
        dailyCasualRevenue = 0; dailyBusinessRevenue = 0; dailyCateringRevenue = 0;
        dailyTotalRevenue = 0;

        casualRollOutages = 0; businessRollOutages = 0; cateringRollOutages = 0;

        earlyClosure = false;
    }

    public void printDailyReport(int dayNum){
        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println("\n____________________ DAILY REPORT FOR DAY " + dayNum + " ____________________");

        //System.out.println("Leftover Spring Rolls: " + restaurant.inventory.get("Spring Roll"));
        System.out.println("Total Revenue for Spring Rolls: $" + df.format(dailySpringRevenue));
        System.out.println("Total Spring Roll Orders: " + dailySpringOrders);

        //System.out.println("Leftover Egg Rolls: " + restaurant.inventory.get("Egg Roll"));
        System.out.println("Total Revenue for Egg Rolls: $" + df.format(dailyEggRevenue));
        System.out.println("Total Egg Roll Orders: " + dailyEggOrders);

        //System.out.println("Leftover Pastry Rolls: " + restaurant.inventory.get("Pastry Roll"));
        System.out.println("Total Revenue for Pastry Rolls: $" + df.format(dailyPastryRevenue));
        System.out.println("Total Pastry Roll Orders: " + dailyPastryOrders);

        //System.out.println("Leftover Sausage Rolls: " + restaurant.inventory.get("Sausage Roll"));
        System.out.println("Total Revenue for Sausage Rolls: $" + df.format(dailySausageRevenue));
        System.out.println("Total Sausage Roll Orders: " + dailySausageOrders);

        //System.out.println("Leftover Jelly Rolls: " + restaurant.inventory.get("Jelly Roll"));
        System.out.println("Total Revenue for Jelly Rolls: $" + df.format(dailyJellyRevenue));
        System.out.println("Total Jelly Roll Orders: " + dailyJellyOrders);

        System.out.println("Total Revenue for Casual Customers: $" + df.format(dailyCasualRevenue));
        System.out.println("Total Revenue for Business Customers: $" + df.format(dailyBusinessRevenue));
        System.out.println("Total Revenue for Catering Customers: $" + df.format(dailyCateringRevenue));
        System.out.println("Total Revenue for the Day: $" + df.format(dailyTotalRevenue));

        System.out.println("Total Casual Orders Affected by Roll Outages: " + casualRollOutages);
        System.out.println("Total Business Orders Affected by Roll Outages: " + businessRollOutages);
        System.out.println("Total Catering Orders Affected by Roll Outages: " + cateringRollOutages);

        String yn;
        if(earlyClosure){ yn = "Yes"; }
        else{ yn = "No";  }
        System.out.println("Inventory Sold Out: " + yn);

        System.out.println("\n====================================================================================================\n");
    }

    public void printLifetimeReport(){

        System.out.println("\n_________________________ LIFETIME REPORT _________________________");
        System.out.println("Total Spring Roll Orders: " + allTimeSpringOrders);
        System.out.println("Total Egg Roll Orders: " + allTimeEggOrders);
        System.out.println("Total Pastry Roll Orders: " + allTimePastryOrders);
        System.out.println("Total Sausage Roll Orders: " + allTimeSausageOrders);
        System.out.println("Total Jelly Roll Orders: " + allTimeJellyOrders);
        System.out.println("Total Roll Outages: " + allTimeRollOutages);
        System.out.println("\nTotal Revenue: " + allTimeRevenue);

    }

    @Override
    public void update()
    {
        Iterator<Map.Entry<Customer, ArrayList<FoodItem>>> it = restaurant.dailyCustomerOrders.entrySet().iterator();
        //We are looping through all the orders of a single day to calculate the values for the daily report
        double orderTotal = 0;
        while(it.hasNext()){
            Map.Entry<Customer, ArrayList<FoodItem>> pair = it.next();
            ArrayList<FoodItem> currentOrder = pair.getValue();
            orderTotal = 0;
            for(int i=0 ; i<currentOrder.size()  ; i++){
                orderTotal += currentOrder.get(i).cost();
                if(currentOrder.get(i).getDescription().contains("Spring Roll")){
                    dailySpringOrders++;
                    allTimeSpringOrders++;
                    dailySpringRevenue += currentOrder.get(i).cost();
                }
                if(currentOrder.get(i).getDescription().contains("Egg Roll")){
                    dailyEggOrders++;
                    allTimeEggOrders++;
                    dailyEggRevenue += currentOrder.get(i).cost();
                }
                if(currentOrder.get(i).getDescription().contains("Pastry Roll")){
                    dailyPastryOrders++;
                    allTimePastryOrders++;
                    dailyPastryRevenue += currentOrder.get(i).cost();
                }
                if(currentOrder.get(i).getDescription().contains("Sausage Roll")){
                    dailySausageOrders++;
                    allTimeSausageOrders++;
                    dailySausageRevenue += currentOrder.get(i).cost();
                }
                if(currentOrder.get(i).getDescription().contains("Jelly Roll")){
                    dailyJellyOrders++;
                    allTimeJellyOrders++;
                    dailyJellyRevenue += currentOrder.get(i).cost();
                }
            }
            Customer c = pair.getKey();
            if(c.getClass().getSimpleName().equals("CasualCustomer")){
                dailyCasualRevenue += orderTotal;
            }
            if(c.getClass().getSimpleName().equals("BusinessCustomer")){
                dailyBusinessRevenue += orderTotal;
            }
            if(c.getClass().getSimpleName().equals("CateringCustomer")){
                dailyCateringRevenue += orderTotal;
            }
            dailyTotalRevenue += orderTotal;
        }
        allTimeRevenue += dailyTotalRevenue;
        allTimeRollOutages += (casualRollOutages + businessRollOutages + cateringRollOutages);
        allTimeRollOrders += (dailySpringOrders + dailyEggOrders + dailyPastryOrders + dailySausageOrders + dailyJellyOrders);
    }

}
