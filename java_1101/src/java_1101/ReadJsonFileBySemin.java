package java_1101;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ReadJsonFileBySemin {

   public static void main(String[] args) throws Exception {
      
      StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6410000/GOA/GOA001"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=jJ%2F7eW0YlYtBAyPaD%2FKzkGdJ5hGzdDIc6BUEyJyc02KYC3ysb4HivMFrzlmbFM9D7xdAoBpe64OOm2X7jEJ4bA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답결과json, xml구분*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        value = sb.toString();   
        
        
        
        
     // JSONParser에 JSON데이터를 넣어 파싱한 다음 JSONObject로 반환한다.
           JSONObject objData = (JSONObject)new JSONParser().parse(value);
           // JSONObject에서 Array데이터를 get하여 JSONArray에 저장한다.
           JSONArray arrData = (JSONArray)objData.get("items");

           // 배열 데이터 출력하기
           JSONObject tmp;
           JSONArray tmpArr;
           StringBuilder sb2= new StringBuilder();
           for(int i=0; i<arrData.size(); i++){
              tmp = (JSONObject)arrData.get(i);

              sb.append("area("+i+"): " + tmp.get("area")+"\n");
              sb.append("name("+i+"): " + tmp.get("name")+"\n");

              // Array데이터 안에 Array 데이터 꺼내기 
//              tmpArr = (JSONArray)tmp.get("items");
//              sb.append("genres("+i+"): ");
//              for(int j=0; j<tmpArr.size(); j++){
//                 sb.append(j+"." + tmpArr.get(j));
//                 if(j!=tmpArr.size()-1) sb.append(", ");
//              }
              sb.append("\n");
           }
           System.out.println(sb.toString());

        
      
      
      
      
      
      BufferedOutputStream bs = null;
      Date d = new Date();
      try {
         bs = new BufferedOutputStream(new FileOutputStream("C:\\Users\\user\\Desktop\\jsonEx\\Sample.txt"));
         String str = d + sb.toString();
         bs.write(str.getBytes()); //Byte형으로만 넣을 수 있음

      } catch (Exception e) {
                   e.getStackTrace();
         // TODO: handle exception
      }finally {
         bs.close();
      } 
      
      
      
      
      
      
   }
    
   // jsonData
   static String value;
        
        
        
        
        
        
   
   }

