package Model;

public class chartDTO {
	
	private int p_key;
	private String p_name;
	private int p_price;
	private int p_view_cnt;
	private int web_key;
	private String sold_yn;
	private String reg_date;
	private String p_pic1;
	private String p_pic2;
	private String p_pic3;
	private String p_pic4;

	public chartDTO(int p_key, String p_name, int p_price, int p_view_cnt, int web_key, String sold_yn, String reg_date,
			String p_pic1, String p_pic2, String p_pic3, String p_pic4) {
		super();
		this.p_key = p_key;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_view_cnt = p_view_cnt;
		this.web_key = web_key;
		this.sold_yn = sold_yn;
		this.reg_date = reg_date;
		this.p_pic1 = p_pic1;
		this.p_pic2 = p_pic2;
		this.p_pic3 = p_pic3;
		this.p_pic4 = p_pic4;
	}
	
	public chartDTO(int p_key, String p_name, int p_view_cnt) {
		this.p_key = p_key;
		this.p_name = p_name;
		this.p_view_cnt = p_view_cnt;
	}

	public int getP_key() {
		return p_key;
	}

	public void setP_key(int p_key) {
		this.p_key = p_key;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getP_view_cnt() {
		return p_view_cnt;
	}

	public void setP_view_cnt(int p_view_cnt) {
		this.p_view_cnt = p_view_cnt;
	}

	public int getWeb_key() {
		return web_key;
	}

	public void setWeb_key(int web_key) {
		this.web_key = web_key;
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

	public String getP_pic1() {
		return p_pic1;
	}

	public void setP_pic1(String p_pic1) {
		this.p_pic1 = p_pic1;
	}

	public String getP_pic2() {
		return p_pic2;
	}

	public void setP_pic2(String p_pic2) {
		this.p_pic2 = p_pic2;
	}

	public String getP_pic3() {
		return p_pic3;
	}

	public void setP_pic3(String p_pic3) {
		this.p_pic3 = p_pic3;
	}

	public String getP_pic4() {
		return p_pic4;
	}

	public void setP_pic4(String p_pic4) {
		this.p_pic4 = p_pic4;
	}

	@Override
	public String toString() {
		return "chartDTO [p_key=" + p_key + ", p_name=" + p_name + ", p_price=" + p_price + ", p_view_cnt=" + p_view_cnt
				+ ", web_key=" + web_key + ", sold_yn=" + sold_yn + ", reg_date=" + reg_date + ", p_pic1=" + p_pic1
				+ ", p_pic2=" + p_pic2 + ", p_pic3=" + p_pic3 + ", p_pic4=" + p_pic4 + "]";
	}

}