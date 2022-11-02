package jsonfile;

import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Main {

	public static void main(String[] args) {
		ArrayList<JsonVO> list = new ArrayList<>();
		ReadJsonFile rjf = new ReadJsonFile();
		WriteJsonFile wjf = new WriteJsonFile();
		wjf.write(list);
		rjf.Read();
	}

}
