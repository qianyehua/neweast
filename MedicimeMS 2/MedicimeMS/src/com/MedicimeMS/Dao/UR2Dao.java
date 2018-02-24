package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.MedicimeMS.Tool.DBConn;

public class UR2Dao {

	private Connection conn=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	public  JSONArray roleid(int UserId){
		conn=DBConn.getCon();
		JSONArray array=new JSONArray();
		 try {
			 st=conn.prepareStatement("SELECT RoleId FROM T_UserRole WHERE UserId=?");
			 st.setInt(1, UserId);
			 rs=st.executeQuery();
			 while(rs.next()){
				 array.add(rs.getInt("RoleId"));
			
			 }
			 
			  
			
				 return array;
			
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
