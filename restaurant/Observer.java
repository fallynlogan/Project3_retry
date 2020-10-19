package restaurant;

public abstract class Observer {
    protected Restaurant restaurant;
    protected Customer currentCustomer;
    public abstract void update();
}
