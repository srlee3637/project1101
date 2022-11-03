package jsonfile;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveJsonData {

	public void remove(ArrayList<JsonVO> list) {
		System.out.println("전체 데이터 출력");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+ "번째 인덱스: " + list.get(i));
		}

		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 위치의 인덱스번호를 입력해주세요 > ");
		int num = sc.nextInt();


		int len = list.size();
		boolean flag = false;
		for(int i=0; i<len; i++) {
			if(num == i) {
				list.remove(i);
				flag = true;
				break;
			}
		}
		if(flag)System.out.println("삭제가 완료되었습니다.");
		else System.out.println("해당 주소로 검색된 데이터가 없습니다.");

		
	}

}
