package Model;

public class itemDTO {
	private int item_key;
	private String item_title;
	private int item_price;
	private int item_cnt;
	private String item_url;
	private String item_category;
	private String reg_date;
	private String item_source;
	private String item_file1;
	private String item_file2;
	private String item_file3;
	private String item_file4;
	
	
	
	public itemDTO(int item_key, String item_title, int item_price, int item_cnt, String item_url, String item_category,
			String reg_date, String item_source, String item_file1, String item_file2, String item_file3,
			String item_file4) {
		super();
		this.item_key = item_key;
		this.item_title = item_title;
		this.item_price = item_price;
		this.item_cnt = item_cnt;
		this.item_url = item_url;
		this.item_category = item_category;
		this.reg_date = reg_date;
		this.item_source = item_source;
		this.item_file1 = item_file1;
		this.item_file2 = item_file2;
		this.item_file3 = item_file3;
		this.item_file4 = item_file4;
	}
	@Override
	public String toString() {
		return "itemDTO [item_key=" + item_key + ", item_title=" + item_title + ", item_price=" + item_price
				+ ", item_cnt=" + item_cnt + ", item_url=" + item_url + ", item_category=" + item_category
				+ ", reg_date=" + reg_date + ", item_source=" + item_source + ", item_file1=" + item_file1
				+ ", item_file2=" + item_file2 + ", item_file3=" + item_file3 + ", item_file4=" + item_file4 + "]";
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
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public int getItem_cnt() {
		return item_cnt;
	}
	public void setItem_cnt(int item_cnt) {
		this.item_cnt = item_cnt;
	}
	public String getItem_url() {
		return item_url;
	}
	public void setItem_url(String item_url) {
		this.item_url = item_url;
	}
	public String getItem_category() {
		return item_category;
	}
	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getItem_source() {
		return item_source;
	}
	public void setItem_source(String item_source) {
		this.item_source = item_source;
	}
	public String getItem_file1() {
		return item_file1;
	}
	public void setItem_file1(String item_file1) {
		this.item_file1 = item_file1;
	}
	public String getItem_file2() {
		return item_file2;
	}
	public void setItem_file2(String item_file2) {
		this.item_file2 = item_file2;
	}
	public String getItem_file3() {
		return item_file3;
	}
	public void setItem_file3(String item_file3) {
		this.item_file3 = item_file3;
	}
	public String getItem_file4() {
		return item_file4;
	}
	public void setItem_file4(String item_file4) {
		this.item_file4 = item_file4;
	}
}