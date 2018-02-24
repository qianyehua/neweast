package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONArray;

import com.MedicimeMS.Tool.DBConn;



public class RF1Dao {


	private Connection conn=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	public  JSONArray functionId(int RoleId){
		conn=DBConn.getCon();
		JSONArray array=new JSONArray();
		try {
			st=conn.prepareStatement("select FunctionId from T_RoleFunction where RoleId=?");
			st.setInt(1, RoleId);
			rs=st.executeQuery();
			while(rs.next()){
				array.add(rs.getInt("FunctionId"));
			}
			
			return array;
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
		return null;
	}
	

}
