package Model;

public class i_reviewDTO {
	private int i_v_key;
	private int m_key;
	private int item_key;
	private String item_title;
	private String v_content;
	private int v_score;
	private String reg_date;
	private String v_file1;
	private String v_file2;
	
	public i_reviewDTO(int i_v_key) {
		super();
		this.i_v_key = i_v_key;
	}
	public i_reviewDTO(String item_title, String v_content,int i_v_key) {
		super();
		this.item_title = item_title;
		this.v_content = v_content;
		this.i_v_key = i_v_key;
	}
	public i_reviewDTO(int m_key, int item_key, String item_title, String v_content, int v_score, String v_file1,
			String v_file2) {
		super();
		this.m_key = m_key;
		this.item_key = item_key;
		this.item_title = item_title;
		this.v_content = v_content;
		this.v_score = v_score;
		this.v_file1 = v_file1;
		this.v_file2 = v_file2;
	}
	public i_reviewDTO(int i_v_key, int m_key, int item_key, String item_title, String v_content, int v_score,
			String reg_date, String v_file1, String v_file2) {
		super();
		this.i_v_key = i_v_key;
		this.m_key = m_key;
		this.item_key = item_key;
		this.item_title = item_title;
		this.v_content = v_content;
		this.v_score = v_score;
		this.reg_date = reg_date;
		this.v_file1 = v_file1;
		this.v_file2 = v_file2;
	}
	public int getI_v_key() {
		return i_v_key;
	}
	public void setI_v_key(int i_v_key) {
		this.i_v_key = i_v_key;
	}
	public int getM_key() {
		return m_key;
	}
	public void setM_key(int m_key) {
		this.m_key = m_key;
	}
	public int getItem_key() {
		return item_key;
	}
	public void setItem_key(int item_key) {
		this.item_key = item_key;
	}
	public String getItem_title() {
		return item_title;
	}
	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}
	public String getV_content() {
		return v_content;
	}
	public void setV_content(String v_content) {
		this.v_content = v_content;
	}
	public int getV_score() {
		return v_score;
	}
	public void setV_score(int v_score) {
		this.v_score = v_score;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getV_file1() {
		return v_file1;
	}
	public void setV_file1(String v_file1) {
		this.v_file1 = v_file1;
	}
	public String getV_file2() {
		return v_file2;
	}
	public void setV_file2(String v_file2) {
		this.v_file2 = v_file2;
	}
	@Override
	public String toString() {
		return "i_reviewDTO [i_v_key=" + i_v_key + ", m_key=" + m_key + ", item_key=" + item_key + ", item_title="
				+ item_title + ", v_content=" + v_content + ", v_score=" + v_score + ", reg_date=" + reg_date
				+ ", v_file1=" + v_file1 + ", v_file2=" + v_file2 + "]";
	}

}
