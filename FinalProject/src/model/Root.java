package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

public class Root {
    private String name;
    private String location;
    private Date date;    
    private ArrayList<Stock> stock;
    private ArrayList<Integer> prices;

    private static Root root;
    private Root(){
        
    }
    public static Root getInstance(){
        if(root == null)
            root = new Root();
        return root;            
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public ArrayList<Integer> getPrices(){
        
        return prices;
    }

    public ArrayList<Stock> getStock() {
        return stock;
    }

    public void setStock(ArrayList<Stock> stock) {
        
        this.stock = stock;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat();
        sf.applyPattern("y-M-d H:m:s X");
        this.date = sf.parse(date);
    }
    
    @Override
    public String toString() {
        return "Root{" + "name=" + name + ", location=" + location + ", date " + date + stock.toString() + '}';
    }
    
    
    
    //метод для получения средней цены акции
    public HashMap<Integer, Double> getAverPriceList(){
        AverPriceList averPriceList = new AverPriceList();
        HashMap<Integer, Double> list = new HashMap<>();
        for(Stock st: stock) {
            list.put(st.getId(), averPriceList.getAverPrice(st));
        }
        averPriceList.setPriceList(list);
        return list;
    }
    
    public TreeMap<Double, Stock> startSort(int method){
        TreeMap<Double, Stock> list = new TreeMap<>();
        ArrayList<Double> crit = new ArrayList<>();
       switch(method){
           case 1:
               for(Stock st: stock){
            crit.add(st.getBid());
                }
                list = sort(crit);
                return list;
            case 2:
                for (Stock st : stock) {
                    crit.add(st.getMinPrice());
                }
                list = sort(crit);
                return list;
            case 3:
                for (Stock st : stock) {
                    crit.add(st.getMaxPrice());
                }
                list = sort(crit);
                return list;

        }
        
        
        return null;
    }
    
    public TreeMap<Double, Stock> sort(ArrayList<Double> crit){
        TreeMap<Double, Stock> list = new TreeMap<>();
        int i=0;
        for(Stock st: stock) {
            list.put(crit.get(i), st);
            i+=1;
        }        
        return list;
    }
    
    //метод для поиска по id
    public Stock find(int id){
        for(Stock st: stock){
            if(id == st.getId())
                return st;
        }
        return null;
    }
    
    
    //внутренний класс для подсчета средней цены акции
    class AverPriceList implements MyListener{
        private HashMap<Integer, Double> averPrice;

        public HashMap<Integer, Double> getPriceList() {
            return averPrice;
        }

        public void setPriceList(HashMap<Integer, Double> averPrice) {
            this.averPrice = averPrice;
        }

        @Override
        public double getAverPrice(model.Stock stock) {
            return (stock.getMaxPrice()+stock.getMinPrice())/2;
        }
        
    }  
    
    
}
