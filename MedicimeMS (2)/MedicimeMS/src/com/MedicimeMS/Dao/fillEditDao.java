package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.MedicimeMS.Tool.DBConn;

public class fillEditDao {
	
	private Connection conn=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	public JSONObject find(int i){
		
		
		  
		  try {
			  conn=DBConn.getCon();
			  st=conn.prepareStatement("Select * from T_User where UserId=?");
			  st.setInt(1, i);
			  rs=st.executeQuery();
			  JSONObject ob=new JSONObject();
			  while(rs.next()){
				  ob.put("userid", rs.getInt("UserId"));
				  ob.put("username",rs.getString("UserName"));
				  ob.put("userpwd",rs.getString("UserPwd"));
				  ob.put("openid",rs.getString("OpenId"));
				  ob.put("name",rs.getString("Name"));
				  ob.put("phone",rs.getString("Phone"));
				  ob.put("memo",rs.getString("Memo"));
			  }
			  return ob;
		} catch (Exception e) {
			// TODO: handle exception
		}
		  return null;
	  }
	
}
