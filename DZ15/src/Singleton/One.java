package Singleton;

public class One {

    private One() {
    }
   
    public static class Helper {
        private static final One INSTANCE = new One();
    }
    
    public static One getInstanse(){
        return Helper.INSTANCE;
    }
}
