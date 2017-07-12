package parsing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import view.Main;

public class DownloadThread extends Thread{
    
     public static final String LINKXML = "http://kiparo.ru/t/stock.xml";
      public static final String LINKJSON = "http://kiparo.ru/t/stock.json";
    

      private Main main = new Main();
      private int type;

    public void setType(int type) {
        this.type = type;
    }
    

    public void setMain(Main main) {
        this.main = main;
    }
    
    
    @Override
    public void run(){
        try{
            sleep(1000); //немного подождем, как будто загружаем большой файл
        } catch(InterruptedException ex){        }
        
        if (type == 1) {
            //качаем JSON
            downloadJson();
            System.out.println("JSON скачался");
            synchronized(main){
            main.notify();
        }
            
        } else {
            //качаем XML
            downloadXml();
            System.out.println("XML скачался");
            synchronized(main){
            main.notify();
        }
        }
        
        
        
        

        
        /*качаем JSON
            System.out.println("качаем JSON");
            downloadJson();
        
        
        //пробуждаем поток парсера , затем засыпаем
        System.out.println("Торрент - пробуждаем поток парсера");
        synchronized(parserThread){
            parserThread.notify();
        }
        synchronized(this){
        System.out.println("Торрент - сами засыпаем");
        try {
            wait();
        } catch (InterruptedException ex) {        }
        }
        
        //качаем XML
            System.out.println("качаем XML");
            downloadXml();
        
        synchronized(parserThread){
            parserThread.notify();
        
        System.out.println("DownloadThread - пробуждаем поток парсера");
            System.out.println("Торрент заканчивает работу");
        } */
    }
    
    public void downloadXml(){
        InputStream inputStream = null;
            FileOutputStream outputStream = null;
            
          try{
              URL url = new URL(LINKXML);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                        // получаем код ответа (от сайта или сервера)
            int responseCode = httpURLConnection.getResponseCode();
            if(responseCode == httpURLConnection.HTTP_OK){
            inputStream = httpURLConnection.getInputStream();
            File file = new File("xmlfile.xml");
            outputStream = new FileOutputStream(file);
            int bytesRead = -1; //количество прочитанных байёт за одно чтение 
            byte[] buffer = new byte[1024]; // то что скачали 
            while((bytesRead = inputStream.read(buffer))!=-1){
                //записываем в файл от 0 до "bytesRead" из "buffer";
                outputStream.write(buffer, 0, bytesRead);
            }
            }
            else
                  System.out.println("responseCode " + responseCode);
                   } catch (Exception ex) {
            System.out.println("Ошибка" + ex.toString());
        } finally {
              try{
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
              } catch (Exception e){
                  System.out.println("Ошибка при закрытии стрима" + e.toString());
              }
          }
    }
    
     public void downloadJson(){
        InputStream inputStream = null;
            FileOutputStream outputStream = null;
            
          try{
              URL url = new URL(LINKJSON);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                        // получаем код ответа (от сайта или сервера)
            int responseCode = httpURLConnection.getResponseCode();
            if(responseCode == httpURLConnection.HTTP_OK){
            inputStream = httpURLConnection.getInputStream();
            File file = new File("jsonfile.json");
            outputStream = new FileOutputStream(file);
            int bytesRead = -1; //количество прочитанных байёт за одно чтение 
            byte[] buffer = new byte[1024]; // то что скачали 
            while((bytesRead = inputStream.read(buffer))!=-1){
                //записываем в файл от 0 до "bytesRead" из "buffer";
                outputStream.write(buffer, 0, bytesRead);
            }
            }
            else
                  System.out.println("responseCode " + responseCode);
                   } catch (Exception ex) {
            System.out.println("Ошибка" + ex.toString());
        } finally {
              try{
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
              } catch (Exception e){
                  System.out.println("Ошибка при закрытии стрима" + e.toString());
              }
          }
    }
    
}
