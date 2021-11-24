package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class reservedDAO {
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
	
	//�����ϱ� (�Է�) �޼ҵ�
	public int reserve(reservedDTO reservedDTO) {
		getConn();
		try {
			String sql = "INSERT INTO t_reserved VALUES(t_reserved_SEQ.NEXTVAL,?,?,?,?,SYSDATE)";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reservedDTO.getM_key());
			ps.setInt(2, reservedDTO.getP_key());
			ps.setInt(3, reservedDTO.getItem_key());
			ps.setInt(4, reservedDTO.getR_price());
			
			cnt = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}//reserve
	
	//���� ��ü��ȸ �޼ҵ�
	public ArrayList<reservedDTO> allViewReservations(){
		ArrayList<reservedDTO> temp = new ArrayList<>();
		getConn();
		
		try {
			String sql = "SELECT * FROM t_reseved";
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int r_key = rs.getInt("r_key");
				int m_key = rs.getInt("m_key");
				int p_key = rs.getInt("p_key");
				int item_key = rs.getInt("item_key");
				int r_price = rs.getInt("r_price");
				String reg_date = rs.getString("reg_date");
				
				temp.add(new reservedDTO(r_key,m_key,p_key,item_key,r_price,reg_date));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return temp;
	}//allViewReservations
	
	public void findMember() {
		getConn();
		try {
			String sql = "SELECT ";
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}//findMember
	
}//class
