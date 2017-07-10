package myProject;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private MyListener listener;
    public  int type;
    private Root root = Root.getInstance();
 
    protected int getType() {
        return type;
    }

    public void setListener (MyListener listener) {
        this.listener = listener;
    }
    
    public final int downloader(int type){
        this.type = type;
        DownloadThread downloaderThread = new DownloadThread();
        downloaderThread.setType(type);
        downloaderThread.setMain(this);
        downloaderThread.start();
        synchronized(this){
           try {  System.out.println("Выполняется загрузка файла, ожидайте...");
        System.out.println("Ждем завершения скачивания");
        
            wait();
        } catch (InterruptedException ex) {        }
        }
        
        ParserThread parserThread = new ParserThread();
        parserThread.setType(type);
        parserThread.start();
        try {
            parserThread.join();
        } catch (InterruptedException ex) {
            System.out.println("не удалось выполнить join()");
        }
        
       // System.out.println(root.toString());
        return operations();
        
    }
    
    public int operations(){
        boolean check=true;
        HashMap<Integer, Double> AverPriceList = root.getAverPriceList();
    while(check){
            try{
                System.out.println("введите 1, чтобы вывести всю информацию\n" + 
                    "введите 2, чтобы вывести среднюю цену акций\n" + 
                    "введите 3, чтобы найти акцию по id\n" + 
                    "введите 4, чтобы отсортировать акции по цене\n" + 
                    "введите 5 для завершения работы\n");
                Scanner in = new Scanner(System.in);
                int answ = in.nextInt();
                switch(answ){
                        case 1:
                            System.out.println(root.toString());
                            break;
                        case 2:
                            //создали хэш-карточку, для красивого вывода на экран
                            Map<Integer, Double> hashMap = AverPriceList;
                            for (Map.Entry entry : hashMap.entrySet()) {
                                System.out.println("id: " + entry.getKey() 
                                    + " averPrice: " + entry.getValue());
                            }
                            break;
                        case 3:
                            //вспомогательная переменная для работы цикла
                            boolean isOk = true;
                            while(isOk){
                                try{
                                    System.out.println("введите id акции");
                                    Scanner in2 = new Scanner(System.in);
                                    int answ2 = in2.nextInt();
                                    try{
                                        System.out.println(root.find(answ2).toString());
                                        isOk = false;
                                    }catch(NullPointerException ex){
                                        System.out.println(error());
                                    }  
                                }catch(InputMismatchException e){    
                                    System.out.println(error()); 
                                }
                            }
                            break;
                        case 4:
                            //тут должен быть вывод списка с сортировкой
                            break;
                        case 5:
                            check = false;
                            return 0;
                            //break;
                        default:
                            System.out.println(error());
                            break;
                    }
            }
            catch(InputMismatchException e){
                System.out.println(error()); 
            }
        }
    return 0;
    }
    
    public static String error(){
        return "!!!Неправильный ввод, попробуйте еще раз";
}
  
    
    
    
    
    
}
