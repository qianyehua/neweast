package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.MedicimeMS.Tool.DBConn;

public class buscharDao {

	private Connection conn;
	private PreparedStatement prst;
	private ResultSet rs;
	
	public JSONArray custom(){
		conn=DBConn.getCon();
		
		try {
			
				 prst=conn.prepareStatement("select h.HospitalName,u.Name,m.MoniHosId from T_Hospital as h,T_User as u,T_MoniHos as m where h.HospitalId=m.HospitalId and m.UserId=u.UserId");
			
			
			rs=prst.executeQuery();
			JSONArray array=new JSONArray();
			while(rs.next()){
				JSONObject ob=new JSONObject();
				ob.put("MoniHosId", rs.getInt("MoniHosId"));
				ob.put("HospitalName", rs.getString("HospitalName"));
				ob.put("Name", rs.getString("Name"));
				array.add(ob);
			}
			return array;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		
		}finally{
			DBConn.closeDB(conn, prst, rs);
		}	
		return null;
		
	}
	public JSONArray custom2(int pag){
		 try {
			
		 JSONArray s=new JSONArray();
		  
		  int sum=custom().size();  //获得数据库总条数
		  int x;
		  if(sum>10*pag){
			  x=10*pag;
		  }
		  else{
			  x=sum;
		  }
		  for(int i=10*(pag-1);i<x;i++){
		    	
				s.add(custom().get(i));   
		    	
		    }
		  return s;
	   
	 } catch (Exception e) {
			// TODO: handle exception
		}
		 return null;
	 }	
	
}
