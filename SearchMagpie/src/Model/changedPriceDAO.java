package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class changedPriceDAO {
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
	
	//가격변동 입력 메소드
	public int insertChangedPrice(changedPriceDTO DTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_ch_price VALUES(t_ch_price_SEQ.NEXTVAL,?,?,?,?,?,SYSDATE)";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, DTO.getP_key());
			ps.setInt(2, DTO.getItem_key());
			ps.setInt(3, DTO.getP_price());
			ps.setInt(4, DTO.getItem_price());
			ps.setInt(5, DTO.getCh_difference());
			
			cnt = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}//insertChangedPrice
	
	//가격변동 전체조회 메소드
	public ArrayList<changedPriceDTO> allViewChangedPrice() {
		ArrayList<changedPriceDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql = "SELECT * FROM t_ch_price";
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int cp_key = rs.getInt("cp_key");
				int p_key = rs.getInt("p_key");
				int item_key = rs.getInt("item_key");
				int p_price = rs.getInt("p_price");
				int item_price = rs.getInt("item_key");
				int ch_difference = rs.getInt("ch_difference");
				String reg_date = rs.getString("reg_date");
				
				temp.add(new changedPriceDTO(cp_key,p_key,item_key,p_price,item_price,ch_difference,reg_date));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return temp;
	}//allViewChangedPrice


}//class
