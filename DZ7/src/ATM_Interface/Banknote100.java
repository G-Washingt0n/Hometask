package ATM_Interface;


public class Banknote100 extends Money{
    private final int value = 100;
    private int amount = 5; //изначально в банкомате будет только 5 банкнот номиналом 100

    public Banknote100() {
    }

    public int getValue() {
        return value;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
