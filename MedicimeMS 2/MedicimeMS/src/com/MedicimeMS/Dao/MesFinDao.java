package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.MedicimeMS.Tool.DBConn;
import com.MedicimeMS.Tool.InTime;

public class MesFinDao {

	private Connection conn;
	private PreparedStatement prst;
	private ResultSet rs;
	
	public JSONArray findmess(int other1,int other2,int other3,String sdate,String edate){
		conn=DBConn.getCon();
		InTime intime=new InTime();
		try {
			if(other3==0){
				if(other1==0&&other2==0){
					 prst=conn.prepareStatement("select i.InfoHandle,i.HandleName,i.InfoId,i.InfoContent,i.SubmitTime,i.InfoWay,h.HospitalName,it.TypeName,u.Name " +
					    		"from T_Info as i,T_InfoType as it,T_Hospital as h,T_User as u " +
					    		"where i.InfoTypeId=it.InfoTypeId and i.HospitalId=h.HospitalId and i.UserId=u.UserId");
				}
				else if(other1!=0&&other2!=0){
					prst=conn.prepareStatement("select i.InfoHandle,i.HandleName,i.InfoId,i.InfoContent,i.SubmitTime,i.InfoWay,h.HospitalName,it.TypeName,u.Name " +
				    		"from T_Info as i,T_InfoType as it,T_Hospital as h,T_User as u " +
				    		"where i.InfoTypeId=it.InfoTypeId and i.HospitalId=h.HospitalId and i.UserId=u.UserId and i.UserId="+other1+" and i.HospitalId="+other2+"");
				}
				else if(other1!=0&&other2==0){
					prst=conn.prepareStatement("select i.InfoHandle,i.HandleName,i.InfoId,i.InfoContent,i.SubmitTime,i.InfoWay,h.HospitalName,it.TypeName,u.Name " +
				    		"from T_Info as i,T_InfoType as it,T_Hospital as h,T_User as u " +
				    		"where i.InfoTypeId=it.InfoTypeId and i.HospitalId=h.HospitalId and i.UserId=u.UserId and i.UserId="+other1+"");
				}
				else if(other1==0&&other2!=0){
					prst=conn.prepareStatement("select i.InfoHandle,i.HandleName,i.InfoId,i.InfoContent,i.SubmitTime,i.InfoWay,h.HospitalName,it.TypeName,u.Name " +
				    		"from T_Info as i,T_InfoType as it,T_Hospital as h,T_User as u " +
				    		"where i.InfoTypeId=it.InfoTypeId and i.HospitalId=h.HospitalId and i.UserId=u.UserId  and i.HospitalId="+other2+"");
				}
			}
			else{
				if(other1==0&&other2==0){
					prst=conn.prepareStatement("select i.InfoHandle,i.HandleName,i.InfoId,i.InfoContent,i.SubmitTime,i.InfoWay,h.HospitalName,it.TypeName,u.Name " +
				    		"from T_Info as i,T_InfoType as it,T_Hospital as h,T_User as u " +
				    		"where i.InfoTypeId=it.InfoTypeId and i.HospitalId=h.HospitalId and i.UserId=u.UserId and i.InfoTypeId="+other3+"");
				}
				else if(other1!=0&&other2!=0){
					prst=conn.prepareStatement("select i.InfoHandle,i.HandleName,i.InfoId,i.InfoContent,i.SubmitTime,i.InfoWay,h.HospitalName,it.TypeName,u.Name " +
				    		"from T_Info as i,T_InfoType as it,T_Hospital as h,T_User as u " +
				    		"where i.InfoTypeId=it.InfoTypeId and i.HospitalId=h.HospitalId and i.UserId=u.UserId and i.UserId="+other1+" and i.HospitalId="+other2+" and i.InfoTypeId="+other3+"");
				}
				else if(other1!=0&&other2==0){
					prst=conn.prepareStatement("select i.InfoHandle,i.HandleName,i.InfoId,i.InfoContent,i.SubmitTime,i.InfoWay,h.HospitalName,it.TypeName,u.Name " +
				    		"from T_Info as i,T_InfoType as it,T_Hospital as h,T_User as u " +
				    		"where i.InfoTypeId=it.InfoTypeId and i.HospitalId=h.HospitalId and i.UserId=u.UserId and i.UserId="+other1+"  and i.InfoTypeId="+other3+"");
				}
				else if(other1==0&&other2!=0){
					prst=conn.prepareStatement("select i.InfoHandle,i.HandleName,i.InfoId,i.InfoContent,i.SubmitTime,i.InfoWay,h.HospitalName,it.TypeName,u.Name " +
				    		"from T_Info as i,T_InfoType as it,T_Hospital as h,T_User as u " +
				    		"where i.InfoTypeId=it.InfoTypeId and i.HospitalId=h.HospitalId and i.UserId=u.UserId  and i.HospitalId="+other2+" and i.InfoTypeId="+other3+"");
				}
			
			}
			
			rs=prst.executeQuery();
			JSONArray array=new JSONArray();
			while(rs.next()){
				if(intime.isInTime(rs.getString("SubmitTime"),sdate, edate)){
				JSONObject ob=new JSONObject();
				ob.put("infoId", rs.getInt("infoId"));
				ob.put("Name", rs.getString("Name"));
				ob.put("HospitalName", rs.getString("HospitalName"));
				ob.put("InfoContent", rs.getString("InfoContent"));
				ob.put("InfoWay", rs.getString("InfoWay"));
				ob.put("SubmitTime", rs.getString("SubmitTime"));
				ob.put("TypeName", rs.getString("TypeName"));
				ob.put("InfoHandle", rs.getString("InfoHandle"));
				ob.put("HandleName", rs.getString("HandleName"));
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
	public JSONArray findmess2(int pag,int other1,int other2,int other3,String sdate,String edate){
		 try {
			
		 JSONArray s=new JSONArray();
		  
		  int sum=findmess(other1,other2,other3,sdate,edate).size();  //获得数据库总条数
		  int x;
		  if(sum>10*pag){
			  x=10*pag;
		  }
		  else{
			  x=sum;
		  }
		  for(int i=10*(pag-1);i<x;i++){
		    	
				s.add(findmess(other1,other2,other3,sdate,edate).get(i));   
		    	
		    }
		  return s;
	   
	 } catch (Exception e) {
			// TODO: handle exception
		}
		 return null;
	 }	
//	++++++++++++++++++++++++++++++++++
	public JSONArray findmessB(int userid,int other2,int other3,String sdate,String edate){
		conn=DBConn.getCon();
		InTime intime=new InTime();
		try {
			if(other3==0){
				if(other2==0){
					 prst=conn.prepareStatement("select i.InfoHandle,i.HandleName,i.InfoId,i.InfoContent,i.SubmitTime,i.InfoWay,h.HospitalName,it.TypeName,u.Name " +
					    		"from T_Info as i,T_InfoType as it,T_Hospital as h,T_User as u " +
					    		"where i.InfoTypeId=it.InfoTypeId and i.HospitalId=h.HospitalId and i.UserId=u.UserId and i.UserId="+userid+"");
				}
				else if(other2!=0){
					prst=conn.prepareStatement("select i.InfoHandle,i.HandleName,i.InfoId,i.InfoContent,i.SubmitTime,i.InfoWay,h.HospitalName,it.TypeName,u.Name " +
				    		"from T_Info as i,T_InfoType as it,T_Hospital as h,T_User as u " +
				    		"where i.InfoTypeId=it.InfoTypeId and i.HospitalId=h.HospitalId and i.UserId=u.UserId and i.UserId="+userid+" and i.HospitalId="+other2+"");
				}
				
			}
			else{
				if(other2==0){
					prst=conn.prepareStatement("select i.InfoHandle,i.HandleName,i.InfoId,i.InfoContent,i.SubmitTime,i.InfoWay,h.HospitalName,it.TypeName,u.Name " +
				    		"from T_Info as i,T_InfoType as it,T_Hospital as h,T_User as u " +
				    		"where i.InfoTypeId=it.InfoTypeId and i.HospitalId=h.HospitalId and i.UserId=u.UserId and i.InfoTypeId="+other3+" and i.UserId="+userid+"");
				}
				else if(other2!=0){
					prst=conn.prepareStatement("select i.InfoHandle,i.HandleName,i.InfoId,i.InfoContent,i.SubmitTime,i.InfoWay,h.HospitalName,it.TypeName,u.Name " +
				    		"from T_Info as i,T_InfoType as it,T_Hospital as h,T_User as u " +
				    		"where i.InfoTypeId=it.InfoTypeId and i.HospitalId=h.HospitalId and i.UserId=u.UserId and i.UserId="+userid+" and i.HospitalId="+other2+" and i.InfoTypeId="+other3+"");
				}
				
			}
			
			rs=prst.executeQuery();
			JSONArray array=new JSONArray();
			while(rs.next()){
				if(intime.isInTime(rs.getString("SubmitTime"),sdate, edate)){
				JSONObject ob=new JSONObject();
				ob.put("infoId", rs.getInt("InfoId"));
				ob.put("Name", rs.getString("Name"));
				ob.put("HospitalName", rs.getString("HospitalName"));
				ob.put("InfoContent", rs.getString("InfoContent"));
				ob.put("InfoWay", rs.getString("InfoWay"));
				ob.put("SubmitTime", rs.getString("SubmitTime"));
				ob.put("TypeName", rs.getString("TypeName"));
				ob.put("InfoHandle", rs.getString("InfoHandle"));
				ob.put("HandleName", rs.getString("HandleName"));
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
	public JSONArray findmessB2(int pag,int userid,int other2,int other3,String sdate,String edate){
		 try {
			
		 JSONArray s=new JSONArray();
		  
		  int sum=findmess(userid,other2,other3,sdate,edate).size();  //获得数据库总条数
		  int x;
		  if(sum>10*pag){
			  x=10*pag;
		  }
		  else{
			  x=sum;
		  }
		  for(int i=10*(pag-1);i<x;i++){
		    	
				s.add(findmess(userid,other2,other3,sdate,edate).get(i));   
		    	
		    }
		  return s;
	   
	 } catch (Exception e) {
			// TODO: handle exception
		}
		 return null;
	 }	
	
	public int deleteMesById(int id) {
		conn=DBConn.getCon();
		try {		
			prst=conn.prepareStatement("delete from T_Info where infoId="+id);
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
	public int infoHandle(JSONObject message){
		try {
			conn=DBConn.getCon();
			prst=conn.prepareStatement("update T_Info set InfoHandle=?,HandleName=(select Name from T_User where UserId=?) where InfoId=?");
			prst.setString(1,message.getString("InfoCon"));
			prst.setInt(2,Integer.parseInt(message.getString("id")));
			prst.setInt(3,Integer.parseInt(message.getString("infoid")));
			prst.executeUpdate();
			
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			DBConn.closeDB(conn, prst, rs);
		}
		return 0;
}
}
