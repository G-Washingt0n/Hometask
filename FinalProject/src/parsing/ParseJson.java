package parsing;

import model.Stock;
import model.Root;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ParseJson {
    
    public Root parseJson(){
        
        JSONParser parser = new JSONParser();
        Root root = null;
        try {
            JSONObject rootObj = (JSONObject) parser.parse(new FileReader("jsonfile.json")); // весь файл json в Object'e
            root = Root.getInstance();
            String name = (String) rootObj.get("name"); //получаем из Object все значения
            root.setName(name);
            System.out.println("name = " + root.getName());
            
            String locat = (String) rootObj.get("location"); 
            root.setLocation(locat);
            System.out.println("location = " + root.getLocation());
            
            String dat = (String) rootObj.get("date"); 
            root.setDate(dat);
            System.out.println("data = " + root.getDate());
            
            int i=0;            
            ArrayList<Stock> stockList = new ArrayList<>();
            while(true){
                try{
            
            JSONArray stockArray = (JSONArray) rootObj.get("stock"); //реор1е является типом 
            
                Stock stock = new Stock();
                JSONObject item = (JSONObject)stockArray.get(i);
                long id = (long)item.get("id");
                String nameStock = (String)item.get("name");
                double bid = (double) item.get("bid");
                try{
                double minn = (double) item.get("minPrice");
                stock.setMinPrice((double)minn);
                }catch(Exception e){
                    long minn = (long) item.get("minPrice");
                    stock.setMinPrice((double)minn);
                }
                try{
                double maxx = (double) item.get("maxPrice");
                stock.setMaxPrice((double)maxx);
                } catch(Exception e){
                    long maxx = (long) item.get("maxPrice");
                    stock.setMaxPrice((double)maxx);
                }
                boolean vis = (boolean)item.get("visible");
               
                stock.setId((int)id);
                stock.setName(nameStock);
                stock.setBid(bid);
                stock.setVisible(vis);
               // stock.setMinPrice((double)minn);
                //stock.setMaxPrice((double)maxx);
                
                
                stockList.add(stock);
               //System.out.println(stockArray.get(i).toString());
            }catch(Exception e){
                    System.out.println("Завершился парсинг по Exceeption");
                    break;
                    }
                i++;
            }
            
            root.setStock(stockList);
        } catch (Exception e) {
            System.out.println("Ошибка чтения Json файла" + e.toString());
        }
        return root;
    }
    
}
