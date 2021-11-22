package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class commentDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	int cnt = 0;

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

	// ��� �ۼ� �޼ҵ�
	public int comment(commentDTO DTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_comment VALUES(t_comment_SEQ.NEXTVAL,?,?,?,SYSDATE)";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, DTO.getW_key());
			ps.setInt(2, DTO.getM_key());
			ps.setString(3, DTO.getC_content());

			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}// comment

	public String updateComment(commentDTO DTO) {
		String comment = "";
		getConn();
		try {
			String sql = "UPDATE t_comment set c_content = ?, reg_date = SYSDATE WHERE c_key = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,DTO.getC_content());
			ps.setInt(2,DTO.getC_key());
			
			ps.executeUpdate();
			
			String sql2 = "SELECT * FROM t_comment WHERE c_key = ?";
			
			ps = conn.prepareStatement(sql2);
			
			ps.setInt(1, DTO.getC_key());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
			comment = rs.getString("c_content");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return comment;
	}// updateComment
	//��� ���� �޼ҵ�
	public int deleteComment(int c_key) {
		getConn();
		try {
			String sql = "DELETE * FROM t_comment WHERE c_key = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, c_key);
			
			cnt = ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}//deleteComment
}// class