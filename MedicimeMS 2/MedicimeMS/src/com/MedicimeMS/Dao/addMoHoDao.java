package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONObject;

import com.MedicimeMS.Tool.DBConn;

public class addMoHoDao {
	private Connection conn=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	
public int addMoHo(JSONObject message){
		try {
			conn=DBConn.getCon();
			st=conn.prepareStatement("insert into T_MoniHos"+"(UserId,HospitalId)"+"values(?,?)");
			st.setInt(1,message.getInt("userid"));
            st.setInt(2,message.getInt("hosid"));
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



	public int shanchu(int i){
		  try {
			  conn=DBConn.getCon();
			  st=conn.prepareStatement("delete from T_MoniHos where MoniHosId=?");
			  st.setInt(1, i);
			  int c=st.executeUpdate();
			  return c;
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
