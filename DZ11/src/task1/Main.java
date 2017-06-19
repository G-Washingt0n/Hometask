package task1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner scaner = new Scanner(System.in);
        
        boolean stop = true;
        while(stop){
            String buff = scaner.nextLine();
            if(buff.equals("@")){
                break;
        }
            list.add(buff);
        }
        System.out.println(list.toString());
            for(int i=0;i<list.size();i++){
             if(list.get(i).contains("a")){
                 String loc=list.toString();
                 String rep="";
                 for(int j=0;j<loc.length();j++){
                     if(loc.charAt(j)=='a')
                         continue;
                     rep+=loc.charAt(j);
                 }
                 list.set(i, rep);
             }
            }
             System.out.println(list.toString());
    }
    
}
