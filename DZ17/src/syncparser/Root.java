package syncparser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Root {
    private String name;
    private String location;
    private Date date;    
    private ArrayList<Stock> stock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public String getStock() {
        Stock s = new Stock();
        System.out.println(s.getId() + " " + s.getName() + " " + s.getBid() + " " 
                + s.getMinPrice() + " " + s.getMaxPrice() + " " + s.isVisible());
        String str = s.getId() + " " + s.getName() + " " + s.getBid() + " " 
                + s.getMinPrice() + " " + s.getMaxPrice() + " " + s.isVisible();
        return str;
    }

    public void setStock(ArrayList<Stock> stock) {
        //this.stock.add(stock);
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
    
}
