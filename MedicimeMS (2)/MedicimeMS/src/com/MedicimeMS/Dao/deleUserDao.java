package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONObject;

import com.MedicimeMS.Tool.DBConn;

public class deleUserDao {

	private Connection conn=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	
	public int shanchu(int i){
		
		
		  
		  try {
			  conn=DBConn.getCon();
			  st=conn.prepareStatement("delete from T_User where UserId=?");
			  st.setInt(1, i);
			  int c=st.executeUpdate();
			  return c;
		} catch (Exception e) {
			// TODO: handle exception
		}
		  return 0;
	  }
	
	public int jiebang(int i){
		
		
		  
		  try {
			  conn=DBConn.getCon();
			  st=conn.prepareStatement("update T_User set OpenId=''where UserId=?");
			  st.setInt(1, i);
			  int c=st.executeUpdate();
			  return c;
		} catch (Exception e) {
			// TODO: handle exception
		}
		  return 0;
	  }
	
}
