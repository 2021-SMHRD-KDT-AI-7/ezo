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
	public int viewCountPlus() {
		getConn();
		try {
			String sql = "INSERT INTO t_product(p_view_cnt) VALUES (+1)";
			
			ps = conn.prepareStatement(sql);
			
			cnt = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
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
	
	//DB t_product ���� ��ȸ���� ���� ���� 10���� ��ǰ Ű�� �̸��� ������ ���� �Լ�
	public ArrayList<chartDTO> getViewCountTopTen() {
		ArrayList<chartDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql = "SELECT p_seq,p_name  FROM (SELECT p_name,p_view_cnt, p_seq FROM t_product ORDER BY p_view_cnt DESC) WHERE ROWNUM < 11";
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
			int p_view_cnt = rs.getInt("p_view_cnt");
			String p_name = rs.getString("p_name");
				temp.add(new chartDTO(p_view_cnt,p_name));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return temp;
	}//getViewCountTopTen
	
}//class
