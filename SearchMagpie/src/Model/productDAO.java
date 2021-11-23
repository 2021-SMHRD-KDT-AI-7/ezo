package Model;

import java.sql.*;
import java.util.*;

public class productDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	int cnt = 0;

//DB연결 메소드.
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

	// t_product 상품 입력 메소드
	public int insertProduct(productDTO productDTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_product Values(t_product_SEQ.NEXTVAL,?,?,0,?,'N',SYSDATE,?,?,?,?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, productDTO.getP_name());
			ps.setInt(2, productDTO.getP_price());
			ps.setInt(3, productDTO.getWeb_key());
			ps.setString(4, productDTO.getP_pic1());
			ps.setString(5, productDTO.getP_pic2());
			ps.setString(6, productDTO.getP_pic3());
			ps.setString(7, productDTO.getP_pic4());

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}// insertProduct

	//t_product 테이블 전체 조회 메소드
	public ArrayList<productDTO> allViewProduct() {
		ArrayList<productDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql = "select * from t_product";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				int p_key = rs.getInt("p_key");
				String p_name = rs.getString("p_name");
				int p_price = rs.getInt("p_price");
				int p_view_cnt = rs.getInt("p_view_cnt");
				int web_key = rs.getInt("web_key");
				String sold_yn = rs.getString("sold_yn");
				String reg_date = rs.getString("reg_date");
				String p_pic1 = rs.getString("p_pic1");
				String p_pic2 = rs.getString("p_pic2");
				String p_pic3 = rs.getString("p_pic3");
				String p_pic4 = rs.getString("p_pic4");

				temp.add(new productDTO(p_key, p_name, p_price, p_view_cnt, web_key, sold_yn, reg_date, p_pic1, p_pic2,
						p_pic3, p_pic4));
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}// allViewProduct

}// class
