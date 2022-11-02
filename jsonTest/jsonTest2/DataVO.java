package jsonTest2;


//{"동명":"신사동","설치주소":"압구정로14길 6(신사동 548-4)","위  치":"코다차야 남동쪽(가게 앞)"}
public class DataVO {
	
	// 멤버 필드
	private String dong;
	private String address;
	private String location;
	
	// 기본 생성자
	public DataVO() {
		super();
	}
	
	// 전부 전달 받는 생성자
	public DataVO(String dong, String address, String location) {
		super();
		this.dong = dong;
		this.address = address;
		this.location = location;
	}

	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "<상세정보>\n동명: " + dong + "\n주소: " + address + "\n상세위치: " + location + "\n";
	}
	
	
	
}
