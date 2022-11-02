package jsonTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonMain2 {

//	@Override
//	public String toString() {
//		return "ReadJsonFile [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
//				+ super.toString() + "]";
//	}

	public static void main(String[] args) throws FileNotFoundException {

		FileReader reader = new FileReader("abc3.json");
		Map<String, Object> map = new HashMap<>();

		try {
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray)parser.parse(reader);
			
			for(int i = 0; i < array.size(); i++) {
				
				JSONObject obj = (JSONObject)array.get(i);
				Iterator<?> iter =  obj.keySet().iterator();
				
				while(iter.hasNext()) {
					String key = (String) iter.next();
					map.put(key, obj.get(key));
//					if(key.equals("참고자료문헌")) 
						System.out.println(key+": "+ obj.get(key));
				}
				System.out.println();
			}
			reader.close();

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		

	}

}
