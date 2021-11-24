package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class basketDAO {
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

	public int insertBasket(basketDTO basketDTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_basket VALUES(?,?,?,SYSDATE)";

			ps = conn.prepareStatement(sql);
			//m_key ����� �ҷ����� �Լ� ���� �ֱ�
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
	public ArrayList<basketDTO> allViewBasket(basketDTO DTO){
		ArrayList<basketDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql = "SELECT * FROM t_basket WHERE m_key = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, DTO.getM_key());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int p_key = rs.getInt("p_key");
				int item_key = rs.getInt("item_key");
				String reg_date = rs.getString("reg_date");
				
				temp.add(new basketDTO(p_key,item_key,reg_date));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		
		return temp;
	}//allViewBasket
	
}// class
