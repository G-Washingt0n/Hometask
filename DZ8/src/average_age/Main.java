package average_age;

import java.text.ParseException;
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Student[] arrStud = new Student[5];
        for (int i = 0; i < 5; i++) {
            arrStud[i] = new Student();
        }
        int num = 6;
        Scanner in = new Scanner(System.in);
        while (num > 5) {
            System.out.println("Скольких студентов создать?(<=5)");
            num = in.nextInt();
            if (num > 5) {
                System.out.println("Ошибка!!! разрешено создать не более 5 студентов. Повторите ввод");
            }
        }
        for (int i = 0; i < num; i++) {
            createStudent(arrStud[i]);
        }
        findAverage(arrStud, num);
    }

    public static void createStudent(Student student) {

        Scanner in = new Scanner(System.in);
        System.out.print("\nФамилия пациента: ");
        student.surname = in.nextLine();
        System.out.print("Имя пациента: ");
        student.name = in.nextLine();
        String strAge;
        System.out.print("Дата рождения(ДД.ММ.ГГ): ");
        strAge = in.nextLine();
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("d.M.y");
        try {
            student.birth = format.parse(strAge);
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        printStudent(student);
    }

    public static void printStudent(Student student) {
        System.out.print("Студент " + student.surname + " " + student.name
                + " -- Родился:  " + student.birth + "\n");
    }

    private static void findAverage(Student[] student, int num) {
        GregorianCalendar cal1 = new GregorianCalendar();
        Date date = new Date();
        cal1.setTime(date);

        GregorianCalendar cal = new GregorianCalendar();
        int sumYear = 0;
        int sumMonth = 0;
        for (int i = 0; i < num; i++) {
            cal.setTime(student[i].birth);
            sumYear += (cal1.get(Calendar.YEAR) - cal.get(Calendar.YEAR) - 1);
            int currMonth = 1 + (11 - cal.get(Calendar.MONTH) + cal1.get(Calendar.MONTH));
            sumMonth+=currMonth;
        }
        if(num>1){
            if(sumYear/2!=0){
                sumYear--;
                sumMonth+=12*num;
            }
        }
        int averageY=sumYear / num;
        System.out.println(averageY);
        int averageM=0;
        if( sumMonth > 12*num){
            averageY+=(int)(sumMonth/(12*num));
            System.out.println((int)(sumMonth/(12*num)));
            averageM=(sumMonth%12*num)/num;
            }
        else
            averageM = sumMonth;
        System.out.print("Средний возраст равен: " + averageY);
        if (averageY % 10 > 4 && averageY < 5 || averageY > 20) {
            if (averageY % 10 == 1) {
                System.out.print(" год ");
            } else {
                System.out.print(" года ");
            }
        } else {
            System.out.print(" лет ");
        }

        if (averageM < 5) {
            if (averageM == 1) {
                System.out.print(averageM + " месяц");
            } else {
                System.out.print(averageM + " месяца");
            }
        } else {
            System.out.print(averageM + " месяцев");
        }
    }

}
