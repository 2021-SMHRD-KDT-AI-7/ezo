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

//DB�뜝�룞�삕�뜝�룞�삕 �뜝�뙣�냼�벝�삕
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

	// t_member �쉶�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕 �뜝�뙃琉꾩삕 �뜝�뙣�냼�벝�삕
	public int join(memberDTO memberDTO) {
		int key = 0;
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
				
				ps.executeUpdate();
				
				System.out.println("첫번째 SQL 통과");
				
			String sql2 = "SELECT m_key FROM t_member WHERE m_id = ?";

			ps = conn.prepareStatement(sql2);

			ps.setString(1, memberDTO.getM_id());

			rs = ps.executeQuery();
			
			if(rs.next()) {
				key = rs.getInt("m_key");
			}
			System.out.print("두번째 SQL문 통과");
			
			String sql3 = "INSERT INTO t_basket VALUES (?,?,?,?,?,?)";

			ps = conn.prepareStatement(sql3);
			
			ps.setInt(1, key);
			ps.setInt(2, 0);
			ps.setString(3, "");
			ps.setInt(4, 0);
			ps.setString(5, "");
			ps.setString(6, "");

			ps.executeUpdate();

			System.out.println("세번째 SQL 통과");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return key;
	}
	// t_member �쉶�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕 �뜝�뙃琉꾩삕 �뜝�뙣�냼�벝�삕

	// t_member �뜝�룞�삕�뜝占� �쉶�뜝�룞�삕 �뜝�룞�삕泥닷뜝�룞�삕�쉶 �뜝�뙣�냼�벝�삕
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

	// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕 �쉶�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�뙣�냼�벝�삕
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

	// �뜝�떥源띿삕�뜝�룞�삕 �뜝�뙣�냼�벝�삕
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
				String email = rs.getString("m_email");
				String name = rs.getString("m_name");
				String nickname = rs.getString("m_nickname");
				int key = rs.getInt("m_key");

				dto = new memberDTO(id, pw, name, nickname, email, key);
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
			String sql = "UPDATE t_member SET m_pw = ?,m_name = ?, m_nickname = ?,m_email=?,m_phone=? where m_key=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, DTO.getM_pw());
			ps.setString(2, DTO.getM_name());
			ps.setString(3, DTO.getM_nickname());
			ps.setString(4, DTO.getM_email());
			ps.setString(5, DTO.getM_phone());
			ps.setInt(6, DTO.getM_key());

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}// updatemember

	public String findId(String name, String email) {
		String m_id = "";
		System.out.print("findId DAO 함수 메소드 도입부");
		getConn();
		try {
			String sql = "SELECT m_id FROM t_member WHERE m_name = ? AND m_email = ?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, name);
			ps.setString(2, email);

			rs = ps.executeQuery();

			if (rs.next()) {
				m_id = rs.getString("m_id");
				System.out.println("findId DAO RS반환값 : " + m_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return m_id;
	}

	public String findPw(String m_id, String m_email) {
		String pw = "";
		getConn();
		try {
			String sql = "SELECT m_pw FROM t_member WHERE m_id = ? AND m_email = ?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, m_id);
			ps.setString(2, m_email);

			rs = ps.executeQuery();

			if (rs.next()) {
				pw = rs.getString("m_pw");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return pw;
	}

}// class
