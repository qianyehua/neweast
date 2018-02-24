package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.MedicimeMS.Tool.DBConn;

public class deleRoleDao {

	private Connection conn=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	public int shanchu(int i){
		
		try {
			conn=DBConn.getCon();
			int roleid;
			st=conn.prepareStatement("SELECT top 1 RoleId from T_Role where RoleId not in(select top "+i+" RoleId from T_Role)");
			rs=st.executeQuery();
		     while(rs.next()){
		    	 roleid=rs.getInt("RoleId");
		    	 return roleid;
		     }
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}
	  public int shanchu2(int x){
		  
		  try {
			  conn=DBConn.getCon();
			  st=conn.prepareStatement("delete from T_Role where RoleId=?");
			  st.setInt(1, x);
			  int c=st.executeUpdate();
			  return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		  return 0;
	  }
	
}
