package ATM_Interface;

import java.util.Scanner;

public class ATM implements ActionListener {

    /*Banknote20 note20 = new Banknote20();
    Banknote50 note50 = new Banknote50();
    Banknote100 note100 = new Banknote100();*/
   
    
    public void main() {
         Money money = new Money();        
        money.setListener(this);
        int operationType = 0;

        while (operationType != 3) {

            System.out.println("Банкомат. для снятия денег нажмите 1, для добавления денег в банкомат нажмите 2, для завершения работы нажмите 3:");
            Scanner in = new Scanner(System.in);
            operationType = in.nextInt();

            switch (operationType) {
                case 1:
                    System.out.println("Какую сумму вы хотите снять? ");
                    int summOut = in.nextInt();
                    money.toGet(summOut);
                    //getCash(summOut);
                    System.out.println("Для продолжения нажмите 1, для выхода нажмите 2: ");
                    if (in.nextInt() == 2) {
                        operationType = 3;
                    }
                    break;
                case 2:
                    money.toAdd();
                    //addCash();
                    System.out.println("Для продолжения нажмите 1, для выхода нажмите 2: ");
                    if (in.nextInt() == 2) {
                        operationType = 3;
                    }
                    break;
                case 3:
                    System.out.println("Всего доброго!");
                    break;
                default:
                    System.out.println("Ошибка операции! Повторите ввод!");
                    break;
            }

        }
    }

    @Override
    public void actionGet(int[] Comb) {
        System.out.println("Операция прошла успешно\n" + "Комбинация купюр: " + "100x" + Comb[0] + " 50x" + Comb[1] + " 20x" + Comb[2]);
    }

    @Override
    public void actionAdd() {
        System.out.println("Деньги добавлены в банкомат");
    }

}
