package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.xml.internal.fastinfoset.Encoder;

public class SearchProductDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	int cnt = 0;

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

	public ArrayList<SearchProductDTO> first_allViewProduct() {
		ArrayList<SearchProductDTO> temp = new ArrayList<SearchProductDTO>();
		int product_seq = 0;
		String product_title = "";
		int product_price = 0;
		int product_cnt = 0;
		String product_url = "";
		String product_category = "";
		String product_reg_date = "";
		String product_source = "";
		String product_img = "";
		getConn();
		try {
			// 검색 초기값은 아마존 데이터 기반
			String sql = "SELECT * FROM t_product where p_source = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "amazon");
			rs = ps.executeQuery();
			while (rs.next()) {
				product_seq = rs.getInt("p_key");
				product_title = rs.getString("p_title");
				product_price = rs.getInt("p_price");
				product_cnt = rs.getInt("p_cnt");
				product_url = rs.getString("p_url");
				product_category = rs.getString("p_category");
				product_reg_date = rs.getString("reg_date");
				product_source = rs.getString("p_source");
				product_img = rs.getString("p_file1");

				temp.add(new SearchProductDTO(product_seq, product_title, product_price, product_cnt, product_url,
						product_category, product_reg_date, product_source, product_img));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}// allViewChangedPrice

	public ArrayList<SearchProductDTO> Search_find(String find) {
		ArrayList<SearchProductDTO> temp = new ArrayList<SearchProductDTO>();

		int product_seq = 0;
		String product_title = "";
		int product_price = 0;
		int product_cnt = 0;
		String product_url = "";
		String product_category = "";
		String product_reg_date = "";
		String product_source = "";
		String product_img = "";
		getConn();
		try {
			String sql = "SELECT * FROM t_product where p_title LIKE '%'||?||'%'";
			ps = conn.prepareStatement(sql);
			System.out.println("찾을 결과값:" + find);
			ps.setString(1, find);
			// System.out.println("데이터처리확인:"+sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				product_seq = rs.getInt("p_key");
				product_title = rs.getString("p_title");
				product_price = rs.getInt("p_price");
				product_cnt = rs.getInt("p_cnt");
				product_url = rs.getString("p_url");
				product_category = rs.getString("p_category");
				product_reg_date = rs.getString("reg_date");
				product_source = rs.getString("p_source");
				product_img = rs.getString("p_file1");

				temp.add(new SearchProductDTO(product_seq, product_title, product_price, product_cnt, product_url,
						product_category, product_reg_date, product_source, product_img));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}
}
