package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.MedicimeMS.Tool.DBConn;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class UserDao {

	private Connection conn=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;
	public JSONArray arryuser(){
		JSONArray userarray =new JSONArray();
		conn=DBConn.getCon();
		try {
			st=conn.prepareStatement("Select * from T_User");
			rs=st.executeQuery();
			while(rs.next()){
				JSONObject ob=new JSONObject();
				ob.put("UserId",rs.getInt("UserId"));
				ob.put("UserName",rs.getString("UserName"));
				ob.put("UserPwd",rs.getString("UserPwd"));
				ob.put("OpenId",rs.getString("OpenId"));
				ob.put("Name",rs.getString("Name"));
				ob.put("Phone",rs.getString("Phone"));
				ob.put("Memo",rs.getString("Memo"));
				userarray.add(ob);
			}
			return userarray;
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
		return null;
	}
	public JSONArray arryuser2(int pag){
		 try {
			
		 JSONArray s=new JSONArray();
		  
		  int sum=arryuser().size();  //获得数据库总条数
		  int x;
		  if(sum>10*pag){
			  x=10*pag;
		  }
		  else{
			  x=sum;
		  }
		  for(int i=10*(pag-1);i<x;i++){
		    	
				s.add(arryuser().get(i));   
		    	
		    }
		  return s;
	   
	 } catch (Exception e) {
			// TODO: handle exception
		}
		 return null;
	 }	
	

}
