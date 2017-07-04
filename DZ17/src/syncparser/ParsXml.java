package syncparser;

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParsXml {

    public void parseXml () {
        //DOM
        Document dom = null;
        Root rt = new Root();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse("xmlfile.xml");
        } catch (Exception e) {
            System.err.println("Ошибка открытия файла" + e.toString());
            return;
        }
        Element root = dom.getDocumentElement();
        System.out.println("tag 1 = " + root.getTagName());
        
        NodeList nameNodeList = root.getElementsByTagName("name");
        Node nameNode = nameNodeList.item(0);
        System.out.println("tag 2 = " + nameNode.getNodeName());
        rt.setName(nameNode.getFirstChild().getNodeValue());
        System.out.println("name = " + rt.getName());
        
       NodeList locationNodeList = root.getElementsByTagName("location");
       Node locationNode = locationNodeList.item(0);
       System.out.println("tag 3 = " + locationNode.getNodeName());
       rt.setLocation(locationNode.getFirstChild().getNodeValue());
       System.out.println("Location = " + rt.getLocation());
       
       NodeList dateNodeList = root.getElementsByTagName("date");
        Node dateNode = dateNodeList.item(0);
        System.out.println("tag 4 = " + dateNode.getNodeName());
        rt.setDate(dateNode.getFirstChild().getNodeValue());
        System.out.println("date = " + rt.getDate());
        
        NodeList stockNodeList = root.getElementsByTagName("stock");
        ArrayList<Stock> list = new ArrayList<>();
        int i=0;
        boolean crit = true;
        while(crit){
            try{
                Node node = stockNodeList.item(i);
 
           if (node.getNodeType() != Node.ELEMENT_NODE) {
               continue;
           }
  
           Stock el = new Stock();
            
           System.out.println("======================================");
 
           Element element = (Element) node;
           System.out.println("tag = " + node.getNodeName());
 
           // name
           NodeList nameElemlist = element.getElementsByTagName("name");
           Element nameElement = (Element) nameElemlist.item(0);
           String nameStock = nameElement.getFirstChild().getNodeValue();
           System.out.println("name : " + nameStock);
 
           el.setName(nameStock);
            
           //bid
           String bid = element.getElementsByTagName("bid").item(0).getTextContent();
           System.out.println("bid : " + bid);
 
           el.setBid(Double.valueOf(bid));
            
           //id
           String id = element.getElementsByTagName("id").item(0).getTextContent();
           System.out.println("id : " + id);
 
           el.setId(Integer.valueOf(id));
           
           
           // minPrice
           String minPr = element.getElementsByTagName("minPrice").item(0).getTextContent();
           System.out.println("minPrice : " + minPr);
 
           el.setMinPrice(Double.valueOf(minPr));
            
           // maxPrice
           String maxPr = element.getElementsByTagName("maxPrice").item(0).getTextContent();
           System.out.println("maxPrice : " + maxPr);
 
           el.setMaxPrice(Double.valueOf(maxPr));
            
           // visible
           String vis = element.getElementsByTagName("visible").item(0).getTextContent();
           System.out.println("vis : " + vis);
 
           el.setVisible(Boolean.valueOf(vis));

           list.add(el);
           
           }
            catch(Exception e){
               System.out.println("конец XML файла");
                crit = false;
                break;
            }            
            
        i++;
        }
        
       /*for(Stock e: list) {
         
        System.out.println(e.toString());
         
       }*/
 
   }
 
}
