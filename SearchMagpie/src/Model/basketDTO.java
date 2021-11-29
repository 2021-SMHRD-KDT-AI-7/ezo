package Model;

public class basketDTO {
	private int m_key;
	private int p_key;
	private String p_title;
	private int p_price;
	private String p_url;
	private String p_file;
	
	
	
	
	
	
	
	
	
	
	
	public basketDTO(int p_key, String p_title, int p_price, String p_url, String p_file) {
		super();
		this.p_key = p_key;
		this.p_title = p_title;
		this.p_price = p_price;
		this.p_url = p_url;
		this.p_file = p_file;
	}
	public basketDTO(int m_key, int p_key, String p_title, int p_price, String p_url, String p_file) {
		super();
		this.m_key = m_key;
		this.p_key = p_key;
		this.p_title = p_title;
		this.p_price = p_price;
		this.p_url = p_url;
		this.p_file = p_file;
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
	public String getP_title() {
		return p_title;
	}
	public void setP_title(String p_title) {
		this.p_title = p_title;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public String getP_url() {
		return p_url;
	}
	public void setP_url(String p_url) {
		this.p_url = p_url;
	}
	public String getP_file() {
		return p_file;
	}
	public void setP_file(String p_file) {
		this.p_file = p_file;
	}
	
	
	
	
}