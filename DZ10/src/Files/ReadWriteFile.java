package Files;

import java.io.*;

public class ReadWriteFile {

    public static void main(String[] args) throws Exception {

        ReadWriteFile readerwriter = new ReadWriteFile();
        readerwriter.test();
    }

    public void test() throws Exception {
        File file = new File("filetoread.txt");
        Student[] student = new Student[3];
        student[0].age=0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                int count=1;
                while ((s = in.readLine()) != null) {
                    System.out.println(s);
                    int i = 0;
                    int num = 1;
                    for (int j = 0; j < s.length(); j++) {
                        System.out.println(s.charAt(j));
                        if(s.charAt(j) == ' ' && num>1)
                            continue;
                        
                        if (s.charAt(j) == '|' && num == 1) {
                            if (j > i) {
                                student[count].fio = "";
                                student[count].fio = s.substring(i,j);
                            }
                            i = j + 1;
                            num++;
                            continue;
                        }
                        
                        if (s.charAt(j) == '|' && num == 2) {
                            if (j > i) {
                                student[count].age = Integer.parseInt(s.substring(i,j));
                            }
                            i = j + 1;
                        }
                        
                    }
                    if(i<s.length()){
                        student[count].drivingLicense = Boolean.valueOf(s.substring(i));
                    }
                    
                    System.out.println(student[i].fio + " " + student[i].age + " " + student[i].drivingLicense + "\n");
                    count++;
                    if(count>3)
                        break;
                }
            } finally {
                in.close();
            }
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
