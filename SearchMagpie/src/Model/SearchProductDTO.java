package Model;

public class SearchProductDTO {
	int product_seq;
	String product_title;
	int product_price;
	int product_cnt;
	String product_url;
	String product_category;
	String product_reg_date;
	String product_source;
	String product_img;
	public SearchProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchProductDTO(int product_seq, String product_title, int product_price, int product_cnt, String product_url,
			String product_category, String product_reg_date, String product_source, String product_img) {
		super();
		this.product_seq = product_seq;
		this.product_title = product_title;
		this.product_price = product_price;
		this.product_cnt = product_cnt;
		this.product_url = product_url;
		this.product_category = product_category;
		this.product_reg_date = product_reg_date;
		this.product_source = product_source;
		this.product_img = product_img;
	}
	@Override
	public String toString() {
		return "ProductDTO [product_seq=" + product_seq + ", product_title=" + product_title + ", product_price="
				+ product_price + ", product_cnt=" + product_cnt + ", product_url=" + product_url
				+ ", product_category=" + product_category + ", product_reg_date=" + product_reg_date
				+ ", product_source=" + product_source + ", product_img=" + product_img + "]";
	}
	public int getProduct_seq() {
		return product_seq;
	}
	public void setProduct_seq(int product_seq) {
		this.product_seq = product_seq;
	}
	public String getProduct_title() {
		return product_title;
	}
	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getProduct_cnt() {
		return product_cnt;
	}
	public void setProduct_cnt(int product_cnt) {
		this.product_cnt = product_cnt;
	}
	public String getProduct_url() {
		return product_url;
	}
	public void setProduct_url(String product_url) {
		this.product_url = product_url;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	public String getProduct_reg_date() {
		return product_reg_date;
	}
	public void setProduct_reg_date(String product_reg_date) {
		this.product_reg_date = product_reg_date;
	}
	public String getProduct_source() {
		return product_source;
	}
	public void setProduct_source(String product_source) {
		this.product_source = product_source;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	
	
	
}
