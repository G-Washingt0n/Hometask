package StringToDate;

import average_age.Main;
import static average_age.Main.printStudent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class STD {
    public static void main(String[] args) {
        Date date = new Date();
        Scanner in = new Scanner(System.in);
         String strAge;
        System.out.print("Формат даты(ГГ-ММ-ДД): ");
        strAge = in.nextLine();
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("y-M-d H:m");
        try {
            date = format.parse(strAge);
        } catch (ParseException ex) {
            Logger.getLogger(STD.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(date);
    }
    }
    

