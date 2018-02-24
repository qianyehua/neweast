package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.MedicimeMS.Tool.DBConn;


public class UR1Dao {

	private Connection conn=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	public int delete(int userid) {
		conn=DBConn.getCon();
		try {
			st=conn.prepareStatement("DELETE FROM T_UserRole WHERE UserId=?");
			st.setInt(1, userid);
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
