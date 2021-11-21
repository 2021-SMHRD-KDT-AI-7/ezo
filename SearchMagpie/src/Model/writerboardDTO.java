package Model;

public class writerboardDTO {
	private int w_key;
	private String w_title;
	private String w_content;
	private int m_key;
	private int w_cnt;
	private String reg_date;
	private String w_file1;
	private String w_file2;

	public writerboardDTO(int w_key, String w_title, String w_content, int m_key, int w_cnt, String reg_date,
			String w_file1, String w_file2) {
		super();
		this.w_key = w_key;
		this.w_title = w_title;
		this.w_content = w_content;
		this.m_key = m_key;
		this.w_cnt = w_cnt;
		this.reg_date = reg_date;
		this.w_file1 = w_file1;
		this.w_file2 = w_file2;
	}

	public writerboardDTO(String w_title, String w_content, int m_key, int w_cnt, String w_file1, String w_file2) {
		this.w_title = w_title;
		this.w_content = w_content;
		this.m_key = m_key;
		this.w_cnt = w_cnt;
		this.w_file1 = w_file1;
		this.w_file2 = w_file2;
	}

	public writerboardDTO(int w_key,String w_title,String w_content,String w_file1,String w_file2) {
		this.w_key = w_key;
		this.w_title = w_title;
		this.w_content = w_content;
		this.w_file1 = w_file1;
		this.w_file2 = w_file2;
	}
	public writerboardDTO(String w_title,String w_content,String w_file1,String w_file2) {
		this.w_title = w_title;
		this.w_content = w_content;
		this.w_file1 = w_file1;
		this.w_file2 = w_file2;
	}

	@Override
	public String toString() {
		return "writerboardDTO [w_key=" + w_key + ", w_title=" + w_title + ", w_content=" + w_content + ", m_key="
				+ m_key + ", w_cnt=" + w_cnt + ", reg_date=" + reg_date + ", w_file1=" + w_file1 + ", w_file2="
				+ w_file2 + "]";
	}

	public int getW_key() {
		return w_key;
	}

	public void setW_key(int w_key) {
		this.w_key = w_key;
	}

	public String getW_title() {
		return w_title;
	}

	public void setW_title(String w_title) {
		this.w_title = w_title;
	}

	public String getW_content() {
		return w_content;
	}

	public void setW_content(String w_content) {
		this.w_content = w_content;
	}

	public int getM_key() {
		return m_key;
	}

	public void setM_key(int m_key) {
		this.m_key = m_key;
	}

	public int getW_cnt() {
		return w_cnt;
	}

	public void setW_cnt(int w_cnt) {
		this.w_cnt = w_cnt;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getW_file1() {
		return w_file1;
	}

	public void setW_file1(String w_file1) {
		this.w_file1 = w_file1;
	}

	public String getW_file2() {
		return w_file2;
	}

	public void setW_file2(String w_file2) {
		this.w_file2 = w_file2;
	}

}
