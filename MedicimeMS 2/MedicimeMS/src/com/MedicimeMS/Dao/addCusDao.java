package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONObject;

import com.MedicimeMS.Tool.DBConn;

public class addCusDao {

	private Connection conn=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	public int adduser(JSONObject message){
		
		try {
			
			
			conn=DBConn.getCon();
			st=conn.prepareStatement("insert into T_Hospital"+"(HospitalName,Person,Phone,Address,AreaId,Longitude,Latitude,Property)"+"values(?,?,?,?,?,?,?,?)");
			st.setString(1, message.getString("hospitalname"));
			st.setString(2, message.getString("person"));
			st.setString(3,message.getString("phone"));
			st.setString(4, message.getString("address"));
            st.setInt(5,message.getInt("areaid"));
            st.setString(6, message.getString("longitude"));
            st.setString(7, message.getString("latitude"));
            st.setInt(8, message.getInt("proid"));
			int i=st.executeUpdate();


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
