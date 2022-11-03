package jsonfile;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	//모든 클래스가 사용할 VO객체 리스트 생성
	static ArrayList<JsonVO> list = new ArrayList<>();
	
	public static void main(String[] args) {
		ReadJsonFile rjf = new ReadJsonFile();
		WriteJsonFile wjf = new WriteJsonFile();
		AddJsonData ajd = new AddJsonData();
		RemoveJsonData rjd = new RemoveJsonData();
		SearchJsonData sjd = new SearchJsonData();
		ChangeJsonData cjd = new ChangeJsonData();
		
		//불러올 파일을 입력해서 가져오기 
		Scanner sc = new Scanner(System.in);
		System.out.println("불러올 파일 이름을 입력하세요>");
		String filename = sc.nextLine();
		rjf.Read(filename,list);
		System.out.println(list.get(1));
		
		int num = 0; 
		boolean bool = true;
		while(bool) {
			System.out.println("=========================================================");
			System.out.println("1: 데이터 추가  2: 데이터 삭제  3: 데이터 수정  4: 데이터 검색  5: 종료");
			
			try {
				num = sc.nextInt();
				
			} catch (Exception e) {
				System.out.println("1 ~ 5 숫자만 입력하세요");
				
			}
			
			switch (num) {
			
			case 1:
				//데이터 추가 
				ajd.add(list);
				break;
			case 2:
				//데이터 삭제
				rjd.remove(list);
				sc.nextLine();
				break;
				
			case 3:
				//데이터 수정
				cjd.Change(list);
				break;
				
			case 4:
				//데이터 검색
				sjd.search(list);
				break;
				
			case 5:
				bool = false;
				break;
				
			}
			
			
		}
		wjf.write(list);
		sc.close();
		
	}
	
}
