package jsonTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader; 
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonMain {

	public static void main(String[] args) throws IOException, ParseException {
		
		JSONParser jp = new JSONParser();
		
		Reader r = new FileReader("C:\\Users\\이성호\\eclipse-workspace\\jsonTest\\한국산업기술평가관리원_지역발전정책용어사전_20220627.json");
        JSONObject jsonObject = (JSONObject) jp.parse(r);
        
        
//        while(true) {
//        	if(!jsonObject.isEmpty()) break;
//        	String s = (String) jsonObject.get("정책용어");
//        	System.out.println(s);
//        }
        
        
        
//        String name = (String) jsonObject.get("name");
//        long id = (Long) jsonObject.get("id");
//        long price = (Long) jsonObject.get("price");
//        String name2 = (String) jsonObject.get("name");
//        long id2 = (Long) jsonObject.get("id");
//        long price2 = (Long) jsonObject.get("price");
//		
//        System.out.println(name);
//        System.out.println(id);
//        System.out.println(price);
//        System.out.println(name2);
//        System.out.println(id2);
//        System.out.println(price2);
        
	}

}
