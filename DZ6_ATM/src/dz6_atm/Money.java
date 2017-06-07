package dz6_atm;


public class Money {
    private ActionListener listener;

    public void setListener(ActionListener listener) {
        this.listener = listener;
    }
    public void toGet(int a){
        listener.actionGet(a);
    }
    
    
    public static int countMoney(int a1, int a2, int b1, int b2, int c1, int c2){
    int summ;
    summ= a1*a2 + b1*b2 + c1*c2;
    return summ;
}
    
    
}
