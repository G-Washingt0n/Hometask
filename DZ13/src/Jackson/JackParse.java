package Jackson;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JackParse {
    public static void main(String[] args) {
        JackParse jack = new JackParse();
        jack.readFile();
    }
    
    public void readFile(){
         ObjectMapper mapper = new ObjectMapper();
        try {

			// Convert JSON string from file to Object
			Root root = mapper.readValue(new File("test.json"), Root.class);
			System.out.println(root.toString());

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
