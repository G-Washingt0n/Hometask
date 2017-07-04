package syncparser;

public class Main {
    public static void main(String[] args) {
        DownloadThread downloaderThread = new DownloadThread();
        ParserThread parserThread = new ParserThread();
        
        downloaderThread.setParserThread(parserThread);
        parserThread.setDownloaderThread(downloaderThread);
        
        downloaderThread.start();
        parserThread.start();
        
        
    }
    
}
