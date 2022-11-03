package jsonfile;

import java.util.Scanner;

public class SearchJsonData {

	void SearchData() {
		ReadJsonFile.Read();
		System.out.println(ReadJsonFile.list);
		String name = "";

		Scanner scan = new Scanner(System.in);
		System.out.print("동명을 입력해주세요 : ");		
		name = scan.nextLine();

		for(int i = 0; i < ReadJsonFile.list.size(); i++) {
			if(ReadJsonFile.list.get(i).get동명().contains(name)) {
				System.out.println(ReadJsonFile.list.indexOf(ReadJsonFile.list.get(i)) + "번째 인덱스: " + ReadJsonFile.list.get(i));
				//					System.out.println(ReadJsonFile.list.get(i).get동명());
				//					System.out.println(ReadJsonFile.list.get(i).get설치주소());
				//					System.out.println(ReadJsonFile.list.get(i).get위치());
				System.out.println("---------------------------");
			} 
		}

	}


	



	public static void main(String[] args) {
		SearchJsonData ajd = new SearchJsonData();
		ajd.SearchData();
		//			System.out.println(ReadJsonFile.list);
	}

}


