package restaurant;

public class Bookkeeper extends Employee{
    public Bookkeeper(){

    }

    public void printDailyReport(int dayNum){
        System.out.println("---------- DAILY REPORT FOR DAY " + dayNum + " ----------");

        System.out.println("Leftover Spring Rolls: " + Store.inventory.get("numSprRolls"));
        System.out.println("Total Revenue for Spring Rolls: " + dailySpringSales);
        System.out.println("Total Spring Roll Orders: " + dailyTotalSpringOrders);

        System.out.println("Leftover Egg Rolls: " + Store.inventory.get("numEggRolls"));
        System.out.println("Total Revenue for Egg Rolls: " + dailyEggSales);
        System.out.println("Total Egg Roll Orders: " + dailyTotalEggOrders);

        System.out.println("Leftover Pastry Rolls: " + Store.inventory.get("numPastryRolls"));
        System.out.println("Total Revenue for Pastry Rolls: " + dailyPastrySales);
        System.out.println("Total Pastry Roll Orders: " + dailyTotalPastryOrders);

        System.out.println("Leftover Sausage Rolls: " + Store.inventory.get("numSausageRolls"));
        System.out.println("Total Revenue for Sausage Rolls: " + dailySausageSales);
        System.out.println("Total Sausage Roll Orders: " + dailyTotalSausageOrders);

        System.out.println("Leftover Jelly Rolls: " + Store.inventory.get("numJellyRolls"));
        System.out.println("Total Revenue for Jelly Rolls: " + dailyJellySales);
        System.out.println("Total Jelly Roll Orders: " + dailyTotalJellyOrders);

        System.out.println("Total Revenue for Casual Customers: " + dailyCasualSales);
        System.out.println("Total Revenue for Business Customers: " + dailyBusinessSales);
        System.out.println("Total Revenue for Catering Customers: " + dailyCateringSales);
        System.out.println("Total Revenue for All Customers: " + (dailyCasualSales + dailyBusinessSales + dailyCateringSales));

        System.out.println("Total Casual Orders Affected by Roll Outages: " + casualRollOutages);
        System.out.println("Total Business Orders Affected by Roll Outages: " + businessRollOutages);
        System.out.println("Total Catering Orders Affected by Roll Outages: " + cateringRollOutages);

        String yn;
        if(earlyClosure){ yn = "Yes"; }
        else{ yn = "No";  }
        System.out.println("Inventory Sold Out: " + yn);

        System.out.println("\n====================================================================================================\n");
    }

    /*public void printReceipt(){

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);

        currentCustomer.totalOrderCost = 0.0;
        if(currentCustomer.rollOrder.length>0){
            System.out.println(currentCustomer.getName() + "'s Purchase:");
            for(int i=0 ; i<currentCustomer.rollOrder.length ; i++){
                System.out.println("1 " + currentCustomer.rollOrder[i].getName() + "  @  $" + df.format(currentCustomer.rollOrder[i].getFoodPrice()));
                if(currentCustomer.rollOrder[i].getFillQuantity()>0){
                    System.out.println(currentCustomer.rollOrder[i].getFillQuantity() + " " + currentCustomer.rollOrder[i].getFillName() + "  @  $" + df.format(currentCustomer.rollOrder[i].getFillPrice()));
                }
                if(currentCustomer.rollOrder[i].getSauceQuantity()>0){
                    System.out.println(currentCustomer.rollOrder[i].getSauceQuantity() + " " + currentCustomer.rollOrder[i].getSauceName() + "  @  $" + df.format(currentCustomer.rollOrder[i].getSaucePrice()));
                }
                if(currentCustomer.rollOrder[i].getToppingQuantity()>0){
                    System.out.println(currentCustomer.rollOrder[i].getToppingQuantity() + " " + currentCustomer.rollOrder[i].getToppingName() + "  @  $" + df.format(currentCustomer.rollOrder[i].getExtraToppingPrice()));
                }
                currentCustomer.totalOrderCost += currentCustomer.rollOrder[i].getTotalPriceSingleRoll();
            }
            System.out.println("Total = $" + df.format(currentCustomer.totalOrderCost));
        }
    }*/

    @Override
    public void update(){

    }
}
