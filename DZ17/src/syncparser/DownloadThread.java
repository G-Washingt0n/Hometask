package syncparser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/* этот поток качает JSON, затем ждет пока его распарсит другой поток, затем качает 
XML и опять ждет
*/

public class DownloadThread extends Thread{
    
     public static final String LINKXML = "http://kiparo.ru/t/stock.xml";
      public static final String LINKJSON = "http://kiparo.ru/t/stock.json";
    
    private ParserThread parserThread;

    public ParserThread getParserThread() {
        return parserThread;
    }

    public void setParserThread(ParserThread parserThread) {
        this.parserThread = parserThread;
    }
    
    
    @Override
    public void run(){
        //качаем JSON
        try {
            
              //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=
            //ВЫЗВАТЬ ФУНКЦИЮ ДЛЯ СКАЧКИ ФАЙЛА  ++++++++++++++++++++++++++++++++++++++++++++++++==
            
            
            System.out.println("качаем JSON");
            Thread.sleep(5000);
        } catch (InterruptedException ex) { }
        
        
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
        }
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
}
