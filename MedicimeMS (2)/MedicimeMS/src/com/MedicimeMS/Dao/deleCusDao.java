package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.MedicimeMS.Tool.DBConn;

public class deleCusDao {

	private Connection conn=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	public int shanchu(int i){
		
		
		  
		  try {
			  conn=DBConn.getCon();
			  st=conn.prepareStatement("delete from T_Hospital where HospitalId=?");
			  st.setInt(1, i);
			  int c=st.executeUpdate();
			  return c;
		} catch (Exception e) {
			// TODO: handle exception
		}
		  return 0;
	  }
	
}
