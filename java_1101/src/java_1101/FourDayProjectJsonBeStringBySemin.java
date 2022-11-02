package java_1101;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class FourDayProjectJsonBeStringBySemin {

	public static void main(String[] args) throws Exception {
		
		 BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\jsonEx\\Sample.txt"));
		 		
		        String str = null;
		        String[] arr = null;
		        while ((str = reader.readLine()) != null) {
//		            System.out.println(Arrays.toString(str.split("nextLine()")));
		        	
		        	arr = str.split("nextLine()");
		        	System.out.println(Arrays.toString(arr));
		        }
		        
		        
		        reader.close();
				
	}

}
