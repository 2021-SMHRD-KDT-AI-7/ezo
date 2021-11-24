package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class alarmDAO {
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
	
	public int insertAlarm(alarmDTO DTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_alarm VALUES(?,?,?,SYSDATE)";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, DTO.getA_key());
			ps.setInt(2, DTO.getR_key());
			ps.setString(3, DTO.getA_content());
			
			cnt = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			dbClose();
		}
		return cnt;
	}//insertAlarm
	
	public ArrayList<alarmDTO> allViewAlarm(){
		ArrayList<alarmDTO> temp = new ArrayList<>();
		getConn();
			try {
				String sql = "SELECT * FROM t_alarm";
				
				ps = conn.prepareStatement(sql);
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					int a_key = rs.getInt("a_key");
					int r_key = rs.getInt("r_key");
					String a_content = rs.getString("a_content");
					String reg_date = rs.getString("reg_date");
					
					temp.add(new alarmDTO(a_key,r_key,a_content,reg_date));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				dbClose();
			}
			return temp;
	}//allViewAlarm
}//class
