package jsonfile;

import java.util.ArrayList;
import java.util.Scanner;

public class AddJsonData {

	public void add(ArrayList<JsonVO> list){
		String name = "";
		String address = "";
		String location = "";

		Scanner sc = new Scanner(System.in);
		System.out.print("동명을 입력해주세요 : ");      
		name = sc.nextLine();
		System.out.print("설치주소를 입력해주세요 : ");      
		address = sc.nextLine();
		System.out.print("위치를 입력해주세요 : ");      
		location = sc.nextLine();
		System.out.println("추가 완료되었습니다.");
		list.add(new JsonVO(name, address, location));

	}



}


