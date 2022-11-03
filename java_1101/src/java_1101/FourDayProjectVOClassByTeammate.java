package java_1101;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FourDayProjectVOClassByTeammate {
	
   public static void main(String[] args) throws IOException {
	   ArrayList<JsonByTozi> list = null;
      // 파싱한 데이터를 저장할 변수
      String result = "";
      try {
         URL url = new URL(
               "https://api.odcloud.kr/api/15103349/v1/uddi:06daef13-9cbe-463d-b7b4-b80b1b3ab815?page=1&perPage=45&serviceKey=xPfy6dHytzDFlF%2FeXyANQViKU625Bv9jwlF7rqVdsatUQpuietUPMwl6km4zlNE27Bxcn8%2BZfbvzvET41LhG6A%3D%3D");

         BufferedReader bf;
         
         bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
         
         list = new ArrayList<>();
         result = bf.readLine();
//         System.out.println(result);

         JSONParser jsonParser = new JSONParser();
         JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

         Object data = jsonObject.get("data");

         JSONArray d = (JSONArray) data;
         for (int i = 0; i < d.size(); i++) {
            JSONObject jsonObj = (JSONObject) d.get(i);
            Iterator<?> it = jsonObj.keySet().iterator();
            JsonByTozi json = new JsonByTozi();
               //"동명","설치주소","위  치" 각각 객체에 setting
               while(it.hasNext()) {
                  String key = (String) it.next();
                  if(key.equals("동명")) json.setDong((String)jsonObj.get(key)); 
                  if(key.equals("설치주소")) json.setAddress((String)jsonObj.get(key));
                  if(key.equals("위  치")) json.setLocation((String)jsonObj.get(key)); 
               }
               list.add(json);

            
            
            System.out.println("동명 : " + jsonObj.get("동명"));
            System.out.println("설치주소 : " + jsonObj.get("설치주소"));
            System.out.println("위치 : " + jsonObj.get("위  치"));
            System.out.println();
            
            //json파일로 내보내기
//            try {
//               FileWriter file = new FileWriter("C:\\Users\\user\\mine.json");
//               file.write(jsonObject.toJSONString());
//               file.flush();
//               file.close();
//            } catch (IOException e) {
//               e.printStackTrace();
//         }
      }} catch (Exception e) {
         e.printStackTrace();
      }
      
      
      
      
      
      
      JsonByTozi sample = new JsonByTozi("잠실3동", "잠실5단지", "송파대로 567");      
      list.add(sample);
      list.get(list.size()-1);
      System.out.println(list.get(list.size()-1));
      
      
      StringBuilder sb = new StringBuilder();
      
      BufferedOutputStream bs = null;
      Date d = new Date();
      try {
         bs = new BufferedOutputStream(new FileOutputStream("C:\\Users\\user\\Desktop\\jsonEx\\Sample.json"));
         String str = d + sb.toString();
         bs.write(str.getBytes()); //Byte형으로만 넣을 수 있음

      } catch (Exception e) {
                   e.getStackTrace();
         // TODO: handle exception
      }finally {
         bs.close();
      } 
      
      
      
      
   }
      
   }