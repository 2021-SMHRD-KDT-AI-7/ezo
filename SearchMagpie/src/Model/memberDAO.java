package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class memberDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	int cnt = 0;
	boolean yn = false;

//DB���� �޼ҵ�
	public void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String db_url = "http://project-db-stu.ddns.net";
			String db_id = "campus_c_e_1111";
			String db_pw = "smhrd5";

			conn = DriverManager.getConnection(db_url, db_id, db_pw);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// getConn

	public void dbClose() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// dbClose

	// web ���� �Է� �� ���� �� cnt ��ȯ
	public int insertWeb(String web_name, String web_url) {
		getConn();
		try {
			String sql = "INSERT INTO t_web VALUES (t_web_SEQ.NEXTVAL,?,?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, web_name);
			ps.setNString(2, web_url);

			int cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}// insertWeb
		// t_member ȸ������ �� �Է� �޼ҵ�

	public int joinMember(memberDTO memberDTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_member VALUES(t_member_SEQ.NEXTVAL,?,?,?,?,SYSDATE,?,0)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, memberDTO.getM_id());
			ps.setString(2, memberDTO.getM_pw());
			ps.setString(3, memberDTO.getM_email());
			ps.setString(4, memberDTO.getM_phone());
			ps.setString(5, memberDTO.getM_status());

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}// insertMember

	// t_member ��� ȸ�� ��ü��ȸ �޼ҵ�
	public ArrayList<memberDTO> allViewMembers() {
		ArrayList<memberDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql = "SELECT * FROM t_member";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				int m_key = rs.getInt("m_key");
				String m_id = rs.getString("m_id");
				String m_pw = rs.getString("m_pw");
				String m_email = rs.getString("m_email");
				String m_phone = rs.getString("m_phone");
				String m_joindate = rs.getString("m_joindate");
				String m_status = rs.getString("m_status");
				String admin_yn = rs.getString("admin_yn");

				temp.add(new memberDTO(m_key, m_id, m_pw, m_email, m_phone, m_joindate, m_status, admin_yn));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}// allViewMembers

	// ������ ���� ȸ������ �޼ҵ�
	public int joinAdmin(memberDTO memberDTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_member VALUES(t_member_SEQ.NEXTVAL,?,?,?,?,SYSDATE,?,1)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, memberDTO.getM_id());
			ps.setString(2, memberDTO.getM_pw());
			ps.setString(3, memberDTO.getM_email());
			ps.setString(4, memberDTO.getM_phone());
			ps.setString(5, memberDTO.getM_status());

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}// insertMember

	// �α��� �޼ҵ�
	public boolean login(memberDTO memberDTO) {
		getConn();
		try {
			String sql = "SELECT m_id, m_pw FROM t_member WHERE m_id = ? AND m_pw = ?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, memberDTO.getM_id());
			ps.setString(2, memberDTO.getM_pw());

			rs = ps.executeQuery();

			if (rs.next()) {
				yn = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return yn;
	}// login

}// class