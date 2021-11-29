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
	
	//���ݺ��� �Է� �޼ҵ�
	public int insertChangedPrice(changedPriceDTO DTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_porduct_price VALUES(t_product_price_SEQ.NEXTVAL,?,?,SYSDATE)";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, DTO.getP_key());
			ps.setInt(2, DTO.getP_price());
			
			cnt = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}//insertChangedPrice
	
	//���ݺ��� ��ü��ȸ �޼ҵ�
	public ArrayList<changedPriceDTO> allViewChangedPrice(int seq) {
		ArrayList<changedPriceDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql = "SELECT * FROM t_product_price WHERE p_key=?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, seq);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int cp_key = rs.getInt("cp_key");
				int p_key = rs.getInt("p_key");
				int p_price = rs.getInt("p_price");
				String reg_date = rs.getString("reg_date");
				
				temp.add(new changedPriceDTO(cp_key,p_key,p_price,reg_date));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return temp;
	}//allViewChangedPrice


}//class
