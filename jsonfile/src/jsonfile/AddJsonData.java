package jsonfile;

public class AddJsonData {

	public static void main(String[] args) {
		ReadJsonFile.Read();
		System.out.println(ReadJsonFile.list);
		ReadJsonFile.list.remove(0);
		System.out.println(ReadJsonFile.list);
		ReadJsonFile.list.add(new JsonVO("신사동",
				  "강남대로152길 14(신사동 513-2)",
				  "FLASH BAR 동쪽(전신주)"));
		System.out.println(ReadJsonFile.list);
		
		ReadJsonFile.list.get(0).set설치주소("바보");
		System.out.println(ReadJsonFile.list);
	}

}
