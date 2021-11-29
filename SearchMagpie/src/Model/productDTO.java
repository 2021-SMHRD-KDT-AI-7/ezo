package Model;

public class productDTO {
	private int p_key;
	private String p_title;
	private int p_price;
	private int p_cnt;
	private String p_url;
	private String p_category;
	private String reg_date;
	private String p_source;
	private String p_file1;
	private String p_file2;
	private String p_file3;
	private String p_file4;
	
	
	
	
	public productDTO(String p_title, int p_price, String p_url, String p_category, String p_source, String p_file1,
			String p_file2, String p_file3, String p_file4) {
		super();
		this.p_title = p_title;
		this.p_price = p_price;
		this.p_url = p_url;
		this.p_category = p_category;
		this.p_source = p_source;
		this.p_file1 = p_file1;
		this.p_file2 = p_file2;
		this.p_file3 = p_file3;
		this.p_file4 = p_file4;
	}
	public productDTO(int p_key, String p_title, int p_price, int p_cnt, String p_url, String p_category,
			String reg_date, String p_source, String p_file1, String p_file2, String p_file3, String p_file4) {
		super();
		this.p_key = p_key;
		this.p_title = p_title;
		this.p_price = p_price;
		this.p_cnt = p_cnt;
		this.p_url = p_url;
		this.p_category = p_category;
		this.reg_date = reg_date;
		this.p_source = p_source;
		this.p_file1 = p_file1;
		this.p_file2 = p_file2;
		this.p_file3 = p_file3;
		this.p_file4 = p_file4;
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
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getP_cnt() {
		return p_cnt;
	}
	public void setP_cnt(int p_cnt) {
		this.p_cnt = p_cnt;
	}
	public String getP_url() {
		return p_url;
	}
	public void setP_url(String p_url) {
		this.p_url = p_url;
	}
	public String getP_category() {
		return p_category;
	}
	public void setP_category(String p_category) {
		this.p_category = p_category;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getP_source() {
		return p_source;
	}
	public void setP_source(String p_source) {
		this.p_source = p_source;
	}
	public String getP_file1() {
		return p_file1;
	}
	public void setP_file1(String p_file1) {
		this.p_file1 = p_file1;
	}
	public String getP_file2() {
		return p_file2;
	}
	public void setP_file2(String p_file2) {
		this.p_file2 = p_file2;
	}
	public String getP_file3() {
		return p_file3;
	}
	public void setP_file3(String p_file3) {
		this.p_file3 = p_file3;
	}
	public String getP_file4() {
		return p_file4;
	}
	public void setP_file4(String p_file4) {
		this.p_file4 = p_file4;
	}
	@Override
	public String toString() {
		return "productDTO [p_key=" + p_key + ", p_title=" + p_title + ", p_price=" + p_price + ", p_cnt=" + p_cnt
				+ ", p_url=" + p_url + ", p_category=" + p_category + ", reg_date=" + reg_date + ", p_source="
				+ p_source + ", p_file1=" + p_file1 + ", p_file2=" + p_file2 + ", p_file3=" + p_file3 + ", p_file4="
				+ p_file4 + "]";
	}
	
	
	
}