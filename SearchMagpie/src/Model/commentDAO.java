package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class commentDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	int cnt = 0;

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

	// 占쏙옙占� 占쌜쇽옙 占쌨소듸옙
	public ArrayList<commentDTO> comment(commentDTO DTO) {
		ArrayList<commentDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql = "INSERT INTO t_comment VALUES(t_comment_SEQ.NEXTVAL,?,?,?,SYSDATE)";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, DTO.getW_key());
			ps.setInt(2, DTO.getM_key());
			ps.setString(3, DTO.getC_content());

			cnt = ps.executeUpdate();

			String sql2 = "SELECT * FROM t_comment WHERE c_key = ?";

			ps = conn.prepareStatement(sql2);

			ps.setInt(1, DTO.getC_key());

			rs = ps.executeQuery();

			if (rs.next()) {
				String comment = rs.getString("c_content");
				temp.add(new commentDTO(comment));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}// comment
		// 占쏙옙占� 占쏙옙占쏙옙 占쌨소듸옙

	public ArrayList<commentDTO> updateComment(commentDTO DTO) {
		ArrayList<commentDTO> temp = new ArrayList<>();
		//1.jsp사용자로부터 수정한 정보를 입력 받기
		//2. 수정한 정보를 디비에 입력 
		//3. 화면에 출력
		
		getConn();
		try {
			String sql = "UPDATE t_comment set c_content = ?, reg_date = SYSDATE WHERE c_key = ?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, DTO.getC_content());
			ps.setInt(2, DTO.getC_key());

			ps.executeUpdate();

			String sql2 = "SELECT * FROM t_comment WHERE c_key = ?";

			ps = conn.prepareStatement(sql2);

			ps.setInt(1, DTO.getC_key());

			rs = ps.executeQuery();

			if (rs.next()) {
				String comment = rs.getString("c_content");
				temp.add(new commentDTO(comment));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}// updateComment
		// 占쏙옙占� 占쏙옙占쏙옙 占쌨소듸옙

	public int deleteComment(int c_key) {
		getConn();
		try {
			String sql = "DELETE * FROM t_comment WHERE c_key = ?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, c_key);

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}// deleteComment
}// class
