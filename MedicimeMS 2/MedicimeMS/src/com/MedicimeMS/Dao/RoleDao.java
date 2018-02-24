package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.MedicimeMS.Tool.DBConn;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



public class RoleDao {
	
	
	private Connection conn=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	public  JSONArray arrayrole(){
		JSONArray role=new JSONArray();
		conn=DBConn.getCon();
		try {
			st=conn.prepareStatement("Select * from T_Role");
			rs=st.executeQuery();
			while(rs.next()){
				JSONObject ob=new JSONObject();
				ob.put("RoleId",rs.getInt("RoleId"));
				ob.put("Title",rs.getString("Role"));
				ob.put("Memo",rs.getString("Memo"));
				role.add(ob);
			}
			return role;
		} catch (Exception e) {
			
			
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
		return null;
	}

}
