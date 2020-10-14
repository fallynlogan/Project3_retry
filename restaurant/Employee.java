package restaurant;

public abstract class Employee {
    protected double dailySpringSales, dailyEggSales, dailyPastrySales, dailySausageSales, dailyJellySales;
    protected int dailyTotalSpringOrders, dailyTotalEggOrders, dailyTotalPastryOrders, dailyTotalSausageOrders, dailyTotalJellyOrders;

    protected double dailyCasualSales, dailyBusinessSales, dailyCateringSales;
    protected int casualRollOutages,businessRollOutages, cateringRollOutages;
    protected double dailyTotalSales;

    Boolean earlyClosure;

    protected double allSpringSales, allEggSales, allPastrySales, allSausageSales, allJellySales;
    protected double lifetimeTotalSales;

    public Customer currentCustomer;

    Employee(){
        dailySpringSales = 0; dailyEggSales = 0; dailyPastrySales = 0; dailySausageSales = 0; dailyJellySales = 0;
        dailyTotalSpringOrders = 0; dailyTotalEggOrders = 0; dailyTotalPastryOrders = 0; dailyTotalSausageOrders = 0; dailyTotalJellyOrders = 0;
        allSpringSales = 0; allEggSales = 0; allPastrySales = 0; allSausageSales = 0; allJellySales = 0;
        dailyCasualSales = 0; dailyBusinessSales = 0; dailyCateringSales = 0;
        casualRollOutages = 0; businessRollOutages = 0; cateringRollOutages = 0;
        dailyTotalSales = 0;
    }

    public abstract void update();
}
