package jsonfile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WriteJsonFile {
		
	String filename;
	
	public void write(ArrayList<?> list) {
		Scanner sc;
		try {
			sc = new Scanner(System.in);
			System.out.print("만들 파일 이름을 적어주세요>");
			filename = sc.nextLine();
			FileWriter writer = new FileWriter(filename+".json");
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(list);
			
			writer.write("{ \"data\":" + jsonString + "}");
				
			System.out.println("새로운 파일 생성 완료");
			writer.flush();
			writer.close();
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
