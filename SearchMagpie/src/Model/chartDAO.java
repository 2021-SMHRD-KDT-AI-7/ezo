package Model;

import java.sql.*;
import java.util.*;

public class chartDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	int cnt = 0;

//DB���� �޼ҵ�
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
	
//DB�� �����Ͽ� ��ǰ ��ȸ���÷��� 1���� ��Ű�� �Լ�
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

	// DB t_product ���� ��ȸ���� ���� ���� 10���� ��ǰ Ű�� �̸��� ������ ���� �Լ�
	public ArrayList<chartDTO> allViewCountTopTen() {
		ArrayList<chartDTO> temp = new ArrayList<>();
		getConn();

		try {
			String sql = "SELECT p_key,p_title,p_cnt  FROM (SELECT p_key,p_title, p_cnt FROM t_product ORDER BY p_cnt DESC) WHERE ROWNUM < 11";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				int p_key = rs.getInt("p_key");
				String p_title = rs.getString("p_title");
				int p_cnt = rs.getInt("p_cnt");
				temp.add(new chartDTO(p_key, p_title, p_cnt));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}// getViewCountTopTen

}// class
