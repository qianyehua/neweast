package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.MedicimeMS.Tool.DBConn;
import com.MedicimeMS.Tool.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class photoDao {

	private Connection conn;
	private PreparedStatement prst;
	private ResultSet rs;
	
	public  JSONArray  getPhotoInfoById(int id, String sdate, String edate){	
		 conn=DBConn.getCon();
	     JSONArray arr=new JSONArray(); 
			   
			try {
				if(id==0){
					prst=conn.prepareStatement("select T_Photo.*,Name from T_Photo,T_User where T_User.UserId=T_Photo.UserId");
				}
				else{
					prst=conn.prepareStatement("select T_Photo.*,Name  from T_Photo,T_User where T_Photo.UserId=? and T_User.UserId=T_Photo.UserId ");
					prst.setInt(1, id);
				}
				rs=prst.executeQuery();
				JSONObject o=null;
				while(rs.next()){
				  if(DateUtil.isInTime(rs.getString("SubmitTime"),sdate, edate)){
					o=new JSONObject();
					o.put("photoid", rs.getInt("PhotoId"));
					o.put("src", rs.getString("PhotoSrc"));
					o.put("photoname", rs.getString("PhotoName"));
					o.put("time", rs.getString("SubmitTime"));
					o.put("name", rs.getString("Name"));
					arr.add(o);
				   }
				}
			 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}finally{
				DBConn.closeDB(conn, prst, rs);
			}
		  return arr;
	}
	public JSONArray getPhotoInfoById2(int pag,int id, String sdate, String edate){
		 try {
			
		 JSONArray s=new JSONArray();
		  
		  int sum=getPhotoInfoById(id,sdate,edate).size();  //获得数据库总条数
		  int x;
		  if(sum>10*pag){
			  x=10*pag;
		  }
		  else{
			  x=sum;
		  }
		  for(int i=10*(pag-1);i<x;i++){
		    	
				s.add(getPhotoInfoById(id,sdate,edate).get(i));   
		    	
		    }
		  return s;
	   
	 } catch (Exception e) {
			// TODO: handle exception
		}
		 return null;
	 }
//	+++++++++++++++++++++++++++++++++++++++++
	public  JSONArray  getPhotoInfoByIdB(int userid,int id, String sdate, String edate){	
		 conn=DBConn.getCon();
	     JSONArray arr=new JSONArray(); 
			   
			try {
				if(id==0){
					prst=conn.prepareStatement("select T_Photo.*,Name from T_Photo,T_User where T_User.UserId=T_Photo.UserId and T_Photo.UserId="+userid+"");
				}
				else{
					prst=conn.prepareStatement("select T_Photo.*,Name  from T_Photo,T_User where T_Photo.UserId=? and T_User.UserId=T_Photo.UserId and T_Photo.UserId="+userid+" ");
					prst.setInt(1, id);
				}
				rs=prst.executeQuery();
				JSONObject o=null;
				while(rs.next()){
				  if(DateUtil.isInTime(rs.getString("SubmitTime"),sdate, edate)){
					o=new JSONObject();
					o.put("photoid", rs.getInt("PhotoId"));
					o.put("src", rs.getString("PhotoSrc"));
					o.put("photoname", rs.getString("PhotoName"));
					o.put("time", rs.getString("SubmitTime"));
					o.put("name", rs.getString("Name"));
					arr.add(o);
				   }
				}
			 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}finally{
				DBConn.closeDB(conn, prst, rs);
			}
		  return arr;
	}
	public JSONArray getPhotoInfoByIdB2(int userid,int pag,int id, String sdate, String edate){
		 try {
			
		 JSONArray s=new JSONArray();
		  
		  int sum=getPhotoInfoByIdB(userid,id,sdate,edate).size();  //获得数据库总条数
		  int x;
		  if(sum>10*pag){
			  x=10*pag;
		  }
		  else{
			  x=sum;
		  }
		  for(int i=10*(pag-1);i<x;i++){
		    	
				s.add(getPhotoInfoByIdB(userid,id,sdate,edate).get(i));   
		    	
		    }
		  return s;
	   
	 } catch (Exception e) {
			// TODO: handle exception
		}
		 return null;
	 }
	
}


