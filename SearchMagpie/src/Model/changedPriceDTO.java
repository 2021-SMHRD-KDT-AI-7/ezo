package Model;

public class changedPriceDTO {
	private int cp_key;
	private int p_key;
	private int p_price;
	private String reg_date;
	
	public changedPriceDTO(int p_key, int p_price) {
		super();
		this.p_key = p_key;
		this.p_price = p_price;
	}

	public changedPriceDTO(int cp_key, int p_key, int p_price, String reg_date) {
		super();
		this.cp_key = cp_key;
		this.p_key = p_key;
		this.p_price = p_price;
		this.reg_date = reg_date;
	}

	public int getCp_key() {
		return cp_key;
	}

	public void setCp_key(int cp_key) {
		this.cp_key = cp_key;
	}

	public int getP_key() {
		return p_key;
	}

	public void setP_key(int p_key) {
		this.p_key = p_key;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "changedPriceDTO [cp_key=" + cp_key + ", p_key=" + p_key + ", p_price=" + p_price + ", reg_date="
				+ reg_date + "]";
	}
}