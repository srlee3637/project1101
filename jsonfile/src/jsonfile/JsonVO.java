package jsonfile;

import java.util.List;

public class JsonVO {

	private String 동명;
	private String 설치주소;
	private String 위치;
	
	public JsonVO() {
		super();
	}
	
	public JsonVO(String 동명, String 설치주소, String 위치) {
		super();
		this.동명 = 동명;
		this.설치주소 = 설치주소;
		this.위치 = 위치;
	}

	public String get동명() {
		return 동명;
	}
	public void set동명(String 동명) {
		this.동명 = 동명;
	}
	public String get설치주소() {
		return 설치주소;
	}
	public void set설치주소(String 설치주소) {
		this.설치주소 = 설치주소;
	}
	public String get위치() {
		return 위치;
	}
	public void set위치(String 위치) {
		this.위치 = 위치;
	}
	
	
	
	@Override
	public String toString() {
		return "JsonVO [동명=" + 동명 + ", 설치주소=" + 설치주소 + ", 위치=" + 위치 + "]";
	}
	
	
	
}
