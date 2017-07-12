package model;

public class Stock {

    private String name;
    private int id;
    private double bid;
    private double minPrice;
    private double maxPrice;
    private boolean visible;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
       return "\n"+"Stock{" + "id=" + id + ", name=" + name + ", bid=" + 
                bid + ", minPrice=" + minPrice + ", maxPrice=" + 
                maxPrice + ", visible=" + visible + '}';
    }


}
