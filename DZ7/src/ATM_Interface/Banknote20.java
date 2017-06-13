package ATM_Interface;


public class Banknote20 extends Money {
    private final int value = 20;
    private int amount = 5; //изначально в банкомате будет только 5 банкнот номиналом 20

    public int getValue() {
        return value;
    }

    public Banknote20() {
    }
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
