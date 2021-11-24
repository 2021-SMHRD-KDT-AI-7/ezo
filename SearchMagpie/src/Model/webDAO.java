package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.net.aso.p;

public class webDAO {
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
	
	//web ���� �Է� �� ���� ��  cnt ��ȯ
	public int insertWeb(String web_name, String web_url) {
		getConn();
		try {
			String sql = "INSERT INTO t_web VALUES (t_web_SEQ.NEXTVAL,?,?)";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, web_name);
			ps.setNString(2, web_url);
			
			int cnt = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}//insertWeb
	
	
	//t_web ���̺� ��ü ��ȸ �޼ҵ�
	public ArrayList<webDTO> allViewWebs(){
		ArrayList<webDTO> temp = new ArrayList<>();
		getConn();
		try {
			String sql ="SELECT * FROM t_web";
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int web_key = rs.getInt("web_key");
				String web_name = rs.getString("web_name");
				String web_url = rs.getString("web_url");
				
				temp.add(new webDTO(web_key,web_name,web_url));
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return temp;
	}//allViewWeb
	
	
	
	
}//class
