package Model;

import java.sql.*;
import java.util.*;

public class productDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	int cnt = 0;

//DB
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

	// t_product 
	public int insertProduct(productDTO DTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_product Values(t_product_SEQ.NEXTVAL,?,?,1,?,?,SYSDATE,?,?,?,?,?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, DTO.getP_title());
			ps.setInt(2, DTO.getP_price());
			ps.setString(3, DTO.getP_url());
			ps.setString(4, DTO.getP_category());
			ps.setString(5, DTO.getP_source());
			ps.setString(6, DTO.getP_file1());
			ps.setString(6, DTO.getP_file2());
			ps.setString(6, DTO.getP_file3());
			ps.setString(6, DTO.getP_file4());

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}// insertProduct

	// t_product 
	public ArrayList<productDTO> allViewProduct() {
		ArrayList<productDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql = "select * from t_product";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				int p_key = rs.getInt("p_key");
				String p_title = rs.getString("p_title");
				int p_price = rs.getInt("p_price");
				int p_cnt = rs.getInt("p_cnt");
				String p_url = rs.getString("p_url");
				String p_category = rs.getString("p_url");
				String reg_date = rs.getString("reg_date");
				String p_source = rs.getString("p_source");
				String p_file1 = rs.getString("p_file1");
				String p_file2 = rs.getString("p_file2");
				String p_file3 = rs.getString("p_file3");
				String p_file4 = rs.getString("p_file4");

				temp.add(new productDTO(p_key, p_title, p_price, p_cnt, p_url, p_category, reg_date, p_source, p_file1,
						p_file2, p_file3, p_file4));
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}// allViewProduct
	
	public ArrayList<productDTO> find_product(int seq) {
		ArrayList<productDTO> temp = new ArrayList<>();
		getConn();
		//어떻게하지.. 흠..
		//시퀀스기준으로 이름가져와서 다시 그 이름 기준으로 참조된 결과값 가져올까.
		try {
			//시퀀스 기준 제목을 찾아옴
			String sql = "select p_title from t_product where p_key = ?";
			String find_title ="";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, seq);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				find_title = rs.getString("p_title");
			}
			//조회수 증가
			String sql2 = "update t_product set p_cnt = p_cnt+(1) where p_key = ?";
			ps =  conn.prepareStatement(sql2);
			ps.setInt(1, seq);
			
			int result_cnt=ps.executeUpdate();
			System.out.println("수정사항:"+result_cnt);
			//여러개 가져올때, 비교할 데이터
			int half=find_title.length()/2;
			String title=find_title.substring(0,half);
			sql = "select * from t_product where p_title like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, '%'+title+'%');
			
			rs=ps.executeQuery();
			while (rs.next()) {
				int p_key = rs.getInt("p_key");
				String p_title = rs.getString("p_title");
				int p_price = rs.getInt("p_price");
				int p_cnt = rs.getInt("p_cnt");
				String p_url = rs.getString("p_url");
				String p_category = rs.getString("p_url");
				String reg_date = rs.getString("reg_date");
				String p_source = rs.getString("p_source");
				String p_file1 = rs.getString("p_file1");
				String p_file2 = rs.getString("p_file2");
				String p_file3 = rs.getString("p_file3");
				String p_file4 = rs.getString("p_file4");
				System.out.println("타이틀:"+p_title);
				temp.add(new productDTO(p_key, p_title, p_price, p_cnt, p_url, p_category, reg_date, p_source, p_file1,
						p_file2, p_file3, p_file4));
			} 
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}

}// class
