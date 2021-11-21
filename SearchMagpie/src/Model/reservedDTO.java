package Model;

public class reservedDTO {
	private int r_key;
	private int m_key;
	private int p_key;
	private int item_key;
	private int r_price;
	private String reg_date;
	
	public reservedDTO(int r_key, int m_key, int p_key, int item_key, int r_price, String reg_date) {
		super();
		this.r_key = r_key;
		this.m_key = m_key;
		this.p_key = p_key;
		this.item_key = item_key;
		this.r_price = r_price;
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "reservedDTO [r_key=" + r_key + ", m_key=" + m_key + ", p_key=" + p_key + ", item_key=" + item_key
				+ ", r_price=" + r_price + ", reg_date=" + reg_date + "]";
	}
	public int getR_key() {
		return r_key;
	}
	public void setR_key(int r_key) {
		this.r_key = r_key;
	}
	public int getM_key() {
		return m_key;
	}
	public void setM_key(int m_key) {
		this.m_key = m_key;
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
	public int getR_price() {
		return r_price;
	}
	public void setR_price(int r_price) {
		this.r_price = r_price;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
}
