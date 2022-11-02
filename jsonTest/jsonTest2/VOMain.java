package jsonTest2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class VOMain {

	public static void main(String[] args) throws IOException, ParseException {
		
		// 객체 저장용 list
		ArrayList<DataVO> list = new ArrayList<>();
		
		try {
			// 읽어온 json 데이터를 json 배열에 담기
			FileReader reader = new FileReader("voTest.json");
			JSONParser jp = new JSONParser();
			JSONArray arr = (JSONArray) jp.parse(reader);
			
			
			
			for(int i=0; i<arr.size(); i++) {
				
				JSONObject obj = (JSONObject)arr.get(i);
				Iterator<?> it =  obj.keySet().iterator();
				DataVO dv = new DataVO();
				
				//"동명","설치주소","위  치" 각각 객체에 setting
				while(it.hasNext()) {
					String key = (String) it.next();
					if(key.equals("동명")) dv.setDong((String)obj.get(key)); 
					if(key.equals("설치주소")) dv.setAddress((String)obj.get(key));
					if(key.equals("위  치")) dv.setLocation((String)obj.get(key)); 
				}
				list.add(dv);
			}
			
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
				System.out.println("=====================");
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		
		// 파일 json 형식으로 출력
//		try {
//	         FileWriter writer = new FileWriter("Newabc.json");
//	         ObjectMapper mapper = new ObjectMapper();
//	         String jsonString = mapper.writeValueAsString(list);
//	         
//	         writer.write(jsonString);
//	            
//	         writer.flush();
//	         writer.close();
//	         
//	      }catch(IOException e) {
//	         e.printStackTrace();
//	      }

		
		
		
	}

}
