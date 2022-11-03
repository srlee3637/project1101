package jsonfile;

import java.util.Scanner;

public class AddJsonData {

	void AddData() {
		ReadJsonFile.Read(); // 일단 파일을 읽어와야 함
//		System.out.println(ReadJsonFile.list);
		String name = "";
		String address = "";
		String location = "";

		Scanner scan = new Scanner(System.in);
		System.out.print("동명을 입력해주세요 : ");		
		name = scan.nextLine();
		System.out.print("설치주소를 입력해주세요 : ");		
		address = scan.nextLine();
		System.out.print("위치를 입력해주세요 : ");		
		location = scan.nextLine();
		System.out.println("추가 완료되었습니다.");
		ReadJsonFile.list.add(new JsonVO(name, address, location));

	}

}
