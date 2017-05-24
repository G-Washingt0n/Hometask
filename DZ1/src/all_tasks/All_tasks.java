package all_tasks;
import static java.lang.Math.*;

public class All_tasks {

    public static void main(String[] args) {
        String a = "My_first_exercise";
        int length = a.length();
        System.out.println("Задание №1:");
        System.out.println("Длина строки = " + length);
        String a1 = a.substring(0,length/2);  //при делении на 2 любая дробная часть отбросится, если таковая будет
        System.out.println("Первая половина: " + a1);
        String a2 = a.substring(length/2); 
        System.out.println("Вторая половина: " + a2 + "\n");
        
        
        System.out.println("Задание №2:");
        int b = 24;
        int b1=b%10;
        if(b1==7){
            System.out.println("Последняя цифра действительно 7\n");
        }
        else {
            System.out.println("Последняя цифра точно НЕ 7\n");
        }
        
        System.out.println("Задание №3:");
        double c1 = 3, c2 = 4, r = 2.49; //диагональ отверстия равна 5
        if(2*r<sqrt(pow(c1,2) + pow(c2, 2))) {
            System.out.println("Картонка не закроет отверстие\n");
        }
        else {
            System.out.println("Отверстие полностью закроется\n");
        }
        
        System.out.println("Задание №4");
        int summ = 284;
        if(summ%100 > 10 && summ%100 < 20 ) {
            System.out.println(summ + " Рублей\n");
        }
        else if(summ%10 == 1) {
            System.out.println(summ + " Рубль\n");                
            }
        else if(summ%10 >1 && summ%10 < 5){
            System.out.println(summ + " Рубля\n");
        }
        else 
            System.out.println(summ + " Рублей\n");
            
        System.out.println("Задание №5");
        String f = "?##?#";
        char[] S = new char[f.length()];
        for (int i=0; i<f.length(); i++) {
            S[i]=f.charAt(i);
        }
        f="";
        for (int i=0; i<S.length; i++) {
            if(S[i]=='?') {
                f+="HELLO";
            }
        }
        System.out.println(f);
        
        System.out.println("\n EXTRA:");
        double y, x=15;
        int t=4, s=3;
        y=pow(sin(pow(x,t)),2)/(sqrt(1+pow(x,s)));
        System.out.println("y = " + y);
                
        }
             
}