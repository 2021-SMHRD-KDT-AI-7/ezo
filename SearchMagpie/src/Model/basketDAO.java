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

//DBï¿½ï¿½ï¿½ï¿½ ï¿½Þ¼Òµï¿½
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

	public int addBasket(int mkey, int pkey) {
		productDTO temp = null;
		getConn();
		try {
			String sql = "SELECT * FROM t_product WHERE p_key = ?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, pkey);

			rs = ps.executeQuery();

			if (rs.next()) {
				int p_key = rs.getInt("p_key");
				String p_title = rs.getString("p_title");
				int p_price = rs.getInt("p_price");
				int p_cnt = rs.getInt("p_cnt");
				String p_url = rs.getString("p_url");
				String p_category = rs.getString("p_category");
				String reg_date = rs.getString("reg_date");
				String p_source = rs.getString("p_source");
				String p_file1 = rs.getString("p_file1");
				String p_file2 = rs.getString("p_file2");
				String p_file3 = rs.getString("p_file3");
				String p_file4 = rs.getString("p_file4");

				temp = new productDTO(p_key, p_title, p_price,p_cnt, p_url,p_category,reg_date,p_source,p_file1,p_file2,p_file3,p_file4);
			}
			System.out.print("addBasket Ã¹¹øÂ° Äõ¸®¹® Åë°ú");

			String sql2 = "UPDATE t_basket SET p_key=?, p_title=?, p_price=?, p_url=?, p_file=? WHERE m_key = ?";

			ps = conn.prepareStatement(sql2);

			ps.setInt(1, pkey);
			ps.setString(2, temp.getP_title());
			ps.setInt(3, temp.getP_price());
			ps.setString(4, temp.getP_url());
			ps.setString(5, temp.getP_file1());
			
			ps.setInt(6, mkey);

			cnt = ps.executeUpdate();

			System.out.print("addBasket µÎ¹øÂ° Update¹® Åë°ú");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return pkey;
	}

	public ArrayList<basketDTO> viewBasket(int mkey) {
		ArrayList<basketDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql = "SELECT * FROM t_basket WHERE m_key = ? ";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, mkey);

			rs = ps.executeQuery();

			while (rs.next()) {
				int m_key = rs.getInt("m_key");
				int p_key = rs.getInt("p_key");
				String p_title = rs.getString("p_title");
				int p_price = rs.getInt("p_price");
				String p_url = rs.getString("p_url");
				String p_file = rs.getString("p_file");

				temp.add(new basketDTO(m_key, p_key, p_title, p_price, p_url, p_file));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}
	
	public void deleteWishlist(int mkey) {
		getConn();
		try {
			String sql = "UPDATE t_basket SET p_key=?, p_title=?, p_price=?, p_url = ?, p_file=?  WHERE m_key = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, 0);
			ps.setString(2, " Âò ¸ñ·Ï¿¡ »óÇ°À» Ãß°¡ÇØ º¸¼¼¿ä!");
			ps.setInt(3,0);
			ps.setString(4,"»óÇ° URL");
			ps.setString(5," ");
			ps.setInt(6,mkey);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	
	
	
}
