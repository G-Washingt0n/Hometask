package ATM_Interface;


public class Banknote50 {
    private final int value = 50;
    private int amount = 5; //изначально в банкомате будет только 5 банкнот номиналом 50

    public Banknote50() {
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
