package jsonfile;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

public class JsonTest {

	public static void main(String[] args) {
		
		JSONParser parser = new JSONParser();
		Map<String, Object> map = new LinkedHashMap<>();

		try {
			
			FileReader reader = new FileReader("abc.json");
			JSONArray array = (JSONArray)parser.parse(reader);
			
			
			
			
			ArrayList<String> key = new ArrayList<>();
			for(int i = 0; i < array.size(); i++) {
				Object obj = (JSONObject)array.get(i);
				Iterator<?> iter =  ((Map) obj).keySet().iterator();
				int j = 0;
				while(iter.hasNext()) {
					key.add((String)iter.next());
					map.put(key.get(j), ((Map) obj).get(key.get(j)));
					System.out.println(key.get(j) + ": " + map.get(key.get(j)));
					j++;
				}
				System.out.println();
				
			}
			
			
			
			reader.close();
			
		
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

	}
	
}


