package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONObject;

import com.MedicimeMS.Tool.DBConn;

public class fillCusDao {

	private Connection conn=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	public JSONObject find(int i){
		
		  try {
			  conn=DBConn.getCon();
			  st=conn.prepareStatement("Select * from T_Hospital where HospitalId=?");
			  st.setInt(1, i);
			  rs=st.executeQuery();
			  JSONObject ob=new JSONObject();
			  while(rs.next()){
				  ob.put("hospitalid", rs.getInt("HospitalId"));
				  ob.put("hospitalname",rs.getString("HospitalName"));
				  ob.put("address",rs.getString("Address"));
				  ob.put("person",rs.getString("Person"));
				  ob.put("phone",rs.getString("Phone"));
				  ob.put("areaid",rs.getString("AreaId"));
			  }
			  return ob;
		} catch (Exception e) {
			// TODO: handle exception
		}
		  return null;
	  }
	
}
