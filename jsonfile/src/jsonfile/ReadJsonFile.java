package jsonfile;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonFile {
	
	ArrayList<JsonVO> list = new ArrayList<>();
	
	public void Read(String filename ,ArrayList <JsonVO> list) {
		JSONParser parser = new JSONParser();
		JSONArray array;
		JsonVO jvo;
		try {
			FileReader reader = new FileReader(filename + ".json");
			JSONObject jo = (JSONObject)parser.parse(reader);
			Scanner sc = new Scanner(System.in);
			System.out.println("불러올 데이터 이름을 입력하세요>");
			array = (JSONArray)jo.get(sc.nextLine());


			for(int i = 0 ; i < array.size(); i++) {
				
				JSONObject obj = (JSONObject)array.get(i);
				Iterator<?> it = obj.keySet().iterator();
				jvo = new JsonVO();

				while(it.hasNext()) {

					String key = (String) it.next();
					if(key.equals("동명"))jvo.set동명((String)obj.get(key));
					else if(key.equals("설치주소"))jvo.set설치주소((String)obj.get(key));
					else if(key.equals("위  치"))jvo.set위치((String)obj.get(key));

				}
				
				list.add(jvo);
			}
			
			System.out.println(list);
			
			
			reader.close();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

	}
}