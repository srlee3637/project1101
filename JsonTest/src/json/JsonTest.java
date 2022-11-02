package json;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTest{
    public static void main(String[] args) throws IOException, ParseException {
        // .json 파일 READ
        Reader reader = new FileReader("C:\\Users\\user\\Desktop\\jsontest.json");
        
        // reader를 Object로 parse
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(reader); 
        
     // obj를 JsonArray로 cast
        JSONArray jsonArr = (JSONArray)obj;

        // jsonArr에서 하나씩 JSONObject로 cast해서 사용
        if (jsonArr.size() > 0){
            for(int i=0; i<jsonArr.size(); i++){
                
            	JSONObject jsonObj = (JSONObject)jsonArr.get(i);
            	String a = "뉴딜";
            	
                if(jsonObj.get("정책용어").toString().contains(a)) {
                System.out.println("정책용어: "+jsonObj.get("정책용어"));
                System.out.println("생성배경: "+jsonObj.get("생성배경"));
                System.out.println("용어설명: "+jsonObj.get("용어설명"));
                System.out.println("현재 용어의 사용: "+(String)jsonObj.get("현재 용어의 사용"));
                System.out.println("해외사례: "+(String)jsonObj.get("해외사례"));
                System.out.println("참고자료문헌: "+(String)jsonObj.get("참고자료문헌"));
                System.out.println("작성자: "+(String)jsonObj.get("작성자"));
                }
            }
         
        }
    }
}
