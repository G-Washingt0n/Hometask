package Calculator;

import java.util.Scanner;

public class Calc_func {
    public void interf(){
        Scanner scan = new Scanner(System.in);
        int operation=0; 
        boolean choise = true;
        System.out.println("Простой калькулятор приветствует!");
        while(choise){
        try{
            choise = false;
            operation = chooseOperation();
        } catch(MyEx ex){
            ex.getRussianMessage();
            choise = true;
        }
        }
        int first = 0;   
        choise = true;
        System.out.println("Первое число (не более 100): ");
        while(choise){
            try{
                choise = false;
        first = scan.nextInt();
        if(first>100)
            throw new MyEx(2);
        } catch(MyEx ex){
            ex.getRussianMessage();
            choise = true;
        }
        }
        int second=0;
        choise = true;
        System.out.println("Второе число: ");
        while(choise){
            try{
                choise = false;
        second = scan.nextInt();
        if(second>100)
            throw new MyEx(3);
        if(operation==4 && second==0)
            throw new MyEx(4);
        } catch(MyEx ex){
            ex.getRussianMessage();
            choise = true;
        }
        }
        double result;
        switch(operation){
            case 1: System.out.println(result = plus(first,second));
            break;
            case 2: System.out.println(result = minus(first,second));
            break;
            case 3: System.out.println(result = mult(first,second));
            break;
            case 4: System.out.println(result = dev(first,second));
            break;
        }
    }
    public int chooseOperation() throws MyEx{
        
        System.out.println("Выберите тип"
                + " операции: " + "\n[1] - Сложение" + "\n[2] - Вычитание" + 
                "\n[3] - Умножение" + "\n[4] - Деление");
        Scanner scan = new Scanner(System.in);
        int operation = scan.nextInt();
        if(operation<1 || operation>4)
            throw new MyEx(1);
        return operation;
    }

    private double plus(int first, int second) {
        return first+second;
    }

    private double minus(int first, int second) {
        return first-second;
    }

    private double mult(int first, int second) {
    return first*second;
    }

    private double dev(int first, int second) {
        return first/second;
    }
    
}
