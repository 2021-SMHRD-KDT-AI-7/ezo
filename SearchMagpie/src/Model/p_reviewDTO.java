package Model;

public class p_reviewDTO {
	private int p_v_key;
	private int m_key;
	private int p_key;
	private String p_title;
	private String v_content;
	private int v_score;
	private String reg_date;
	private String v_file1;
	private String v_file2;
	public p_reviewDTO(int p_v_key) {
		super();
		this.p_v_key = p_v_key;
	}
	public p_reviewDTO(String p_title, String v_content,int p_v_key) {
		super();
		this.p_title = p_title;
		this.v_content = v_content;
		this.p_v_key = p_v_key;
	}
	public p_reviewDTO(int m_key, int p_key, String p_title, String v_content, int v_score, String v_file1,
			String v_file2) {
		super();
		this.m_key = m_key;
		this.p_key = p_key;
		this.p_title = p_title;
		this.v_content = v_content;
		this.v_score = v_score;
		this.v_file1 = v_file1;
		this.v_file2 = v_file2;
	}
	
	public p_reviewDTO(int p_v_key, int m_key, int p_key, String p_title, String v_content, int v_score,
			String reg_date, String v_file1, String v_file2) {
		super();
		this.p_v_key = p_v_key;
		this.m_key = m_key;
		this.p_key = p_key;
		this.p_title = p_title;
		this.v_content = v_content;
		this.v_score = v_score;
		this.reg_date = reg_date;
		this.v_file1 = v_file1;
		this.v_file2 = v_file2;
	}
	public int getP_v_key() {
		return p_v_key;
	}
	public void setP_v_key(int p_v_key) {
		this.p_v_key = p_v_key;
	}
	public int getM_key() {
		return m_key;
	}
	public void setM_key(int m_key) {
		this.m_key = m_key;
	}
	public int getP_key() {
		return p_key;
	}
	public void setP_key(int p_key) {
		this.p_key = p_key;
	}
	public String getP_title() {
		return p_title;
	}
	public void setP_title(String p_title) {
		this.p_title = p_title;
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
		return "p_reviewDTO [p_v_key=" + p_v_key + ", m_key=" + m_key + ", p_key=" + p_key + ", p_title=" + p_title
				+ ", v_content=" + v_content + ", v_score=" + v_score + ", reg_date=" + reg_date + ", v_file1="
				+ v_file1 + ", v_file2=" + v_file2 + "]";
	}

	
}
