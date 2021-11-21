package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class sellerDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	int cnt = 0;
	boolean yn = false;

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
	
	//�ؿ����� �Ǹ��� ��� �޼ҵ�
	public int insertSeller(sellerDTO sellerDTO) {
		getConn();
		try {
			//�������� �ۼ��ϱ�
			String sql = "INSERT INTO t_seller VALUES(t_seller_SEQ.NEXTVAL,?,*��������*)";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, sellerDTO.getSeller_name());
			
			cnt = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}//insertSeller
	
	//�ؿ����� �Ǹ��� ��ü��ȸ �޼ҵ�
	public ArrayList<sellerDTO> allViewSellers() {
		ArrayList<sellerDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql = "SELECT * FROM t_seller";
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int seller_key = rs.getInt("seller_key");
				String seller_name = rs.getString("seller_name");
				int web_key = rs.getInt("web_key");
				
				temp.add(new sellerDTO(seller_key,seller_name,web_key));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return temp;
	}//allViewSeller
	
}//class
