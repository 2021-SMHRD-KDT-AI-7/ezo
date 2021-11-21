package Model;

public class sellerDTO {
	private int seller_key;
	private String seller_name;
	private int web_key;

	public sellerDTO(int seller_key, String seller_name, int web_key) {
		super();
		this.seller_key = seller_key;
		this.seller_name = seller_name;
		this.web_key = web_key;
	}
	public sellerDTO(String seller_name) {
		this.seller_name = seller_name;
	}
	
	public int getSeller_key() {
		return seller_key;
	}
	public void setSeller_key(int seller_key) {
		this.seller_key = seller_key;
	}
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	public int getWeb_key() {
		return web_key;
	}
	public void setWeb_key(int web_key) {
		this.web_key = web_key;
	}
	@Override
	public String toString() {
		return "sellerDTO [seller_key=" + seller_key + ", seller_name=" + seller_name + ", web_key=" + web_key + "]";
	}
}
