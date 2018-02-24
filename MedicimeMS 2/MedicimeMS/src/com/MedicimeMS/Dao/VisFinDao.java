package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.MedicimeMS.Tool.DBConn;
import com.MedicimeMS.Tool.InTime;

public class VisFinDao {

	private Connection conn;
	private PreparedStatement prst;
	private ResultSet rs;
	
	public JSONArray findvisi(int other1,int other2,int value,String sdate,String edate){
		conn=DBConn.getCon();
		InTime intime=new InTime();
		try {
			if(value==0){
				 if(other1==0&&other2==0){
					prst=conn.prepareStatement("select t.TypeName, v.VisitId,v.VisitTime,v.VisitContent,h.HospitalName,u.Name " +
		                    "from T_Visit as v,T_Hospital as h,T_User as u,T_VisitType as t " +
		                      "where v.HospitalId=h.HospitalId and v.UserId=u.UserId and t.VisitTypeId=v.VisitType");
				}
				else if(other1!=0&&other2!=0){
					prst=conn.prepareStatement("select t.TypeName, v.VisitId,v.VisitTime,v.VisitContent,h.HospitalName,u.Name " +
		                    "from T_Visit as v,T_Hospital as h,T_User as u,T_VisitType as t " +
		                      "where v.HospitalId=h.HospitalId and v.UserId=u.UserId and t.VisitTypeId=v.VisitType and v.HospitalId="+other2+" and v.UserId="+other1+"");
				}
				else if(other1!=0&&other2==0){
					  prst=conn.prepareStatement("select t.TypeName, v.VisitId,v.VisitTime,v.VisitContent,h.HospitalName,u.Name " +
		                    "from T_Visit as v,T_Hospital as h,T_User as u,T_VisitType as t " +
		                      "where v.HospitalId=h.HospitalId and v.UserId=u.UserId and t.VisitTypeId=v.VisitType and v.UserId="+other1+"");
				}
				else if(other1==0&&other2!=0){
					prst=conn.prepareStatement("select t.TypeName, v.VisitId,v.VisitTime,v.VisitContent,h.HospitalName,u.Name " +
		                    "from T_Visit as v,T_Hospital as h,T_User as u,T_VisitType as t " +
		                      "where v.HospitalId=h.HospitalId and v.UserId=u.UserId and t.VisitTypeId=v.VisitType and v.HospitalId="+other2+"");
				}
			}
			else {
				 if(other1==0&&other2==0){
					 prst=conn.prepareStatement("select t.TypeName, v.VisitId,v.VisitTime,v.VisitContent,h.HospitalName,u.Name " +
		                    "from T_Visit as v,T_Hospital as h,T_User as u,T_VisitType as t " +
		                      "where v.HospitalId=h.HospitalId and v.UserId=u.UserId and t.VisitTypeId=v.VisitType and v.VisitType="+value+"");
				}
				else if(other1!=0&&other2!=0){
					prst=conn.prepareStatement("select t.TypeName, v.VisitId,v.VisitTime,v.VisitContent,h.HospitalName,u.Name " +
		                    "from T_Visit as v,T_Hospital as h,T_User as u,T_VisitType as t " +
		                      "where v.HospitalId=h.HospitalId and v.UserId=u.UserId and t.VisitTypeId=v.VisitType and v.HospitalId="+other2+" and v.UserId="+other1+" and v.VisitType="+value+"");
				}
				else if(other1!=0&&other2==0){
					prst=conn.prepareStatement("select t.TypeName, v.VisitId,v.VisitTime,v.VisitContent,h.HospitalName,u.Name " +
		                    "from T_Visit as v,T_Hospital as h,T_User as u,T_VisitType as t " +
		                      "where v.HospitalId=h.HospitalId and v.UserId=u.UserId and t.VisitTypeId=v.VisitType and v.UserId="+other1+" and v.VisitType="+value+"");
				}
				else if(other1==0&&other2!=0){
					prst=conn.prepareStatement("select t.TypeName, v.VisitId,v.VisitTime,v.VisitContent,h.HospitalName,u.Name " +
		                    "from T_Visit as v,T_Hospital as h,T_User as u,T_VisitType as t " +
		                      "where v.HospitalId=h.HospitalId and v.UserId=u.UserId and t.VisitTypeId=v.VisitType and v.HospitalId="+other2+" and v.VisitType="+value+"");
				}
			};

			rs=prst.executeQuery();
			JSONArray array=new JSONArray();
			while(rs.next()){
				if(intime.isInTime(rs.getString("VisitTime"),sdate, edate)){
				JSONObject ob=new JSONObject();
				ob.put("VisitId", rs.getInt("VisitId"));
				ob.put("Name", rs.getString("Name"));
				ob.put("Type", rs.getString("TypeName"));
				ob.put("HospitalName", rs.getString("HospitalName"));
				ob.put("VisitContent", rs.getString("VisitContent"));
				ob.put("VisitTime", rs.getString("VisitTime"));
				array.add(ob);
				}
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
	public JSONArray findvisi2(int pag,int other1,int other2,int value,String sdate,String edate){
		 try {
			
		 JSONArray s=new JSONArray();
		  
		  int sum=findvisi(other1,other2,value,sdate,edate).size();  //获得数据库总条数
		  int x;
		  if(sum>10*pag){
			  x=10*pag;
		  }
		  else{
			  x=sum;
		  }
		  for(int i=10*(pag-1);i<x;i++){
		    	
				s.add(findvisi(other1,other2,value,sdate,edate).get(i));   
		    	
		    }
		  return s;
	   
	 } catch (Exception e) {
			// TODO: handle exception
		}
		 return null;
	 }	
	
	
	public JSONArray findvisiB(int userid,int other2,int value,String sdate,String edate){
		conn=DBConn.getCon();
		InTime intime=new InTime();
		try {
			if(value==0){
				 if(other2==0){
					prst=conn.prepareStatement("select t.TypeName, v.VisitId,v.VisitTime,v.VisitContent,h.HospitalName,u.Name " +
		                    "from T_Visit as v,T_Hospital as h,T_User as u,T_VisitType as t " +
		                      "where v.HospitalId=h.HospitalId and v.UserId=u.UserId and t.VisitTypeId=v.VisitType and v.UserId="+userid+"");
				}
				else if(other2!=0){
					prst=conn.prepareStatement("select t.TypeName, v.VisitId,v.VisitTime,v.VisitContent,h.HospitalName,u.Name " +
		                    "from T_Visit as v,T_Hospital as h,T_User as u,T_VisitType as t " +
		                      "where v.HospitalId=h.HospitalId and v.UserId=u.UserId and t.VisitTypeId=v.VisitType and v.HospitalId="+other2+" and v.UserId="+userid+"");
				}
				
			}
			else {
				 if(other2==0){
					 prst=conn.prepareStatement("select t.TypeName, v.VisitId,v.VisitTime,v.VisitContent,h.HospitalName,u.Name " +
		                    "from T_Visit as v,T_Hospital as h,T_User as u,T_VisitType as t " +
		                      "where v.HospitalId=h.HospitalId and v.UserId=u.UserId and t.VisitTypeId=v.VisitType and v.VisitType="+value+" and v.UserId="+userid+"");
				}
				else if(other2!=0){
					prst=conn.prepareStatement("select t.TypeName, v.VisitId,v.VisitTime,v.VisitContent,h.HospitalName,u.Name " +
		                    "from T_Visit as v,T_Hospital as h,T_User as u,T_VisitType as t " +
		                      "where v.HospitalId=h.HospitalId and v.UserId=u.UserId and t.VisitTypeId=v.VisitType and v.HospitalId="+other2+" and v.UserId="+userid+" and v.VisitType="+value+"");
				}
				
			};

			rs=prst.executeQuery();
			JSONArray array=new JSONArray();
			while(rs.next()){
				if(intime.isInTime(rs.getString("VisitTime"),sdate, edate)){
				JSONObject ob=new JSONObject();
				ob.put("VisitId", rs.getInt("VisitId"));
				ob.put("Name", rs.getString("Name"));
				ob.put("Type", rs.getString("TypeName"));
				ob.put("HospitalName", rs.getString("HospitalName"));
				ob.put("VisitContent", rs.getString("VisitContent"));
				ob.put("VisitTime", rs.getString("VisitTime"));
				array.add(ob);
				}
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
	public JSONArray findvisiB2(int pag,int userid,int other2,int value,String sdate,String edate){
		 try {
			
		 JSONArray s=new JSONArray();
		  
		  int sum=findvisi(userid,other2,value,sdate,edate).size();  //获得数据库总条数
		  int x;
		  if(sum>10*pag){
			  x=10*pag;
		  }
		  else{
			  x=sum;
		  }
		  for(int i=10*(pag-1);i<x;i++){
		    	
				s.add(findvisi(userid,other2,value,sdate,edate).get(i));   
		    	
		    }
		  return s;
	   
	 } catch (Exception e) {
			// TODO: handle exception
		}
		 return null;
	 }	
	
	public int deleteVisById(int id) {
		conn=DBConn.getCon();
		try {		
			prst=conn.prepareStatement("delete from T_Visit where VisitId="+id);
			 prst.executeUpdate();
			 return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}finally{
			DBConn.closeDB(conn, prst, rs);
		}	
	}
	
	
public JSONArray getTypeByUserId(int id) {
		
		
		conn=DBConn.getCon();
		JSONArray arr=new JSONArray();
	    JSONObject o1 =new JSONObject();
	    o1.put("text","全部");
	    o1.put("id",0);
	    o1.put("selected", true);
	    arr.add(o1);
	   
		try {		
			if(id==0){
			  prst=conn.prepareStatement("select VisitTypeId,TypeName from T_VisitType");	
			}
			else{
			  
			}
			rs=prst.executeQuery();
			JSONObject o=null;
			while(rs.next()){
			      o =new JSONObject();		   
				  o.put("text",rs.getString("TypeName"));
				  o.put("id",rs.getInt("VisitTypeId"));		      
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
