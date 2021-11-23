package Model;

public class basketDTO {
	private int m_key;
	private int p_key;
	private int item_key;
	private String reg_date;
	
	public basketDTO(int m_key, int p_key, int item_key, String reg_date) {
		super();
		this.m_key = m_key;
		this.p_key = p_key;
		this.item_key = item_key;
		this.reg_date = reg_date;
	}
	public basketDTO(int m_key) {
		super();
		this.m_key = m_key;
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
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "basketDTO [m_key=" + m_key + ", p_key=" + p_key + ", item_key=" + item_key + ", reg_date=" + reg_date
				+ "]";
	}
	
}
