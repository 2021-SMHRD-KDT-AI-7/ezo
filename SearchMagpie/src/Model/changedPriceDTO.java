package Model;

public class changedPriceDTO {
	private int cp_key;
	private int p_key;
	private int item_key;
	private int p_price;
	private int item_price;
	private int ch_difference;
	private String reg_date;

	public changedPriceDTO(int cp_key, int p_key, int item_key, int p_price, int item_price, int ch_difference,
			String reg_date) {
		super();
		this.cp_key = cp_key;
		this.p_key = p_key;
		this.item_key = item_key;
		this.p_price = p_price;
		this.item_price = item_price;
		this.ch_difference = ch_difference;
		this.reg_date = reg_date;
	}

	public changedPriceDTO(int p_key, int item_key, int p_price, int item_price, int ch_difference) {
		super();
		this.p_key = p_key;
		this.item_key = item_key;
		this.p_price = p_price;
		this.item_price = item_price;
		this.ch_difference = ch_difference;
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

	public int getItem_key() {
		return item_key;
	}

	public void setItem_key(int item_key) {
		this.item_key = item_key;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public int getCh_difference() {
		return ch_difference;
	}

	public void setCh_difference(int ch_difference) {
		this.ch_difference = ch_difference;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "changedPriceDTO [cp_key=" + cp_key + ", p_key=" + p_key + ", item_key=" + item_key + ", p_price="
				+ p_price + ", item_price=" + item_price + ", ch_difference=" + ch_difference + ", reg_date=" + reg_date
				+ "]";
	}
}
