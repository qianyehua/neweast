package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.MedicimeMS.Tool.DBConn;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class typeDao {

	private Connection conn;
	private PreparedStatement prst;
	private ResultSet rs;
  public JSONArray getTypeId(int id){
	  conn=DBConn.getCon();
		JSONArray arr=new JSONArray();
	    JSONObject o1 =new JSONObject();
	    o1.put("text","È«²¿");
	    o1.put("id",0);
	    o1.put("selected", true);
	    arr.add(o1);
	    
	    try {
	      if(id==0){
	      	prst=conn.prepareStatement("select InfoTypeId,TypeName from T_InfoType");	
	      }
	      else{
			prst=conn.prepareStatement("select InfoTypeId,TypeName from T_InfoType where InfoTypeId=?");	
			prst.setInt(1, id);
	      }
			rs=prst.executeQuery();
			
			JSONObject o=null;
			
			while(rs.next()){
			      o =new JSONObject();		   
				  o.put("text",rs.getString("TypeName"));
				  o.put("id",rs.getInt("InfoTypeId"));		      
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
