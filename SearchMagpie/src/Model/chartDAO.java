package Model;
import java.sql.*;
import java.util.*;


public class chartDAO {
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
		
		conn = DriverManager.getConnection(db_url,db_id,db_pw);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//getConn
	
	
	public void dbClose() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//dbClose
//DB�� �����Ͽ� ��ǰ ��ȸ���÷��� 1���� ��Ű�� �Լ�
	public void viewCountPlus() {
		getConn();
		try {
			String sql = "INSERT INTO t_product(p_view_cnt) VALUES (+1)";
			
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}//viewCountPlus

//DB�� �����Ͽ� �ش� ��ǰ�� ��ȸ���� ������ ���� �Լ�
	public int getViewCount() {
		getConn();
		try {
			String sql = "SELECT p_view_cnt FROM p_product WHERE p_seq = ?";
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt("p_seq");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}//getViewCount#
	
}//class
