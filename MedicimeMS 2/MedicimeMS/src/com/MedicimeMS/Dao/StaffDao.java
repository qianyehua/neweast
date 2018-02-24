package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.MedicimeMS.Tool.DBConn;

public class StaffDao {

	private Connection conn;
	private PreparedStatement prst;
	private ResultSet rs;
	
public JSONArray getStaffById(int id) {
		
		
		conn=DBConn.getCon();
		JSONArray arr=new JSONArray();
	    JSONObject o1 =new JSONObject();
	    o1.put("text","全部");
	    o1.put("id",0);
	    o1.put("selected", true);
	    arr.add(o1);
	    
	    try {
	      if(id==0){
	      	prst=conn.prepareStatement("select Name,T_User.UserId from T_User,T_UserRole,T_Role where Role in('业务员','部门经理') and T_UserRole.RoleId=T_Role.RoleId and T_User.UserId=T_UserRole.UserId");	
	      }
	      else{
			prst=conn.prepareStatement("select Name,UserId from T_User where UserId=?");	
			prst.setInt(1, id);
	      }
			rs=prst.executeQuery();
			
			JSONObject o=null;
			
			while(rs.next()){
			      o =new JSONObject();		   
				  o.put("text",rs.getString("Name"));
				  o.put("id",rs.getInt("UserId"));		      
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

public JSONArray getStaffById2(int id,int userid) {
	
	
	conn=DBConn.getCon();
	JSONArray arr=new JSONArray();
    JSONObject o1 =new JSONObject();
    o1.put("text","全部");
    o1.put("id",0);
    o1.put("selected", true);
    arr.add(o1);
    
    try {
      if(id==0){
      	prst=conn.prepareStatement("select Name,T_User.UserId from T_User,T_UserRole,T_Role where Role in('业务员','部门经理')and T_UserRole.RoleId=T_Role.RoleId and T_User.UserId=T_UserRole.UserId and T_User.DeptId =(select DeptId from T_Dept where T_Dept.UserId='"+userid+"')");	
      }
      else{
		prst=conn.prepareStatement("select Name,UserId from T_User where UserId=?");	
		prst.setInt(1, id);
      }
		rs=prst.executeQuery();
		
		JSONObject o=null;
		
		while(rs.next()){
		      o =new JSONObject();		   
			  o.put("text",rs.getString("Name"));
			  o.put("id",rs.getInt("UserId"));		      
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

public JSONObject getVisitAmountByUserId(int id, String year, String username) {
	conn=DBConn.getCon();
    int amount[]={0,0,0,0,0,0,0,0,0,0,0,0};	
	JSONObject o=new JSONObject();
	try {		

		prst=conn.prepareStatement("select VisitTime from T_Visit where UserId=?");
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
	o.put("username",username);
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


public JSONArray getAddHos() {
	
	
	conn=DBConn.getCon();
	JSONArray arr=new JSONArray();
    try {
      
      	prst=conn.prepareStatement("select * from T_Hospital");	
      
     
		rs=prst.executeQuery();
		
		JSONObject o=null;
		
		while(rs.next()){
		      o =new JSONObject();		   
			  o.put("text",rs.getString("HospitalName"));
			  o.put("id",rs.getInt("HospitalId"));
			  o.put("selected", true);
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

public JSONArray getStaffByHospitalId(int id) {

	conn=DBConn.getCon();
	JSONArray arr=new JSONArray();
    JSONObject o1 =new JSONObject();
    o1.put("text","全部");
    o1.put("id",0);
    o1.put("selected", true);
    arr.add(o1);
    
    try {
      if(id==0){
      	prst=conn.prepareStatement("select Name,T_User.UserId from T_User,T_UserRole,T_Role where Role='业务经理' and T_UserRole.RoleId=T_Role.RoleId and T_User.UserId=T_UserRole.UserId");	
      }
      else{
		prst=conn.prepareStatement("select Name,T_User.UserId from T_User,T_MoniHos where T_MoniHos.HospitalId=? and T_User.UserId=T_MoniHos.UserId");	
		prst.setInt(1, id);
      }
		rs=prst.executeQuery();
		
		JSONObject o=null;
		
		while(rs.next()){
		      o =new JSONObject();		   
			  o.put("text",rs.getString("Name"));
			  o.put("id",rs.getInt("UserId"));		      
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
   
public JSONArray getDeptStaff(){  
	   
    conn=DBConn.getCon();
    JSONArray arr=new JSONArray();
    
	try{
	    
	      prst=conn.prepareStatement("select UserId,Name from T_User  where  UserId not in (SELECT UserId from T_Dept)");	
	   
	  	rs=prst.executeQuery();	
		JSONObject o=null;	
		while(rs.next()){
		      o =new JSONObject();		   
			  o.put("text",rs.getString("Name"));
			  o.put("id",rs.getInt("UserId"));		      
			  arr.add(o);
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


