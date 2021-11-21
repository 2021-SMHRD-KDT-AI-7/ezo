package Model;

import java.sql.*;
import java.util.*;

public class chartDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	int cnt = 0;

//DB연결 메소드
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
	
//DB에 접근하여 제품 조회수컬럼을 1증가 시키는 함수
	public int viewCountPlus(int p_key) {
		int viewCnt = 0;
		getConn();
		try {
			String sql = "UPDATE t_product SET p_view_cnt = p_view_cnt+1 WHERE p_key = ?";

			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, 1);

			cnt = ps.executeUpdate();
			
			String sql2 = "SELECT p_view_cnt FROM t_product WHERE p_key = ?";

			ps = conn.prepareStatement(sql2);

			rs = ps.executeQuery();

			if (rs.next()) {
				viewCnt = rs.getInt("w_cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return viewCnt;
	}// viewCountPlus

	// DB t_product 에서 조회수가 가장 높은 10개의 제품 키와 이름을 가지고 오는 함수
	public ArrayList<chartDTO> allViewCountTopTen() {
		ArrayList<chartDTO> temp = new ArrayList<>();
		getConn();

		try {
			String sql = "SELECT p_key,p_name,p_view_count  FROM (SELECT p_key,p_name, p_view_cnt FROM t_product ORDER BY p_view_cnt DESC) WHERE ROWNUM < 11";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				int p_key = rs.getInt("p_key");
				String p_name = rs.getString("p_name");
				int p_view_cnt = rs.getInt("p_view_cnt");
				temp.add(new chartDTO(p_key, p_name, p_view_cnt));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}// getViewCountTopTen

}// class
