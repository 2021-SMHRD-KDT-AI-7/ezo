package Model;

public class itemDTO {
	private int item_key;
	private int seller_key;
	private int web_key;
	private String item_buyer;
	private String item_title;
	private String item_content;
	private int item_price;
	private String sold_yn;
	private String reg_date;
	
	public itemDTO(int item_key, int seller_key, int web_key, String item_buyer, String item_title, String item_content,
			int item_price, String sold_yn, String reg_date) {
		super();
		this.item_key = item_key;
		this.seller_key = seller_key;
		this.web_key = web_key;
		this.item_buyer = item_buyer;
		this.item_title = item_title;
		this.item_content = item_content;
		this.item_price = item_price;
		this.sold_yn = sold_yn;
		this.reg_date = reg_date;
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
	public String getItem_buyer() {
		return item_buyer;
	}
	public void setItem_buyer(String item_buyer) {
		this.item_buyer = item_buyer;
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
	@Override
	public String toString() {
		return "itemDTO [item_key=" + item_key + ", seller_key=" + seller_key + ", web_key=" + web_key + ", item_buyer="
				+ item_buyer + ", item_title=" + item_title + ", item_content=" + item_content + ", item_price="
				+ item_price + ", sold_yn=" + sold_yn + ", reg_date=" + reg_date + "]";
	}

}
