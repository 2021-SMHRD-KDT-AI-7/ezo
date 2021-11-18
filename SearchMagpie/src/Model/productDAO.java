package Model;

import java.sql.*;
import java.util.*;

public class productDAO {
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

	// productDTO 형태의 자료를 파라미터로 입력 받아 DB에 sql문을 통해 입력
	public int insertProduct(productDTO productDTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_product Values(t_product_seq.NEXTVAL,?,?,?,?,?,?,?,SYSDATE,?,?,?,?,?,?,?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, productDTO.getP_name());
			ps.setInt(2, productDTO.getP_price());
			ps.setInt(3, productDTO.getWeb_seq());
			ps.setString(4, productDTO.getP_category());
			ps.setInt(5, productDTO.getP_view_cnt());
			ps.setString(6, productDTO.getP_maker());
			ps.setInt(7, productDTO.getP_weight());
			ps.setString(8, productDTO.getP_made_date());
			ps.setInt(9, productDTO.getM_seq());
			ps.setString(10, productDTO.getP_pic1());
			ps.setString(11, productDTO.getP_pic2());
			ps.setString(12, productDTO.getP_pic3());
			ps.setString(13, productDTO.getP_pic4());
			ps.setString(14, productDTO.getP_pic5());

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}// insertProduct

	// DB에 있는 모든 제품정보를 ArrayList<productDTO>타입으로 반환
	public ArrayList<productDTO> allViewProduct() {
		ArrayList<productDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql = "select * from t_product";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				int p_seq = rs.getInt("p_seq");
				String p_name = rs.getString("p_name");
				int p_price = rs.getInt("p_price");
				int web_seq = rs.getInt("web_seq");
				String p_category = rs.getString("p_category");
				int p_view_cnt = rs.getInt("p_view_cnt");
				String p_maker = rs.getString("p_maker");
				int p_weight = rs.getInt("p_weight");
				String p_name_date = rs.getString("p_name_date");
				String reg_date = rs.getString("reg_date");
				int m_seq = rs.getInt("m_seq");
				String p_pic1 = rs.getString("p_pic1");
				String p_pic2 = rs.getString("p_pic2");
				String p_pic3 = rs.getString("p_pic3");
				String p_pic4 = rs.getString("p_pic4");
				String p_pic5 = rs.getString("p_pic5");
				
temp.add(new productDTO(p_seq,p_name,p_price,web_seq,p_category,p_view_cnt,p_maker,p_weight,p_name_date,reg_date,m_seq,p_pic1,p_pic2,p_pic3,p_pic4,p_pic5));
			}//while

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}// allViewProduct
	
	
}// class
