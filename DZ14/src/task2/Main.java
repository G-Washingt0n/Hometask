package task2;

import java.util.regex.*;


public class Main {
    public static void main(String[] args) {
        String text = "dmgnxhxn.xml";
        Pattern p = Pattern.compile("([^\\s]+(?=\\.(json|xml))\\.\\2)");
        Matcher m = p.matcher(text);
        if(m.matches()){
            System.out.println("Формат файла совпадает");
        } else{
            System.out.println("Неверный формат файла");
        }
        Pattern p1 = Pattern.compile("\\.(json|xml)");
        Matcher m1 = p1.matcher(text);
        if(m1.find()){
            System.out.println("Формат файла: " 
                    + text.substring(m1.start()+1, m1.end()));
        }else
            System.err.println("Что-то пошло не так :(");
        
    }
    
}
