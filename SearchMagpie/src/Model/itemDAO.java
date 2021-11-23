package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class itemDAO {
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

	// 테이블 수정하기 구매자 m_key
	// 해외직구 아이템 등록하는 메소드
	public int insertItem(itemDTO itemDTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_item VALUES(t_item_SEQ.NEXTVAL,?,?,?,?,?,?,?,SYSDATE,?,?,?,?)";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, itemDTO.getSeller_key());
			ps.setInt(2, itemDTO.getWeb_key());
			ps.setInt(3, Integer.parseInt(itemDTO.getM_key()));
			ps.setString(4, itemDTO.getItem_title());
			ps.setString(5, itemDTO.getItem_content());
			ps.setInt(6, itemDTO.getItem_price());
			ps.setString(7, itemDTO.getSold_yn());
			ps.setString(8, itemDTO.getItem_file1());
			ps.setString(9, itemDTO.getItem_file2());
			ps.setString(10, itemDTO.getItem_file3());
			ps.setString(11, itemDTO.getItem_file4());

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}// insertItem
	
	
	//t_item 해외직구 모든 아이템 전체조회 메소드
	public ArrayList<itemDTO> allViewItems() {
		ArrayList<itemDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql = "SELECT * FROM t_item";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				int item_key = rs.getInt("item_key");
				int seller_key = rs.getInt("seller_key");
				int web_key = rs.getInt("web_key");
				String item_buyer = rs.getString("item_buyer");
				String item_title = rs.getString("item_title");
				String item_content = rs.getString("item_content");
				int item_price = rs.getInt("item_price");
				String sold_yn = rs.getString("sold_yn");
				String reg_date = rs.getString("reg_date");
				String item_file1 = rs.getString("item_file1");
				String item_file2 = rs.getString("item_file2");
				String item_file3 = rs.getString("item_file3");
				String item_file4 = rs.getString("item_file4");

				temp.add(new itemDTO(item_key, seller_key, web_key, item_buyer, item_title, item_content, item_price,
						sold_yn, reg_date, item_file1,item_file2,item_file3,item_file4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}// allViewItems;
}// class
