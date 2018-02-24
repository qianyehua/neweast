package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.MedicimeMS.Tool.DBConn;
import com.MedicimeMS.Tool.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ReportDao {
   
	private Connection conn;
	private PreparedStatement prst;
	private ResultSet rs;
	public int getUHReportBy(int uid,
			int hospitalid, String sdate, String edate) {
		
		conn=DBConn.getCon();
		int amount=0;
		try {

			prst=conn.prepareStatement("select VisitTime from T_Visit where UserId=? and HospitalId=?");
			prst.setInt(1,uid);
		    prst.setInt(2,hospitalid);	
			rs=prst.executeQuery();
			while(rs.next()){		
				if(DateUtil.isInTime(rs.getString("VisitTime"),sdate, edate)){
				    amount++;			
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}finally{
			DBConn.closeDB(conn, prst, rs);
		}
		 return amount;
	}
}
