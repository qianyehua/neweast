package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.MedicimeMS.Tool.DBConn;
import com.MedicimeMS.Tool.InTime;

public class PlaFinDao {

	private Connection conn;
	private PreparedStatement prst;
	private ResultSet rs;
	
	public JSONArray findplan(int other1,int other2,String value,String sdate,String edate){
		conn=DBConn.getCon();
		InTime intime=new InTime();
		try {
			if(value==null){
				 if(other1==0&&other2==0){
					 prst=conn.prepareStatement("select p.MonthWeek,p.PlanCmpTime,p.SubmitTime,p.PlanContent,p.Retrospection,p.SalesPlanId,u.Name,h.HospitalName " +
		                      "from T_SalesPlan as p,T_User as u,T_Hospital as h " +
		                      "where p.UserId=u.UserId and p.HospitalId=h.HospitalId");
				}
				else if(other1!=0&&other2!=0){
					prst=conn.prepareStatement("select p.MonthWeek,p.PlanCmpTime,p.SubmitTime,p.PlanContent,p.Retrospection,p.SalesPlanId,u.Name,h.HospitalName " +
		                      "from T_SalesPlan as p,T_User as u,T_Hospital as h " +
		                      "where p.UserId=u.UserId and p.HospitalId=h.HospitalId and p.HospitalId="+other2+" and p.UserId="+other1+"");
				}
				else if(other1!=0&&other2==0){
					prst=conn.prepareStatement("select p.MonthWeek,p.PlanCmpTime,p.SubmitTime,p.PlanContent,p.Retrospection,p.SalesPlanId,u.Name,h.HospitalName " +
		                      "from T_SalesPlan as p,T_User as u,T_Hospital as h " +
		                      "where p.UserId=u.UserId and p.HospitalId=h.HospitalId and p.UserId="+other1+"");
				}
				else if(other1==0&&other2!=0){
					prst=conn.prepareStatement("select p.MonthWeek,p.PlanCmpTime,p.SubmitTime,p.PlanContent,p.Retrospection,p.SalesPlanId,u.Name,h.HospitalName " +
		                      "from T_SalesPlan as p,T_User as u,T_Hospital as h " +
		                      "where p.UserId=u.UserId and p.HospitalId=h.HospitalId and p.HospitalId="+other2+"");
				}
			}
			else {
				 if(other1==0&&other2==0){
					 prst=conn.prepareStatement("select p.MonthWeek,p.PlanCmpTime,p.SubmitTime,p.PlanContent,p.Retrospection,p.SalesPlanId,u.Name,h.HospitalName " +
		                      "from T_SalesPlan as p,T_User as u,T_Hospital as h " +
		                      "where p.UserId=u.UserId and p.HospitalId=h.HospitalId and p.PlanContent like '%"+value+"%'");
				}
				else if(other1!=0&&other2!=0){
					prst=conn.prepareStatement("select p.MonthWeek,p.PlanCmpTime,p.SubmitTime,p.PlanContent,p.Retrospection,p.SalesPlanId,u.Name,h.HospitalName " +
		                      "from T_SalesPlan as p,T_User as u,T_Hospital as h " +
		                      "where p.UserId=u.UserId and p.HospitalId=h.HospitalId and p.PlanContent like '%"+value+"%' and p.HospitalId="+other2+" and p.UserId="+other1+"");
				}
				else if(other1!=0&&other2==0){
					prst=conn.prepareStatement("select p.MonthWeek,p.PlanCmpTime,p.SubmitTime,p.PlanContent,p.Retrospection,p.SalesPlanId,u.Name,h.HospitalName " +
		                      "from T_SalesPlan as p,T_User as u,T_Hospital as h " +
		                      "where p.UserId=u.UserId and p.HospitalId=h.HospitalId and p.PlanContent like '%"+value+"%' and p.UserId="+other1+"");
				}
				else if(other1==0&&other2!=0){
					prst=conn.prepareStatement("select p.MonthWeek,p.PlanCmpTime,p.SubmitTime,p.PlanContent,p.Retrospection,p.SalesPlanId,u.Name,h.HospitalName " +
		                      "from T_SalesPlan as p,T_User as u,T_Hospital as h " +
		                      "where p.UserId=u.UserId and p.HospitalId=h.HospitalId and p.PlanContent like '%"+value+"%' and p.HospitalId="+other2+"");
				}
			}
			rs=prst.executeQuery();
			JSONArray array=new JSONArray();
			while(rs.next()){
//				System.out.println(rs.getString("PlanCmpTime"));
//				System.out.println("++++++++++++++++++++");
				if(intime.isInTime(rs.getString("PlanCmpTime"),sdate, edate)){
					
				JSONObject ob=new JSONObject();
				ob.put("SalsesPlanId", rs.getInt("SalesPlanId"));
				ob.put("Name", rs.getString("Name"));
				ob.put("HospitalName", rs.getString("HospitalName"));
				ob.put("MonthWeek", rs.getString("MonthWeek"));
				ob.put("PlanCmpTime", rs.getString("PlanCmpTime"));
				ob.put("SubmitTime", rs.getString("SubmitTime"));
				ob.put("Retrospection", rs.getString("Retrospection"));
				ob.put("PlanContent", rs.getString("PlanContent"));
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
	public JSONArray findplan2(int pag,int other1,int other2,String value,String sdate,String edate){
		 try {
			
		 JSONArray s=new JSONArray();
		  
		  int sum=findplan(other1,other2,value,sdate,edate).size();  //获得数据库总条数
		  int x;
		  if(sum>10*pag){
			  x=10*pag;
		  }
		  else{
			  x=sum;
		  }
		  for(int i=10*(pag-1);i<x;i++){
		    	
				s.add(findplan(other1,other2,value,sdate,edate).get(i));   
		    	
		    }
		  return s;
	   
	 } catch (Exception e) {
			// TODO: handle exception
		}
		 return null;
	 }	
//	===================================================
	public JSONArray findplanB(int userid,int other2,String value,String sdate,String edate){
		conn=DBConn.getCon();
		InTime intime=new InTime();
		try {
			if(value==null){
				 if(other2==0){
					 prst=conn.prepareStatement("select p.MonthWeek,p.PlanCmpTime,p.SubmitTime,p.PlanContent,p.Retrospection,p.SalesPlanId,u.Name,h.HospitalName " +
		                      "from T_SalesPlan as p,T_User as u,T_Hospital as h " +
		                      "where p.UserId=u.UserId and p.HospitalId=h.HospitalId and p.UserId="+userid+"");
				}
				else if(other2!=0){
					prst=conn.prepareStatement("select p.MonthWeek,p.PlanCmpTime,p.SubmitTime,p.PlanContent,p.Retrospection,p.SalesPlanId,u.Name,h.HospitalName " +
		                      "from T_SalesPlan as p,T_User as u,T_Hospital as h " +
		                      "where p.UserId=u.UserId and p.HospitalId=h.HospitalId and p.HospitalId="+other2+" and p.UserId="+userid+"");
				}
				
			}
			else {
				 if(other2==0){
					 prst=conn.prepareStatement("select p.MonthWeek,p.PlanCmpTime,p.SubmitTime,p.PlanContent,p.Retrospection,p.SalesPlanId,u.Name,h.HospitalName " +
		                      "from T_SalesPlan as p,T_User as u,T_Hospital as h " +
		                      "where p.UserId=u.UserId and p.HospitalId=h.HospitalId and p.PlanContent like '%"+value+"%' and p.UserId="+userid+"");
				}
				else if(other2!=0){
					prst=conn.prepareStatement("select p.MonthWeek,p.PlanCmpTime,p.SubmitTime,p.PlanContent,p.Retrospection,p.SalesPlanId,u.Name,h.HospitalName " +
		                      "from T_SalesPlan as p,T_User as u,T_Hospital as h " +
		                      "where p.UserId=u.UserId and p.HospitalId=h.HospitalId and p.PlanContent like '%"+value+"%' and p.HospitalId="+other2+" and p.UserId="+userid+"");
				}
				
			}
			rs=prst.executeQuery();
			JSONArray array=new JSONArray();
			while(rs.next()){
//				System.out.println(rs.getString("PlanCmpTime"));
//				System.out.println("++++++++++++++++++++");
				if(intime.isInTime(rs.getString("PlanCmpTime"),sdate, edate)){
					
				JSONObject ob=new JSONObject();
				ob.put("SalsesPlanId", rs.getInt("SalesPlanId"));
				ob.put("Name", rs.getString("Name"));
				ob.put("HospitalName", rs.getString("HospitalName"));
				ob.put("MonthWeek", rs.getString("MonthWeek"));
				ob.put("PlanCmpTime", rs.getString("PlanCmpTime"));
				ob.put("SubmitTime", rs.getString("SubmitTime"));
				ob.put("Retrospection", rs.getString("Retrospection"));
				ob.put("PlanContent", rs.getString("PlanContent"));
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
	public JSONArray findplanB2(int pag,int userid,int other2,String value,String sdate,String edate){
		 try {
			
		 JSONArray s=new JSONArray();
		  
		  int sum=findplan(userid,other2,value,sdate,edate).size();  //获得数据库总条数
		  int x;
		  if(sum>10*pag){
			  x=10*pag;
		  }
		  else{
			  x=sum;
		  }
		  for(int i=10*(pag-1);i<x;i++){
		    	
				s.add(findplan(userid,other2,value,sdate,edate).get(i));   
		    	
		    }
		  return s;
	   
	 } catch (Exception e) {
			// TODO: handle exception
		}
		 return null;
	 }
	
	public int deletePlaById(int id) {
		conn=DBConn.getCon();
		try {		
			prst=conn.prepareStatement("delete from T_SalesPlan where SalesPlanId="+id);
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
}
