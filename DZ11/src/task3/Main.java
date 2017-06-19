package task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.body();
    }
    
    public void body(){
        ArrayList<People> man = new ArrayList<>();
        ArrayList<People> woman = new ArrayList<>();
        man.add(new People("Первый ", "Константин ", "Сергеевич") );
        man.add(new People("Второй ", "Виктор ", "Васильевич"));
        man.add(new People("Третий ", "Николай ", "Петрович"));
        woman.add(new People("Первая ", "Анна ", "Николаевна"));
        woman.add(new People("Вторая ", "Элеонора ", "Андреевна"));
        woman.add(new People("Третья ", "Даздраперма ", "Иосифовна"));
        
        HashMap<String, ArrayList<People>> hash = new HashMap<>();
        hash.put("man", man );
        hash.put("woman",woman);
        System.out.println("Мужское фио (1), или женское(2)? ");
        Scanner scaner = new Scanner(System.in);
        int num = scaner.nextInt();
        if(num==1){
            String key="man";
        System.out.println("key " + key + " value " + hash.get(key) );
        }
        else{
            String key="woman";
        System.out.println("key " + key + " value " + hash.get(key) );
        }
    }
    
    public class People{
        public String surname;
        public String name;
        public String lastname;

        public People(String surname, String name, String lastname) {
            this.surname = surname;
            this.name = name;
            this.lastname = lastname;
        }
    } 
}
