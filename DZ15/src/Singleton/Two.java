package Singleton;


public class Two {
private static Two instance;
    
    private Two(){}
    
    //static block initialization for exception handling
    static{
        try{
            instance = new Two();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static Two getInstance(){
        return instance;
    }
    
}