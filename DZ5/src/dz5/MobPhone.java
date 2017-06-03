package dz5;


public class MobPhone {
    static int startPrice = 700;
        
    public static void main(String args[]){
        IPhone phone1 = new IPhone();
        System.out.println("Phone brand:" + phone1.getBrand() + "\nPhone model:" + phone1.getModel() + "\nPhone os:" + phone1.getOs() + "\nStarting at: " + startPrice + "$\n");
        Keyone phone2 = new Keyone();
        System.out.println("Phone brand:" + phone2.getBrand() + "\nPhone model:" + phone2.getModel() + "\nPhone os:" + phone2.getOs() + "\nStarting at: " + startPrice + "$\n");
        Galaxy phone3 = new Galaxy();
        System.out.println("Phone brand:" + phone3.getBrand() + "\nPhone model:" + phone3.getModel() + "\nPhone os:" + phone3.getOs() + "\nStarting at: " + startPrice + "$\n");

        
        
    }
    
    
}
