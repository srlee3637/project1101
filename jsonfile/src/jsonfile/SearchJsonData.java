package jsonfile;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchJsonData {

	public void search(ArrayList<JsonVO> list) {

		String name = "";
		Scanner sc = new Scanner(System.in);
		System.out.print("동명을 입력해주세요 : ");      
		name = sc.nextLine();

		for(int i = 0; i <list.size(); i++) {
			if(list.get(i).get동명().contains(name)) {
				System.out.println(list.indexOf(list.get(i)) + "번째 인덱스: " + list.get(i));
				System.out.println("---------------------------------------------------------------------------");
			} 
		}
		
	}
}

