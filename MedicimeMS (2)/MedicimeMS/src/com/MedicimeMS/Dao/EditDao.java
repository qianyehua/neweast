package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONObject;

import com.MedicimeMS.Tool.DBConn;

public class EditDao {

	private Connection conn=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	public int edituser(JSONObject message){
		try {
			conn=DBConn.getCon();
			st=conn.prepareStatement("update T_User set UserName=?,UserPwd=?,OpenId=?,Name=?,Phone=?,Memo=? where UserId=?");
			st.setString(1, message.getString("username"));
			st.setString(2, message.getString("userpwd"));
			st.setString(3,message.getString("openid"));
			st.setString(4, message.getString("name"));
			st.setString(5, message.getString("phone"));
			st.setString(6, message.getString("memo"));
			st.setInt(7, Integer.parseInt(message.getString("userid")));
			
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
