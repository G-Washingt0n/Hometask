package task;

import java.util.regex.*;

public class NewClass {

    public static void main(String[] args) {
        String text = "5576 HH-7";

        Pattern p = Pattern.compile("\\d{4}\\s\\w{2}-[0-7]{1}");//десятичная цифра повторяется 4 раза в самом начале
        Matcher m = p.matcher(text);
        if (m.matches()) {
            System.out.println("Номер верный");
        } else {
            System.out.println("Номер не верный");
        }
        NewClass method = new NewClass();
        method.checkPhone();
        method.checkEmail();
    }

    public void checkPhone() {
        String text = "+375(29)1346156";

        Pattern p = Pattern.compile("^\\+375\\(?((17)|(29)|(33)|(44))\\)?\\d{7}$");
        Matcher m = p.matcher(text);
        if (m.matches()) {
            System.out.println("Номер телефона верный");
        } else {
            System.out.println("Номер телефона не верный");
        }
    }
     public void checkEmail() {
        String text1 = "djvbjsbv fkjgb@gmail.com lkskdvjln iohvvljnv kjhvjk@gmail.com fjshkb";
        String text2 = "";
        char[] chars = text1.toCharArray();;
        Pattern p1 = Pattern.compile(".+\\@{1}.+\\.(com|by|ru)");
        Matcher m1;
        String buff="";
        for (int i = 0; i < text1.length(); i++) {
            if (text1.charAt(i) == ' ' || i==text1.length()-1) {
                System.out.println(buff);
                m1 = p1.matcher(buff);
                if (!m1.matches()) {
                    text2+=buff + " ";
                }
                buff = "";
                continue;
            }
            buff += text1.charAt(i);
            
        }
        System.out.println(text2);
    }
}
