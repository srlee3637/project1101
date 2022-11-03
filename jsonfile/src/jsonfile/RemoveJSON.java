package jsonfile;

import java.util.Scanner;

public class RemoveJSON {

	public static void Remove() {
		ReadJsonFile.Read();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 위치의 지번 주소 또는 도로명 주소를 입력해주세요. > ");
		String data = sc.nextLine();

		
		int len = ReadJsonFile.list.size();
		boolean flag = false;
		for(int i=0; i<len; i++) {
			if(ReadJsonFile.list.get(i).get설치주소().contains(data)) {
				ReadJsonFile.list.remove(i);
				flag = true;
				break;
			}
		}
		if(flag)System.out.println("삭제가 완료되었습니다.");
		else System.out.println("해당 주소로 검색된 데이터가 없습니다.");
	}
	
}
