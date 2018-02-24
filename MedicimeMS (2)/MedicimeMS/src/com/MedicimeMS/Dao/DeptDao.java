package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.MedicimeMS.Tool.DBConn;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class DeptDao {

	private Connection conn;
	private PreparedStatement prst;
	private ResultSet rs;
	
	
public JSONArray getDeptByUId() {
		
		
		conn=DBConn.getCon();
		JSONArray arr=new JSONArray();
	    
		try {	
			
				prst=conn.prepareStatement("select T_Dept.*,Name from T_Dept LEFT OUTER JOIN T_User on T_Dept.UserId=T_User.UserId where Parent!=0");
			
			rs=prst.executeQuery();
			JSONObject o=null;
			while(rs.next()){
			      o =new JSONObject();		   
				  o.put("dept",rs.getString("Type"));
				  o.put("id",rs.getInt("DeptId"));
				  
				  if(rs.getString("Name")==null){
					  o.put("name","");  
				  }
				  else{
					  o.put("name",rs.getString("Name"));
				  }
				  o.put("code",rs.getString("Code"));
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

public int deleteDeptById(int id) {
	conn=DBConn.getCon();
	try {		
		prst=conn.prepareStatement("delete from T_Dept where DeptId="+id);
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

public int addDeptBy(int uid,String dept, String code) {
	conn=DBConn.getCon();
	   
	try {	
	    prst=conn.prepareStatement("insert into T_Dept(Code,Type,UserId) values(?,?,?)");
	    prst.setString(1,code);
	    prst.setString(2,dept);
	    prst.setInt(3,uid);
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

public int updateDeptBy(int deptid,String dept, String code,int uid) {
	conn=DBConn.getCon();
	   
	try {	
	    prst=conn.prepareStatement("update T_Dept set Code=?,Type=?,UserId=? where DeptId=?");
	    prst.setString(1,code);
	    prst.setString(2,dept);
	    prst.setInt(3,uid);
	    prst.setInt(4,deptid);
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

public JSONArray getDeptByUId2(int pag){
	 try {
		
	 JSONArray s=new JSONArray();
	  
	  int sum=getDeptByUId().size();  //获得数据库总条数
	  int x;
	  if(sum>10*pag){
		  x=10*pag;
	  }
	  else{
		  x=sum;
	  }
	  for(int i=10*(pag-1);i<x;i++){
	    	
			s.add(getDeptByUId().get(i));   
	    	
	    }
	  return s;
  
} catch (Exception e) {
		// TODO: handle exception
	}
	 return null;
}	

}
