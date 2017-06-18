package Files;

import java.io.*;

public class ReadWriteFile {

    public static void main(String[] args) throws Exception  {
        
        ReadWriteFile readerwriter = new ReadWriteFile();
       readerwriter.readerMethod();
    }

    public void readerMethod() throws Exception {
        try (FileReader reader = new FileReader("filetoread.txt")) {
            // читаем посимвольно
            int c;
            String buff = "";
            int i = 0;
            Student[] student = new Student[3];
            int counter = 1;
            while ((c = reader.read()) != -1) {
                if ((char) c == '|') {
                    switch (counter % 3) {
                        case 1:
                            student[i].fio = buff;
                            counter++;
                            buff="";
                            System.err.println(student[i].fio);
                            break;
                        case 2:
                            student[i].age = Integer.parseInt(buff);
                            counter++;
                            buff="";
                            break;
                    }
                }
                if((char)c=='\n'){
                            student[i].drivingLicense = Boolean.valueOf(buff);
                            System.out.println(student[i].fio + " " + student[i].age + " " + student[i].drivingLicense + "\n");
                            i++;
                            counter++;
                            buff="";
                            break;
                    
                }
                if((char)c!='|'){
                    buff += (char) c;
                }
               System.out.print((char) c);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        try (FileWriter writer = new FileWriter("newFile.txt", false)) {
            String textToWrite = "Some new text to create";
            writer.write(textToWrite);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public class Student {

        public String fio;
        public int age;
        public boolean drivingLicense;
    }

}
