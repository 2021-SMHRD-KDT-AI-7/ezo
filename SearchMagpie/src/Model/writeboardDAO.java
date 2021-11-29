package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class writeboardDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	int cnt = 0;

//DB���� �޼ҵ�
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
		// �Խñ� �ۼ� �޼ҵ�

	public int write(writeboardDTO DTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_writeboard VALUES(t_writeboard_SEQ.NEXTVAL,?,?,?,?,SYSDATE,?,?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, DTO.getW_title());
			ps.setString(2, DTO.getW_content());
			ps.setString(3, DTO.getW_writer());
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
		// �Խ��� ��ü��ȸ

	public ArrayList<writeboardDTO> allViewWriteboard() {
		ArrayList<writeboardDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql = "SELECT * FROM t_writeboard ORDER BY reg_date DESC";

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				int w_key = rs.getInt("w_key");
				String w_title = rs.getString("w_title");
				String w_content = rs.getString("w_content");
				String w_writer = rs.getString("w_writer");
				int w_cnt = rs.getInt("w_cnt");
				String reg_date = rs.getString("reg_date");
				String w_file1 = rs.getString("w_file1");
				String w_file2 = rs.getString("w_file2");

				temp.add(new writeboardDTO(w_key, w_title, w_content, w_writer, w_cnt, reg_date, w_file1, w_file2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}// allviewWriteboard
//�Խ��� ��ȸ�� 1����

	public int viewCountUp(int p_key) {
		getConn();
		int viewCnt = 0;
		try {
			String sql = "UPDATE t_writeboard SET w_cnt = w_cnt+1 WHERE w_key = ?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, 1);

			cnt = ps.executeUpdate();

			String sql2 = "SELECT w_cnt FROM t_writeboard WHERE w_key = ?";

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
//�Խ��� ����

	public ArrayList<writeboardDTO> updateWriteboard(writeboardDTO DTO) {
		ArrayList<writeboardDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql = "UPDATE t_writeboard SET w_title=?,w_content=?,reg_date=SYSDATE,w_file1=?,w_file2=? WHERE w_key=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, DTO.getW_title());
			ps.setString(2, DTO.getW_content());
			ps.setString(3, DTO.getW_file1());
			ps.setString(4, DTO.getW_file2());
			ps.setInt(5, DTO.getW_key());

			cnt = ps.executeUpdate();

			String sql2 = "SELECT * FROM t_writeboard WHERE w_key = ?";

			ps = conn.prepareStatement(sql2);

			ps.setInt(1, DTO.getW_key());

			rs = ps.executeQuery();

			if (rs.next()) {
				String w_title = rs.getString("w_title");
				String w_content = rs.getString("w_content");
				String w_file1 = rs.getString("w_file1");
				String w_file2 = rs.getString("w_file2");

				temp.add(new writeboardDTO(w_title, w_content, w_file1, w_file2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return temp;
	}// updateWriteboard

	// �Խñ� ����

	public int deleteWriteboard(int w_key) {
		getConn();
		try {
			String sql = "DELETE FROM t_writeboard WHERE w_key = ?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, w_key);

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}// deleteWriteboard
}// class
