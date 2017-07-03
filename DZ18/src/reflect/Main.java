package reflect;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        
        MyTest myTest = new MyTest();
        
        Class clas = myTest.getClass(); // то ж самое что и MyTest.class
        
        System.out.println(clas.getSimpleName());
        System.out.println(clas.getName());
        
        int mode = clas.getModifiers();
        if(Modifier.isPublic(mode)){
            System.out.println("Класс публичный"); //и т.д.
        }
        
        Field[] fields = clas.getDeclaredFields();
        for(Field f: fields){
            System.out.println(f.getType().getTypeName());
            System.out.println("переменная " + f.getName());
            if(f.getType().getTypeName().equals("java.lang.String")){
                System.out.println("True");
                try {
                    f.setAccessible(true);
                    Object obj = f.get(myTest);
                    System.out.println("value = " + (String) obj);
                    f.set(myTest, "kjsvbdkb");
                    System.out.println("value = " + (String) f.get(myTest));
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        
    
    
    }
    
}
