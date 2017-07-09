package syncparser;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ParseJson {

    public void main() {
        Root root = parseJson("jsonfile.json");
        System.out.println(root.toString());
       
    }
    
    public static Root parseJson(String path){
        
        JSONParser parser = new JSONParser();
        Root root = null;
        try {
            JSONObject rootObj = (JSONObject) parser.parse(new FileReader("jsonfile.json")); // весь файл json в Object'e
            root = new Root();
            String name = (String) rootObj.get("name"); //получаем из Object все значения
            System.out.println("name = " + name);
            root.setName(name);
            
            String locat = (String) rootObj.get("location"); 
            System.out.println("location = " + locat);
            root.setLocation(locat);
            
            String dat = (String) rootObj.get("date"); 
            //System.out.println("data = " + dat);
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
            //System.out.println(stockList.toString());
            
            //root.setStock(stockList);
           // root.getStock();
        } catch (Exception e) {
            System.out.println("Ошибка чтения Json файла" + e.toString());
        }
        return root;
    }
    
   /* public static Root parseGson(String path){ //String path - передаем путь в функцию при ее вызове
        Root root = null;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            Gson gson = new Gson();
            root = gson.fromJson(reader,Root.class);
            System.out.println("id : " + new Stock().getId());
             System.out.println("minPrice : " + new Stock().getMinPrice());
            System.out.println("maxPrice : " + new Stock().getMaxPrice());
             System.out.println("vis : " + new Stock().isVisible());
            System.out.println();
        } catch(Exception e){
            System.out.println("Ошибка чтения Json файла" + e.toString());
        }
        return root;
    }*/
    
}
