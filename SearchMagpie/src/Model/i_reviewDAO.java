package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class i_reviewDAO {


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

		public int insertI_review(i_reviewDTO DTO) {
			getConn();
			try {
				String sql = "INSERT INTO t_i_review VALUES(t_i_review_SEQ.NEXTVAL,?,?,?,?,?,SYSDATE,?,?)";

				ps = conn.prepareStatement(sql);

				ps.setInt(1, DTO.getM_key());
				ps.setInt(2, DTO.getItem_key());
				ps.setString(3, DTO.getItem_title());
				ps.setString(4, DTO.getV_content());
				ps.setInt(5, DTO.getV_score());
				ps.setString(6, DTO.getV_file1());
				ps.setString(7, DTO.getV_file2());

				cnt = ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
			return cnt;
		}// insertI_review

		public ArrayList<i_reviewDTO> allViewI_review() {
			ArrayList<i_reviewDTO> temp = new ArrayList<>();
			getConn();
			try {
				String sql = "SELECT * FROM t_i_review";

				ps = conn.prepareStatement(sql);

				rs = ps.executeQuery();

				while (rs.next()) {
					int i_v_key = rs.getInt("i_v_key");
					int m_key = rs.getInt("m_key");
					int item_key = rs.getInt("item_key");
					String item_title = rs.getString("item_title");
					String v_content = rs.getString("v_content");
					int v_score = rs.getInt("v_score");
					String reg_date = rs.getString("reg_date");
					String v_file1 = rs.getString("v_file1");
					String v_file2 = rs.getString("v_file2");
					
					temp.add(new i_reviewDTO(i_v_key,m_key,item_key,item_title,v_content,v_score,reg_date,v_file1,v_file2));
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
			return temp;
		}// allViewI_review
		
			public int updateI_review(i_reviewDTO DTO) {
				getConn();
				try {
					String sql = "UPDATE t_i_review SET item_title = ?,v_content =? WHERE i_v_key = ?";
					
					ps = conn.prepareStatement(sql);
					
					ps.setString(1, DTO.getItem_title());
					ps.setString(2, DTO.getV_content());
					ps.setInt(3, DTO.getI_v_key());
					
					cnt = ps.executeUpdate();
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally{
					dbClose();
				}
				return cnt;
			}//updateI_review
			
			public int deleteI_review(i_reviewDTO DTO) {
				getConn();
				try {
					String sql = "DELETE * FROM t_i_review WHERE i_v_key = ? ";
					
					ps.setInt(1, DTO.getI_v_key());
					
					cnt =ps.executeUpdate();
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					dbClose();
				}
				return cnt;
			}//deleteI_review
	}// class


