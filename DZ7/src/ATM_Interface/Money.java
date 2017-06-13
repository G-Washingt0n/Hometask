package ATM_Interface;

import java.util.Scanner;


public class Money {
    private ActionListener listener;
    
    Banknote20 note20 = new Banknote20();
    Banknote50 note50 = new Banknote50();
    Banknote100 note100 = new Banknote100();
    
    public void setListener(ActionListener listener) {
        this.listener = listener;
    }
    public void toGet(int summOut){
        System.out.println("ОБРАБОТКА ДАННЫХ, ЖДИТЕ...");
        if (summOut > countMoney(note20.getAmount(), note20.getValue(),
                note50.getAmount(), note50.getValue(),
                note100.getAmount(), note100.getValue())) { // проверить хватает ли денег
            System.out.println("Недостаточно средств в банкомате");
            return;
        }

        if (summOut < note20.getValue() || summOut == 30 || summOut % 10 != 0) //проверить первично найдутся ли необходимые купюры
        {
            System.out.println("Отсутствуют необходимые банкноты");
        } else {
            int flag = 1;
            int[] Comb = {0, 0, 0}; //сида запишутся комбинации какими купюрами выдать сумму
            while (summOut != 0) {
                if (summOut < 200) {
                    flag = 0;
                    switch (summOut) { //тут описаны все каверзные ситуации, когда может посчитаться не верная комбинация
                        case 130: 
                            if(note50.getAmount() - Comb[1] > 0){
                                Comb[1]+=1;
                                summOut-=note50.getValue(); //свести к случаю с 80
                            } else {
                                System.out.println("Отсутствуют необходимые банкноты");
                                return;
                            }
                            break;
                        case 110: 
                            if(note50.getAmount() - Comb[1] > 0){
                                Comb[1]+=1;
                                summOut-=note50.getValue(); //свести к случаю с 60
                            } else {
                                System.out.println("Отсутствуют необходимые банкноты");
                                return;
                            }
                            break;
                        case 100:
                            if (note100.getAmount() - Comb[0] < 1 && note50.getAmount() - Comb[1] < 2 && note20.getAmount() - Comb[2] > 0) {
                                Comb[2] += 1;
                                summOut -= note20.getValue();
                            } else {
                                flag = 1;
                                break;
                            }
                        case 80:
                            if (note20.getAmount() - Comb[2] >= 4) {
                                Comb[2] += 4;
                                summOut -= 4 * note20.getValue();
                            } else {
                                System.out.println("Отсутствуют необходимые банкноты");
                                return;
                            }
                            break;

                        case 60:
                            if (note20.getAmount() - Comb[2] >= 3) {
                                Comb[2] += 3;
                                summOut -= 3 * note20.getValue();
                            } else {
                                System.out.println("Отсутствуют необходимые банкноты");
                                return;
                            }
                            break;

                        case 40:
                            if (note20.getAmount() - Comb[2] >= 2) {
                                Comb[2] += 2;
                                summOut -= 2 * note20.getValue();
                            } else {
                                System.out.println("Отсутствуют необходимые банкноты");
                                return;
                            }
                            break;

                        default:
                            flag = 1;
                            break;
                    }

                }
                if (flag == 1) {
                    if (note100.getAmount() - Comb[0] > 0 && summOut >= note100.getValue()) {
                        Comb[0] += 1;
                        summOut -= note100.getValue();
                        continue;
                    }
                    if (note50.getAmount() - Comb[1] > 0 && summOut >= note50.getValue()) {
                        Comb[1] += 1;
                        summOut -= note50.getValue();
                        continue;
                    }
                    if (note20.getAmount() - Comb[2] > 0 && summOut >= note20.getValue()) {
                        Comb[2] += 1;
                        summOut -= note20.getValue();
                        continue;
                    }
                    flag = 2;
                }
                if (flag == 2) {
                    System.out.println("Невозможно совершить операцию!");
                    return;
                }

            }
            listener.actionGet(Comb);
            //System.out.println("Операция прошла успешно\n" + "Комбинация купюр: " + "100x" + Comb[0] + " 50x" + Comb[1] + " 20x" + Comb[2]);
            note20.setAmount(note20.getAmount() - Comb[2]); //только поняв что комбинация существует - "выдать" деньги
            note50.setAmount(note50.getAmount() - Comb[1]); // т.е. в нашем случае уменьшить кол-во использованных купюр
            note100.setAmount(note100.getAmount() - Comb[0]);
            System.out.println("Остаток купюр: " + "100x" + note100.getAmount() + " 50x" + note50.getAmount() + " 20x" + note20.getAmount());
        }
                
    }
    
    
    public void toAdd(){
        System.out.println("ОБРАБОТКА ДАННЫХ, ЖДИТЕ...");
        System.out.println("Введите количество банкнот каждого номинала для пополнения: ");
        Scanner in = new Scanner(System.in);
        System.out.println("Купюр номиналом 100: ");
                    int num1 = in.nextInt();
                    note100.setAmount(note100.getAmount()+num1);
                    System.out.println("Купюр номиналом 50: ");
                    int num2 = in.nextInt();
                    note50.setAmount(note50.getAmount()+num2);
                    System.out.println("Купюр номиналом 20: ");
                    int num3 = in.nextInt();
                    note20.setAmount(note20.getAmount()+num3);
        
        listener.actionAdd();
    }
    
    public int countMoney(int a1, int a2, int b1, int b2, int c1, int c2){
    int summ;
    summ= a1*a2 + b1*b2 + c1*c2;
    return summ;
}
    
    
}
