package jsonfile;

import java.util.ArrayList;
import java.util.Scanner;

public class ChangeJsonData {


	public void Change(ArrayList<JsonVO> list) {
		System.out.println("전체 데이터 출력");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+ "번째 인덱스: " + list.get(i));
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 인덱스 입력>");
		int a = sc.nextInt();
		System.out.println(list.get(a));
		System.out.println("1: 동명 수정 , 2: 설치주소 수정 , 3: 위치 수정");
		int num = sc.nextInt();
		if(num==1) {
			System.out.println("수정할 내용을 입력하세요");
			list.get(a).set동명(sc.next());
			System.out.println(list.get(a));
		} else if (num==2) {
			sc.nextLine();
			System.out.println("수정할 내용을 입력하세요");
			list.get(a).set설치주소(sc.nextLine());
			System.out.println(list.get(a));

		} else if (num==3) {
			sc.nextLine();
			System.out.println("수정할 내용을 입력하세요");
			list.get(a).set위치(sc.nextLine());
			System.out.println(list.get(a));
		}
		
	}
}
