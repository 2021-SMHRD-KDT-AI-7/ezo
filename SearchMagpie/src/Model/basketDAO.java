package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class basketDAO {
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

	public int insertBasket(basketDTO basketDTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_basket VALUES(?,?,?,SYSDATE)";

			ps = conn.prepareStatement(sql);
			//m_key 멤버를 불러오는 함수 만들어서 넣기
			ps.setInt(1, basketDTO.getM_key());
			ps.setInt(2, basketDTO.getP_key());
			ps.setInt(3, basketDTO.getItem_key());

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}// insertBasket
	
	public int allDeleteBasket(basketDTO basketDTO) {
		getConn();
		try {
			String sql = "DELETE p_key,item_key,reg_date FROM t_basket WHERE m_key =?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, basketDTO.getM_key());
			
			cnt = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}//allDeleteBasket
	
}// class
