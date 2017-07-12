package view;

import java.util.Scanner;


public class GUI {
    public static void main(String[] args) {
        new GUI().start();
    }
    
    public void start(){
       // Main main = new Main();
       // main.setListener(new MyListener дописать после добавления методов в интерфейс
       Main main = new Main();
       int operationType = -1;

        while (operationType != 0) {
             System.out.println("Вас приветствует приложение forEx! "
                     + "\nДля начала работы необходимо обновить базу данных."
                     + "\nДля загрузки JSON файла нажмите [1], XML файла - [2], "
                     + "для выхода нажмите [0]");
            Scanner in = new Scanner(System.in);
            operationType = in.nextInt();
            
            if(operationType==1 || operationType==2){
                operationType = main.downloader(operationType);
            } else{
                if(operationType==0)
                    System.out.println("Всего доброго!");
                else
                  System.out.println("Ошибка операции! Повторите ввод!");                     
            }
            
            /*switch (operationType) {
                case 1:
                    main.downloader(operationType);
                    break;
                case 2:
                    main.downloader(operationType);
                    break;
                case 0:
                    System.out.println("Всего доброго!");
                    break;
                default:
                    System.out.println("Ошибка операции! Повторите ввод!");
                    break;
            }*/
            
        }
    }
}
