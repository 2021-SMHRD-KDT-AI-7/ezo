package Model;

public class memberDTO {
	private int m_key;
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_nickname;
	private String m_email;
	private String m_phone;
	private String m_joindate;
	private String admin_yn;
	
	public memberDTO(String m_id, String m_pw, String m_name, String m_nickname, String m_email, String m_phone) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_nickname = m_nickname;
		this.m_email = m_email;
		this.m_phone = m_phone;
	}
	
	public memberDTO(String m_id, String m_pw, String m_name, String m_nickname, String m_email, int m_key) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_nickname = m_nickname;
		this.m_email = m_email;
		this.m_key = m_key;
	}
	
	
	
	public memberDTO(String m_id, String m_pw) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
	}

	public memberDTO(String m_id, String m_email, int m_key) {
		super();
		this.m_id = m_id;
		this.m_email = m_email;
		this.m_key = m_key;
	}

	public memberDTO(int m_key, String m_id, String m_pw, String m_name, String m_nickname, String m_email,
			String m_phone, String m_joindate, String admin_yn) {
		super();
		this.m_key = m_key;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_nickname = m_nickname;
		this.m_email = m_email;
		this.m_phone = m_phone;
		this.m_joindate = m_joindate;
		this.admin_yn = admin_yn;
	}
	
	
	public int getM_key() {
		return m_key;
	}
	public memberDTO(String m_pw, String m_name, String m_nickname, String m_email, String m_phone) {
		super();
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_nickname = m_nickname;
		this.m_email = m_email;
		this.m_phone = m_phone;
	}

	public void setM_key(int m_key) {
		this.m_key = m_key;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_joindate() {
		return m_joindate;
	}
	public void setM_joindate(String m_joindate) {
		this.m_joindate = m_joindate;
	}
	public String getAdmin_yn() {
		return admin_yn;
	}
	public void setAdmin_yn(String admin_yn) {
		this.admin_yn = admin_yn;
	}
	@Override
	public String toString() {
		return "memberDTO [m_key=" + m_key + ", m_id=" + m_id + ", m_pw=" + m_pw + ", m_name=" + m_name
				+ ", m_nickname=" + m_nickname + ", m_email=" + m_email + ", m_phone=" + m_phone + ", m_joindate="
				+ m_joindate + ", admin_yn=" + admin_yn + "]";
	}

}