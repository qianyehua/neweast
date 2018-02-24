package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.MedicimeMS.Tool.DBConn;
import com.MedicimeMS.Tool.DateUtil;

public class HospitalDao {

	private Connection conn;
	private PreparedStatement prst;
	private ResultSet rs;
	
	
public JSONArray getHospitalByUserId(int id) {
		
		
		conn=DBConn.getCon();
		JSONArray arr=new JSONArray();
	    JSONObject o1 =new JSONObject();
	    o1.put("text","全部");
	    o1.put("id",0);
	    o1.put("selected", true);
	    arr.add(o1);
	   
		try {		
			if(id==0){
			  prst=conn.prepareStatement("select HospitalId,HospitalName from T_Hospital");	
			}
			else{
			  prst=conn.prepareStatement("select HospitalName,T_Hospital.HospitalId from T_Hospital,T_MoniHos where T_MoniHos.UserId=? and T_Hospital.HospitalId=T_MoniHos.HospitalId");
			  prst.setInt(1, id);
			}
			rs=prst.executeQuery();
			JSONObject o=null;
			while(rs.next()){
			      o =new JSONObject();		   
				  o.put("text",rs.getString("HospitalName"));
				  o.put("id",rs.getInt("HospitalId"));		      
				  arr.add(o);;
			}
			
			return arr;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			return null;
		}finally{
			DBConn.closeDB(conn, prst, rs);
		}	

	}

public JSONObject getVisitAmountByHospitalId(int id,String year,String hospital) {
	
	
	conn=DBConn.getCon();
    int amount[]={0,0,0,0,0,0,0,0,0,0,0,0};	
	JSONObject o=new JSONObject();
    
	try {		

		prst=conn.prepareStatement("select VisitTime from T_Visit where HospitalId=?");
		prst.setInt(1, id);
		rs=prst.executeQuery();

		while(rs.next()){	
			String date=rs.getString("VisitTime");

			if(date.substring(0,4).equals(year)){	

				switch(Integer.parseInt(date.substring(5,7))){		     
				  case 1:amount[0]++;break; 
				  case 2: amount[1]++;break; 
				  case 3: amount[2]++;break; 
				  case 4: amount[3]++;break; 
				  case 5: amount[4]++;break; 
				  case 6: amount[5]++;break; 
				  case 7: amount[6]++;break; 
				  case 8: amount[7]++;break; 
				  case 9: amount[8]++;break; 
				  case 10: amount[9]++;break; 		  
				  case 11: amount[10]++;break; 
				  case 12: amount[11]++;break; 
				  default:break;
				}				
			}		
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		

	}finally{
		DBConn.closeDB(conn, prst, rs);
	}	
	o.put("hospital",hospital);
	o.put("1",amount[0]);
	o.put("2",amount[1]);
	o.put("3",amount[2]);
	o.put("4",amount[3]);
	o.put("5",amount[4]);
	o.put("6",amount[5]);
	o.put("7",amount[6]);
	o.put("8",amount[7]);
	o.put("9",amount[8]);
	o.put("10",amount[9]);
	o.put("11",amount[10]);
	o.put("12",amount[11]);
	return o;

}



public JSONArray getHospitalByHospitalId(int id) {

	conn=DBConn.getCon();
	JSONArray arr=new JSONArray();
	conn=DBConn.getCon();
    JSONObject o1 =new JSONObject();
    o1.put("text","全部");
    o1.put("id",0);
    o1.put("selected", true);
    arr.add(o1);
   
	try {		
		if(id==0){
		  prst=conn.prepareStatement("select HospitalId,HospitalName from T_Hospital");	
		}
		else{
		  prst=conn.prepareStatement("select HospitalName,T_Hospital.HospitalId from T_Hospital where HospitalId=?");
		  prst.setInt(1, id);
		}
		rs=prst.executeQuery();
		JSONObject o=null;
		while(rs.next()){
		      o =new JSONObject();		   
			  o.put("text",rs.getString("HospitalName"));
			  o.put("id",rs.getInt("HospitalId"));		      
			  arr.add(o);;
		}	
		return arr;
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		
		return null;
	}finally{
		DBConn.closeDB(conn, prst, rs);
	}	
}


}
