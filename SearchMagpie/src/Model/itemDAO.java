package Model;

import java.sql.*;
import java.util.*;

public class itemDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	int cnt = 0;

//DB���� �޼ҵ�.
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

	// t_product ��ǰ �Է� �޼ҵ�
	public int insertItem(itemDTO DTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_item Values(t_item_SEQ.NEXTVAL,?,?,1,?,?,SYSDATE,?,?,?,?,?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, DTO.getItem_title());
			ps.setInt(2, DTO.getItem_price());
			ps.setString(3, DTO.getItem_url());
			ps.setString(4, DTO.getItem_category());
			ps.setString(5, DTO.getItem_source());
			ps.setString(6, DTO.getItem_file1());
			ps.setString(6, DTO.getItem_file2());
			ps.setString(6, DTO.getItem_file3());
			ps.setString(6, DTO.getItem_file4());

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}// insertProduct

	// t_product ���̺� ��ü ��ȸ �޼ҵ�
	public ArrayList<itemDTO> allViewItem() {
		ArrayList<itemDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql = "select * from t_item";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				int item_key = rs.getInt("item_key");
				String item_title = rs.getString("item_title");
				int item_price = rs.getInt("item_price");
				int item_cnt = rs.getInt("item_cnt");
				String item_url = rs.getString("item_url");
				String item_category = rs.getString("item_url");
				String reg_date = rs.getString("reg_date");
				String item_source = rs.getString("item_source");
				String item_file1 = rs.getString("item_file1");
				String item_file2 = rs.getString("item_file2");
				String item_file3 = rs.getString("item_file3");
				String item_file4 = rs.getString("pitem_file4");

				temp.add(new itemDTO(item_key,item_title,item_price,item_cnt,item_url,item_category,reg_date,item_source,item_file1,item_file2,item_file3,item_file4));
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}// allViewProduct

}// class
