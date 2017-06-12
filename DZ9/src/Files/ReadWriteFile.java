package Files;

import java.io.*;

public class ReadWriteFile {
    public static void main(String[] args) throws IOException {
        try(FileReader reader = new FileReader("filetoread.txt"))
        {
           // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                 
                System.out.print((char)c);
            } 
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
        
        try(FileWriter writer = new FileWriter("newFile.txt", false)){
            String textToWrite = "Some new text to create";
            writer.write(textToWrite);
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
