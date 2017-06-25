package task1;

import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        String text = "hellowoooorld";
        String text2 = "";
        System.out.println(text);
        Main app = new Main();
        do {
            text2 = app.searcher(text);
            if (!text2.equals("@")) {
                text = text2;
            }
        } while (!text2.equals("@"));
        System.out.println(text);
    }

    public String searcher(String text) {
        String pattern = "([a-z])\\1+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        if (m.find()) {
            int count = m.end() - m.start();
            System.out.println(text.substring(m.start(), m.end()) + "*");
            text = text.replace(text.substring(m.start(), m.end()),
                    text.substring(m.start(), m.start() + 1)
                    + Integer.toString(count));
            return text;
        } else {
            return "@";
        }
    }
}
