package task2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner scaner = new Scanner(System.in);

        boolean stop = true;
        while (stop) {
            String buff = scaner.nextLine();
            if (buff.equals("@")) {
                break;
            }
            list.add(buff);
        }
        System.out.println(list.toString());
                list.remove(0);
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                }
                list.remove(j);
            }
        }
        System.out.println(list.toString());
    }

}
