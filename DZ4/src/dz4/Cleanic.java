package dz4;
import java.util.Scanner;



public class Cleanic {
    
     public static void main(String[] args) {
         Patient[] arrPatient = new Patient[5];
         for(int i=0;i<5;i++)
             arrPatient[i]=new Patient();
         int num=6;
         Scanner in = new Scanner(System.in);
         while(num>5){
             System.out.println("Скольких пациентов вы хотите добавить?(<=5)");
             num=in.nextInt();
             if(num>5)
                 System.out.println("Ошибка!!! разрешено добавить не более 5 пациентов. Повторите ввод");
         }
         for(int i=0;i<num;i++)
         createPatient(arrPatient[i]);
         System.out.print("Если желаете произвести поиск пациентов, нажмите 1: ");
         if(in.nextInt()==1)             
         findPatient(arrPatient,num);

     }
     
     public static void createPatient(Patient patient){
         
         Scanner in = new Scanner(System.in);
             System.out.print("\nФамилия пациента: ");
             patient.surname = in.nextLine();
             System.out.print("Имя пациента: ");
             patient.name = in.nextLine();
             System.out.print("Возраст пациента: ");
             patient.age = in.nextInt();
             System.out.print("Отнести пациента к участку №: ");
             patient.district = in.nextInt();
             System.out.print("Пациент имеет инвалидность? ");
             patient.isDisabled = in.nextBoolean();
             /*String ans; //почему нельзя так сделать?
             ans = in.nextLine();
             if(ans.equals("да")){
             patient.isDisabled = true;
             }else
                 patient.isDisabled = false; */ 
             printPatient(patient);
     }
     
     public static void printPatient(Patient patient){
         System.out.print("Пациент " + patient.surname + " " + patient.name +
                 " -- Возраст = " + patient.age +
                 " -- Участок № " + patient.district + " -- ");
         if(patient.isDisabled)
             System.out.print(" Имеет инвалидность\n");
         else
             System.out.print(" Не имеет инвалидности\n");
     }
     
     public static void findPatient(Patient[] patient,int num){
         Scanner in = new Scanner(System.in);
         System.out.print("Введите 1 для поиска по фамилии, или 2 для поиска по возрасту: ");
         if(in.nextInt()==1){
             Scanner inn = new Scanner(System.in);
             System.out.print("Введите фамилию для поиска: ");
             String search;
             search = inn.nextLine();
             for(int i=0;i<num;i++){
             if(search.equals(patient[i].surname))
                 printPatient(patient[i]);
         }
             
         }
         else
         if(in.nextInt()==2){
             Scanner inn = new Scanner(System.in);
             System.out.print("Введите необходимый возраст: ");
             int search;
             search = inn.nextInt();
             for(int i=0;i<num;i++){
             if(search == patient[i].age)
                 printPatient(patient[i]);
         }
         }
         else 
             System.out.println("Что-то пошло не так...");
         
             
     }
     
}
