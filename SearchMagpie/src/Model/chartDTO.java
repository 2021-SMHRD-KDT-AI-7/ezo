package Model;

public class chartDTO {
	private int p_seq;
	private String p_name;
	private int p_price;
	private int web_seq;
	private String p_category;
	private int p_view_cnt;
	private String p_maker;
	private int p_weight;
	private String p_made_date;
	private String reg_date;
	private int m_seq;
	private String p_pic1;
	private String p_pic2;
	private String p_pic3;
	private String p_pic4;
	private String p_pic5;

	public chartDTO(int p_seq, String p_name, int p_price, int web_seq, String p_category, int p_view_cnt,
			String p_maker, int p_weight, String p_made_date, String reg_date, int m_seq, String p_pic1, String p_pic2,
			String p_pic3, String p_pic4, String p_pic5) {
		super();
		this.p_seq = p_seq;
		this.p_name = p_name;
		this.p_price = p_price;
		this.web_seq = web_seq;
		this.p_category = p_category;
		this.p_view_cnt = p_view_cnt;
		this.p_maker = p_maker;
		this.p_weight = p_weight;
		this.p_made_date = p_made_date;
		this.reg_date = reg_date;
		this.m_seq = m_seq;
		this.p_pic1 = p_pic1;
		this.p_pic2 = p_pic2;
		this.p_pic3 = p_pic3;
		this.p_pic4 = p_pic4;
		this.p_pic5 = p_pic5;
	}
	public chartDTO(int p_view_cnt, String p_name) {
		this.p_view_cnt = p_view_cnt;
		this.p_name = p_name;
	}

	@Override
	public String toString() {
		return "chartDTO [p_seq=" + p_seq + ", p_name=" + p_name + ", p_price=" + p_price + ", web_seq=" + web_seq
				+ ", p_category=" + p_category + ", p_view_cnt=" + p_view_cnt + ", p_maker=" + p_maker + ", p_weight="
				+ p_weight + ", p_made_date=" + p_made_date + ", reg_date=" + reg_date + ", m_seq=" + m_seq
				+ ", p_pic1=" + p_pic1 + ", p_pic2=" + p_pic2 + ", p_pic3=" + p_pic3 + ", p_pic4=" + p_pic4
				+ ", p_pic5=" + p_pic5 + "]";
	}

	public int getP_seq() {
		return p_seq;
	}

	public void setP_seq(int p_seq) {
		this.p_seq = p_seq;
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

	public int getWeb_seq() {
		return web_seq;
	}

	public void setWeb_seq(int web_seq) {
		this.web_seq = web_seq;
	}

	public String getP_category() {
		return p_category;
	}

	public void setP_category(String p_category) {
		this.p_category = p_category;
	}

	public int getP_view_cnt() {
		return p_view_cnt;
	}

	public void setP_view_cnt(int p_view_cnt) {
		this.p_view_cnt = p_view_cnt;
	}

	public String getP_maker() {
		return p_maker;
	}

	public void setP_maker(String p_maker) {
		this.p_maker = p_maker;
	}

	public int getP_weight() {
		return p_weight;
	}

	public void setP_weight(int p_weight) {
		this.p_weight = p_weight;
	}

	public String getP_made_date() {
		return p_made_date;
	}

	public void setP_made_date(String p_made_date) {
		this.p_made_date = p_made_date;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public int getM_seq() {
		return m_seq;
	}

	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
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

	public String getP_pic5() {
		return p_pic5;
	}

	public void setP_pic5(String p_pic5) {
		this.p_pic5 = p_pic5;
	}

}
