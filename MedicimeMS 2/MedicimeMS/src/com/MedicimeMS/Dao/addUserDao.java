package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.MedicimeMS.Tool.DBConn;

import net.sf.json.JSONObject;


public class addUserDao {

	private Connection conn=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	public int adduser(JSONObject message){
		try {
			conn=DBConn.getCon();
			st=conn.prepareStatement("insert into T_User"+"(UserName,UserPwd,OpenId,Name,Phone,Memo)"+"values(?,?,?,?,?,?)");
			st.setString(1, message.getString("username"));
			st.setString(2, message.getString("userpwd"));
			st.setString(3,message.getString("openid"));
			st.setString(4, message.getString("name"));
			st.setString(5, message.getString("phone"));
			st.setString(6, message.getString("memo"));
			
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
