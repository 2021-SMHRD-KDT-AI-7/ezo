package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class writerboardDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	int cnt = 0;

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
		// �Խñ� �ۼ� �޼ҵ�

	public int write(writerboardDTO DTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_writerboard VALUES(t_writerboard_SEQ.NEXTVAL,?,?,?,?,SYSDATE,?,?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, DTO.getW_title());
			ps.setString(2, DTO.getW_content());
			ps.setInt(3, DTO.getM_key());
			ps.setInt(4, DTO.getW_cnt());
			ps.setString(5, DTO.getW_file1());
			ps.setString(6, DTO.getW_file2());

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}// write

	public ArrayList<writerboardDTO> allViewWriterboard() {
		ArrayList<writerboardDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql = "SELECT * FROM t_writerboard";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				int w_key = rs.getInt("w_key");
				String w_title = rs.getString("w_title");
				String w_content = rs.getString("w_content");
				int m_key = rs.getInt("m_key");
				int w_cnt = rs.getInt("w_cnt");
				String reg_date = rs.getString("reg_date");
				String w_file1 = rs.getString("w_file1");
				String w_file2 = rs.getString("w_file2");

				temp.add(new writerboardDTO(w_key, w_title, w_content, m_key, w_cnt, reg_date, w_file1, w_file2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}// allviewWriterboard

	public int viewCountUp(int p_key) {
		getConn();
		int viewCnt = 0;
		try {
			String sql = "UPDATE t_writerboard SET w_cnt = w_cnt+1 WHERE w_key = ?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, 1);

			cnt = ps.executeUpdate();

			String sql2 = "SELECT w_cnt FROM t_writerboard WHERE w_key = ?";

			ps = conn.prepareStatement(sql2);

			rs = ps.executeQuery();

			if (rs.next()) {
				viewCnt = rs.getInt("w_cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return viewCnt;
	}// viewCountUp
		// �Խñ� ���� �޼ҵ�

	public ArrayList<writerboardDTO> updateWriterboard(writerboardDTO DTO) {
		ArrayList<writerboardDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql = "UPDATE t_writerboard SET w_title=?,w_content=?,reg_date=SYSDATE,w_file1=?,w_file2=? WHERE w_key=?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, DTO.getW_title());
			ps.setString(2, DTO.getW_content());
			ps.setString(3, DTO.getW_file1());
			ps.setString(4, DTO.getW_file2());
			ps.setInt(5, DTO.getW_key());
			
			cnt = ps.executeUpdate();
			
			String sql2 = "SELECT * FROM t_writerboard WHERE w_key = ?";
			
			ps =  conn.prepareStatement(sql2);
			
			ps.setInt(1, DTO.getW_key());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
			String w_title = 	rs.getString("w_title");
			String w_content = 	rs.getString("w_content");
			String w_file1 = 	rs.getString("w_file1");
			String w_file2 = 	rs.getString("w_file2");
				
			temp.add(new writerboardDTO(w_title,w_content,w_file1,w_file2));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return temp;
	}// updateWriterboard
	
		// �Խñ� ����

	public int deleteWriterboard(int w_key) {
		getConn();
		try {
			String sql = "DELETE * FROM t_wrtierboard WHERE w_key = ?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, w_key);

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}// deleteWriterboard
}// class
