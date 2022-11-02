package java_1101;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FourDayProjectReadJsonBySemin {

	public static void main(String[] args) throws Exception {
		//page=1
		//URL을 입력
		// 전체 URL : https://api.odcloud.kr/api/15103349/v1/uddi:06daef13-9cbe-463d-b7b4-b80b1b3ab815?page=1&perPage=45&serviceKey=jJ%2F7eW0YlYtBAyPaD%2FKzkGdJ5hGzdDIc6BUEyJyc02KYC3ysb4HivMFrzlmbFM9D7xdAoBpe64OOm2X7jEJ4bA%3D%3D
		
		StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15103349/v1/uddi:06daef13-9cbe-463d-b7b4-b80b1b3ab815"); /*URL*/

		urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
		urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("45", "UTF-8")); /*결과 수*/
		urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + "=jJ%2F7eW0YlYtBAyPaD%2FKzkGdJ5hGzdDIc6BUEyJyc02KYC3ysb4HivMFrzlmbFM9D7xdAoBpe64OOm2X7jEJ4bA%3D%3D"); /*Service Key*/

		URL url = new URL(urlBuilder.toString());

		//자바랑 인터넷 연결 요청
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET"); // API에서 GET을 사용하라고 지정해줬음
		conn.setRequestProperty("Content-type", "application/json"); // 데이터 확장자를 JSON 혹은 XML로 받아올 수 있음
		System.out.println("Response code: " + conn.getResponseCode()); // 사이트에서 

		// 인터넷으로부터 데이터 읽어오기
		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		// 읽어온 데이터를 StringBuilder에 담기
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		// 변수에 읽어온 데이터 저장
		value = sb.toString(); 

		System.out.println(value);
		
//////////////////////////////////////////////////////////////////////////////////////////



		// JSONParser에 JSON데이터를 넣어 파싱한 다음 JSONObject로 반환한다.
		JSONObject objData = (JSONObject)new JSONParser().parse(value);
		// JSONObject에서 Array데이터를 get하여 JSONArray에 저장한다.
		JSONArray arrData = (JSONArray)objData.get("data");



		// 배열 데이터 출력하기
		JSONObject tmp;

		for(int i=0; i<arrData.size(); i++){
			tmp = (JSONObject)arrData.get(i);

			sb.append(";동명("+i+"): " + tmp.get("동명")+"\n");
			sb.append("설치주소("+i+"): " + tmp.get("설치주소")+"\n");
			sb.append("위  치("+i+"): " + tmp.get("위  치")+"\n");

			// Array데이터 안에 Array 데이터 꺼내기 
			//              tmpArr = (JSONArray)tmp.get("items");
			//              sb.append("genres("+i+"): ");
			//              for(int j=0; j<tmpArr.size(); j++){
			//                 sb.append(j+"." + tmpArr.get(j));
			//                 if(j!=tmpArr.size()-1) sb.append(", ");
			//              }
			sb.append("\n");
		}
//		System.out.println(sb.toString());
		
		value = sb.toString();
		System.out.println(value
				);


		
		
//		BufferedOutputStream bs = null;
//	      Date d = new Date();
//	      try {
//	         bs = new BufferedOutputStream(new FileOutputStream("C:\\Users\\user\\Desktop\\jsonEx\\Sample.txt"));
//	         String str = d + sb.toString();
//	         bs.write(str.getBytes()); //Byte형으로만 넣을 수 있음
//
//	      } catch (Exception e) {
//	                   e.getStackTrace();
//	         // TODO: handle exception
//	      }finally {
//	         bs.close();
//	      } 









	}
	static String value;


}
