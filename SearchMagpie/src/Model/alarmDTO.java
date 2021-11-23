package Model;

public class alarmDTO {
	private int a_key;
	private int r_key;
	private String a_content;
	private String reg_date;
	
	public alarmDTO(int a_key, int r_key, String a_content) {
		super();
		this.a_key = a_key;
		this.r_key = r_key;
		this.a_content = a_content;
	}
	
	public alarmDTO(int a_key, int r_key, String a_content, String reg_date) {
		super();
		this.a_key = a_key;
		this.r_key = r_key;
		this.a_content = a_content;
		this.reg_date = reg_date;
	}
	public int getA_key() {
		return a_key;
	}
	public void setA_key(int a_key) {
		this.a_key = a_key;
	}
	public int getR_key() {
		return r_key;
	}
	public void setR_key(int r_key) {
		this.r_key = r_key;
	}
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "alarmDTO [a_key=" + a_key + ", r_key=" + r_key + ", a_content=" + a_content + ", reg_date=" + reg_date
				+ "]";
	}

}