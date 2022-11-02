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
			filename = sc.nextLine();
			System.out.print("만들 파일 이름을 적어주세요>");
			FileWriter writer = new FileWriter(filename+".json");
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(list);
			
			writer.write(jsonString);
				
			
			writer.flush();
			writer.close();
			sc.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
