package jsonfile;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class URLReadJSON {

	public static void main(String[] args) {

		// 파싱한 데이터를 저장할 변수
		String result = "";
		try {
			URL url = new URL(
					"https://api.odcloud.kr/api/15103349/v1/uddi:06daef13-9cbe-463d-b7b4-b80b1b3ab815?page="
					+ "1&perPage=45&serviceKey=xPfy6dHytzDFlF%2FeXyANQViKU625Bv9jwlF7rqVdsatUQpuietUPMwl6km4zlNE27Bxcn8%2BZfbvzvET41LhG6A%3D%3D");

			BufferedReader bf;

			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

			ArrayList<JsonVO> list = new ArrayList<>();
			result = bf.readLine();
			System.out.println(result);

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

			Object data = jsonObject.get("data");

			JSONArray d = (JSONArray) data;
			for (int i = 0; i < d.size(); i++) {
				JSONObject jsonObj = (JSONObject) d.get(i);
				Iterator<?> it = jsonObj.keySet().iterator();
				JsonVO json = new JsonVO();
				//"동명","설치주소","위  치" 각각 객체에 setting
				while(it.hasNext()) {
					String key = (String) it.next();
					if(key.equals("동명")) json.set동명((String)jsonObj.get(key)); 
					if(key.equals("설치주소")) json.set설치주소((String)jsonObj.get(key));
					if(key.equals("위  치")) json.set위치((String)jsonObj.get(key)); 
				}
				list.add(json);



				System.out.println("동명 : " + jsonObj.get("동명"));
				System.out.println("설치주소 : " + jsonObj.get("설치주소"));
				System.out.println("위  치 : " + jsonObj.get("위  치"));


				//json파일로 내보내기
				//		            try {
				//		               FileWriter file = new FileWriter("C:\\Users\\user\\mine.json");
				//		               file.write(jsonObject.toJSONString());
				//		               file.flush();
				//		               file.close();
				//		            } catch (IOException e) {
				//		               e.printStackTrace();
				//		         }
			}} catch (Exception e) {
				e.printStackTrace();
			}
	}




}
