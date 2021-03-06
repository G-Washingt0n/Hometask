package syncparser;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* этот поток ждет пока скачается JSON, затем парсит его, затем ждет пока
скачается XML и тоже парсит его
 */
public class ParserThread extends Thread {

    private DownloadThread downloaderThread;

    public DownloadThread getDownloaderThread() {
        return downloaderThread;
    }

    public void setDownloaderThread(DownloadThread downloaderThread) {
        this.downloaderThread = downloaderThread;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                System.out.println("Парсер - спим и ждем пока нас разбудят");
                wait();
            } catch (InterruptedException ex) {
            }
        }

        try {
            System.out.println("Парсер - парсим JSON");
            
            new ParseJson().main();
            //парсим JSON 
            // ВЫЗВАТЬ ФУНКЦИЮ
            
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
        }
        synchronized (downloaderThread) {
            System.out.println("ParserThread - пробуждаем поток скачки");
            downloaderThread.notify();
        }

        synchronized (this) {
            System.out.println("ParserThread - сами засыпаем");

            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
            System.out.println("парсим XML");
        try {
            new ParsXml().parseXml();
        } catch (ParseException ex) {
            System.out.println("Неудалось распарсить XML");

        }
            
        System.out.println("Парсер завершает работу");

    }

}
