package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONObject;

import com.MedicimeMS.Tool.DBConn;

public class addRoleDao {

	private Connection conn=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	public int addrole(JSONObject message){
		try {
			conn=DBConn.getCon();
			st=conn.prepareStatement("insert into T_Role"+"(Role,Memo)"+"values(?,?)");
			st.setString(1, message.getString("rolename"));
			st.setString(2, message.getString("memo"));
			
			st.executeUpdate();
			
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
