package myProject;

import java.text.ParseException;

public class ParserThread extends Thread {

    private Main main = new Main();
    private Root root;
    
    private int type;

    public void setType(int type) {
        this.type = type;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void run() {

        if (type == 1) {
            //парсим JSON
            root = new ParseJson().parseJson();
            System.out.println("JSON обработан");
        } else {
            try {
                //парсим XML
                root = new ParsXml().parseXml();
                System.out.println("XML обработан");
            } catch (ParseException ex) {
                System.out.println("не удалось распарсить XML");
            }
        }

    }
}
