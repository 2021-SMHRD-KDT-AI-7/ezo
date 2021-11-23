package Model;

public class commentDTO {
	private int c_key;
	private int w_key;
	private int m_key;
	private String c_content;
	private String reg_date;
	
	public commentDTO(int c_key, int w_key, int m_key, String c_content, String reg_date) {
		super();
		this.c_key = c_key;
		this.w_key = w_key;
		this.m_key = m_key;
		this.c_content = c_content;
		this.reg_date = reg_date;
	}
	public commentDTO(int w_key, int m_key, String c_content) {
		this.w_key = w_key;
		this.m_key = m_key;
		this.c_content = c_content;
	}
	public commentDTO(int c_key, String c_content) {
		this.c_key = c_key;
		this.c_content = c_content;
	}
	public commentDTO(String c_content) {
		this.c_content = c_content;
	}
	
	public int getC_key() {
		return c_key;
	}
	public void setC_key(int c_key) {
		this.c_key = c_key;
	}
	public int getW_key() {
		return w_key;
	}
	public void setW_key(int w_key) {
		this.w_key = w_key;
	}
	public int getM_key() {
		return m_key;
	}
	public void setM_key(int m_key) {
		this.m_key = m_key;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "commentDTO [c_key=" + c_key + ", w_key=" + w_key + ", m_key=" + m_key + ", c_content=" + c_content
				+ ", reg_date=" + reg_date + "]";
	}

}
