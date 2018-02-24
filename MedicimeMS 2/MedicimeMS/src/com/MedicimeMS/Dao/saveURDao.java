package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.MedicimeMS.Tool.DBConn;


public class saveURDao {

	private Connection conn=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	public int save(int userid,int roleid){
		conn=DBConn.getCon();
		try {
			st=conn.prepareStatement("insert into T_UserRole"+" (UserId,RoleId) "+"values(?,?)");
			st.setInt(1, userid);
			st.setInt(2, roleid);
			int i=st.executeUpdate();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
			 try {
				   rs.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			   try {
				st.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			   try {
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		 return 0;
		
	}

}
