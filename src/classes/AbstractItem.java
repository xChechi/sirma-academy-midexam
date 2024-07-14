package classes;

import interfaces.*;

public abstract class AbstractItem implements Item, Categorizable, Breakable, Perishable, Sellable {
    protected String category;
    protected boolean breakable;
    protected boolean perishable;
    protected double price;

    public AbstractItem(String category, boolean breakable, boolean perishable, double price) {
        this.category = category;
        this.breakable = breakable;
        this.perishable = perishable;
        this.price = price;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public abstract void handleBreakage();

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public abstract String getDetails();

    @Override
    public double calculateValue() {
        return price;
    }

    @Override
    public abstract String getDescription();

    @Override
    public boolean isPerishable() {
        return perishable;
    }

    @Override
    public abstract void handleExpiration();

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
