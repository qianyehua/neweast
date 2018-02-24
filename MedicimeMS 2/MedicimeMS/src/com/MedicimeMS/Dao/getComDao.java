package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.MedicimeMS.Tool.DBConn;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class getComDao {

	private Connection conn;
	private PreparedStatement prst;
	private ResultSet rs;
	
	public JSONArray getParentCategory(){   //下拉框
		conn=DBConn.getCon();
		JSONArray array=new JSONArray();
		try {
			prst=conn.prepareStatement("select * from T_Area");
			rs=prst.executeQuery();
			while(rs.next()){			
				JSONObject ob=new JSONObject();
				ob.put("id", rs.getInt("AreaId"));
				ob.put("text", rs.getString("Caption"));
				ob.put("selected", true);
				array.add(ob);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBConn.closeDB(conn, prst, rs);
		}
			return array;
	}
	
	public JSONArray getProName(){   //下拉框
		conn=DBConn.getCon();
		JSONArray array=new JSONArray();
		try {
			prst=conn.prepareStatement("select * from T_Property");
			rs=prst.executeQuery();
			while(rs.next()){			
				JSONObject ob=new JSONObject();
				ob.put("id", rs.getInt("PropertyId"));
				ob.put("text", rs.getString("PropertyName"));
				ob.put("selected", true);
				array.add(ob);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBConn.closeDB(conn, prst, rs);
		}
			return array;
	}
}	
	