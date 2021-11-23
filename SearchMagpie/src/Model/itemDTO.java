package Model;

public class itemDTO {
	private int seller_key;
	private int web_key;
	private int m_key;
	private String item_title;
	private String item_content;
	private int item_price;
	private String sold_yn;
	private String reg_date;
	private String item_file1;
	private String item_file2;
	private String item_file3;
	private String item_file4;
	private int item_key;

	public itemDTO(int seller_key, int web_key, String item_title, String item_content, int item_price,
			String item_file1, String item_file2, String item_file3, String item_file4) {
		super();
		this.seller_key = seller_key;
		this.web_key = web_key;
		this.item_title = item_title;
		this.item_content = item_content;
		this.item_price = item_price;
		this.item_file1 = item_file1;
		this.item_file2 = item_file2;
		this.item_file3 = item_file3;
		this.item_file4 = item_file4;
	}

	public itemDTO(int seller_key, int web_key, int m_key, String item_title, String item_content, int item_price,
			String sold_yn, String item_file1, String item_file2, String item_file3, String item_file4) {
		super();
		this.seller_key = seller_key;
		this.web_key = web_key;
		this.m_key = m_key;
		this.item_title = item_title;
		this.item_content = item_content;
		this.item_price = item_price;
		this.sold_yn = sold_yn;
		this.item_file1 = item_file1;
		this.item_file2 = item_file2;
		this.item_file3 = item_file3;
		this.item_file4 = item_file4;
	}

	public itemDTO(int item_key, int seller_key, int web_key, int m_key, String item_title, String item_content,
			int item_price, String sold_yn, String reg_date, String item_file1, String item_file2, String item_file3,
			String item_file4) {
		super();
		this.item_key = item_key;
		this.seller_key = seller_key;
		this.web_key = web_key;
		this.m_key = m_key;
		this.item_title = item_title;
		this.item_content = item_content;
		this.item_price = item_price;
		this.sold_yn = sold_yn;
		this.reg_date = reg_date;
		this.item_file1 = item_file1;
		this.item_file2 = item_file2;
		this.item_file3 = item_file3;
		this.item_file4 = item_file4;
	}

	public int getItem_key() {
		return item_key;
	}

	public void setItem_key(int item_key) {
		this.item_key = item_key;
	}

	public int getSeller_key() {
		return seller_key;
	}

	public void setSeller_key(int seller_key) {
		this.seller_key = seller_key;
	}

	public int getWeb_key() {
		return web_key;
	}

	public void setWeb_key(int web_key) {
		this.web_key = web_key;
	}

	public int getM_key() {
		return m_key;
	}

	public void setM_key(int m_key) {
		this.m_key = m_key;
	}

	public String getItem_title() {
		return item_title;
	}

	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}

	public String getItem_content() {
		return item_content;
	}

	public void setItem_content(String item_content) {
		this.item_content = item_content;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public String getSold_yn() {
		return sold_yn;
	}

	public void setSold_yn(String sold_yn) {
		this.sold_yn = sold_yn;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
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

	@Override
	public String toString() {
		return "itemDTO [item_key=" + item_key + ", seller_key=" + seller_key + ", web_key=" + web_key + ", m_key="
				+ m_key + ", item_title=" + item_title + ", item_content=" + item_content + ", item_price=" + item_price
				+ ", sold_yn=" + sold_yn + ", reg_date=" + reg_date + ", item_file1=" + item_file1 + ", item_file2="
				+ item_file2 + ", item_file3=" + item_file3 + ", item_file4=" + item_file4 + "]";
	}

}