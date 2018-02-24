package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.MedicimeMS.Tool.DBConn;


public class SysChaDao {

	private Connection conn;
	private PreparedStatement prst;
	private ResultSet rs;
	
	public  JSONArray getMenuByPid(int parentid,int roleid){
	
			conn=DBConn.getCon();
			JSONArray array=new JSONArray();
			try {
				prst=conn.prepareStatement("select * from T_Function where ParentId="+parentid+" and FunctionId in (select FunctionId from T_RoleFunction where RoleId="+roleid+")");
				rs=prst.executeQuery();
				while(rs.next()){
					
					JSONObject ob=new JSONObject();
					JSONObject ob1=new JSONObject();
					
					ob.put("id",rs.getInt("FunctionId"));
					ob.put("text",rs.getString("Title"));
					ob1.put("url",rs.getString("URL"));
					ob.put("attributes",ob1);
					array.add(ob);	
					
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				DBConn.closeDB(conn, prst, rs);
			}
				return array;	
	    }
}
