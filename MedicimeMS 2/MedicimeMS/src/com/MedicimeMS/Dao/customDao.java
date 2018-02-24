package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.MedicimeMS.Tool.DBConn;

public class customDao {

	private Connection conn;
	private PreparedStatement prst;
	private ResultSet rs;
	
	public JSONArray custom(String value){
		conn=DBConn.getCon();
		
		try {
			if(value.equals("全部")){
			    prst=conn.prepareStatement("select p.PropertyName,h.HospitalId,h.HospitalName,h.Address,h.Person,h.Phone,a.Caption,h.Longitude,h.Latitude from T_Hospital as h,T_Area as a,T_Property as p where h.AreaId=a.AreaId and h.Property=p.PropertyId");
			}
			else{
				 prst=conn.prepareStatement("select p.PropertyName,h.HospitalId,h.HospitalName,h.Address,h.Person,h.Phone,a.Caption,h.Longitude,h.Latitude from T_Hospital as h,T_Area as a,T_Property as p where h.AreaId=a.AreaId and h.Property=p.PropertyId and h.HospitalName='"+value+"'");
			}
			
			rs=prst.executeQuery();
			JSONArray array=new JSONArray();
			while(rs.next()){
				JSONObject ob=new JSONObject();
				ob.put("ProName", rs.getString("PropertyName"));
				ob.put("HospitalId", rs.getInt("HospitalId"));
				ob.put("HospitalName", rs.getString("HospitalName"));
				ob.put("Address", rs.getString("Address"));
				ob.put("Person", rs.getString("Person"));
				ob.put("Phone", rs.getString("Phone"));
				ob.put("Caption", rs.getString("Caption"));
				ob.put("Longitude", rs.getString("Longitude"));
				ob.put("Latitude", rs.getString("Latitude"));
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
	public JSONArray custom2(int pag,String value){
		 try {
			
		 JSONArray s=new JSONArray();
		  
		  int sum=custom(value).size();  //获得数据库总条数
		  int x;
		  if(sum>10*pag){
			  x=10*pag;
		  }
		  else{
			  x=sum;
		  }
		  for(int i=10*(pag-1);i<x;i++){
		    	
				s.add(custom(value).get(i));   
		    	
		    }
		  return s;
	   
	 } catch (Exception e) {
			// TODO: handle exception
		}
		 return null;
	 }	
	
}
