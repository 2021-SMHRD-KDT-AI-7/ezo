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

//DB占쏙옙占쏙옙 占쌨소듸옙
	public void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
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

	// t_member 회占쏙옙占쏙옙占쏙옙 占쏙옙 占쌉뤄옙 占쌨소듸옙
	public int join(memberDTO memberDTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_member VALUES (t_member_SEQ.NEXTVAL,?,?,?,?,?,?,SYSDATE,'n')";

			ps = conn.prepareStatement(sql);

			ps.setString(1, memberDTO.getM_id());
			ps.setString(2, memberDTO.getM_pw());
			ps.setString(3, memberDTO.getM_name());
			ps.setString(4, memberDTO.getM_nickname());
			ps.setString(5, memberDTO.getM_email());
			ps.setString(6, memberDTO.getM_phone());

			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	// t_member 회占쏙옙占쏙옙占쏙옙 占쏙옙 占쌉뤄옙 占쌨소듸옙

	// t_member 占쏙옙占� 회占쏙옙 占쏙옙체占쏙옙회 占쌨소듸옙
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
				String m_name = rs.getString("m_name");
				String m_nickname = rs.getString("m_nickname");
				String m_email = rs.getString("m_email");
				String m_phone = rs.getString("m_phone");
				String m_joindate = rs.getString("m_joindate");
				String admin_yn = rs.getString("admin_yn");

				temp.add(new memberDTO(m_key, m_id, m_pw, m_name, m_nickname, m_email, m_phone, m_joindate, admin_yn));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}// allViewMembers

	// 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 회占쏙옙占쏙옙占쏙옙 占쌨소듸옙
	public int joinAdmin(memberDTO memberDTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_member VALUES(t_member_SEQ.NEXTVAL,?,?,?,?,?,?,SYSDATE,'y')";

			ps = conn.prepareStatement(sql);

			ps.setString(1, memberDTO.getM_id());
			ps.setString(2, memberDTO.getM_pw());
			ps.setString(3, memberDTO.getM_name());
			ps.setString(4, memberDTO.getM_nickname());
			ps.setString(5, memberDTO.getM_email());
			ps.setString(6, memberDTO.getM_phone());

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}// insertMember

	// 占싸깍옙占쏙옙 占쌨소듸옙
	public memberDTO login(String m_id, String m_pw) {
		memberDTO dto = null;
		getConn();
		try {
			String sql = "SELECT * FROM t_member WHERE m_id = ? AND m_pw = ?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, m_id);
			ps.setString(2, m_pw);
			rs = ps.executeQuery();
			if (rs.next()) {
				String id = rs.getString("m_id");
				String pw = rs.getString("m_pw");
				String nickname = rs.getString("m_nickname");
				String email = rs.getString("m_email");
				String phone = rs.getNString("m_phone");
				dto = new memberDTO(id, pw, nickname, email, phone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return dto;
	}// login

	public int updateMember(memberDTO DTO) {
		getConn();
		try {
			String sql = "UPDATE t_member SET m_pw = ?,m_name = ?, m_nickname = ?,m_email=?,m_phone=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, DTO.getM_pw());
			ps.setString(2, DTO.getM_name());
			ps.setString(3, DTO.getM_nickname());
			ps.setString(4, DTO.getM_email());
			ps.setString(5, DTO.getM_phone());

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}// updatemember

	public String findId(memberDTO DTO) {
		String m_id = "";
		getConn();
		try {
			String sql = "SELECT m_id FROM t_member WHERE m_name = ? AND m_email = ?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, DTO.getM_name());
			ps.setString(2, DTO.getM_email());

			rs = ps.executeQuery();

			if (rs.next()) {
				m_id = rs.getString("m_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return m_id;
	}

	public String findPw(memberDTO DTO) {
		String m_pw = "";
		getConn();
		try {
			String sql = "SELECT m_pw FROM t_member WHERE m_id = ? AND m_email = ?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, DTO.getM_id());
			ps.setString(2, DTO.getM_email());

			rs = ps.executeQuery();

			if (rs.next()) {
				m_pw = rs.getString("m_pw");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return m_pw;
	}

}// class
