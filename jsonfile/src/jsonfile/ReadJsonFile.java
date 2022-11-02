package jsonfile;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class ReadJsonFile {
	
	static ArrayList<JsonVO> list = new ArrayList<>();
	
	public static void Read() {
		JSONParser parser = new JSONParser();
		JSONArray array;
		JsonVO jvo;
		try {
			FileReader reader = new FileReader("abc.json");
			array = (JSONArray)parser.parse(reader);


			for(int i = 0 ; i < array.size(); i++) {
				JSONObject obj = (JSONObject)array.get(i);
				Iterator<?> it = obj.keySet().iterator();
				jvo = new JsonVO();

				while(it.hasNext()) {

					String key = (String) it.next();
					if(key.equals("동명"))jvo.set동명((String)obj.get(key));
					else if(key.equals("설치주소"))jvo.set설치주소((String)obj.get(key));
					else if(key.equals("위 치"))jvo.set위치((String)obj.get(key));

				}
				list.add(jvo);
			}


			
			reader.close();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

	}
}