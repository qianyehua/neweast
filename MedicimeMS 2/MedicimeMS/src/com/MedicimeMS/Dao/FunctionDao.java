package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.MedicimeMS.Tool.DBConn;


public class FunctionDao {
	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;
	public  JSONArray funlist(){
		
		conn=DBConn.getCon();
		JSONArray parent=new JSONArray();
		try {
			st=conn.prepareStatement("select * from T_Function where ParentId in(10,20,30,40,50,60)");
			rs=st.executeQuery();
			while(rs.next()){
				
				JSONObject ob=new JSONObject();
				ob.put("id",rs.getInt("FunctionId"));
				ob.put("text",rs.getString("Title"));
				ob.put("pid",rs.getInt("ParentId"));
				parent.add(ob);
			}
			System.out.println(parent);
			return parent;
			
		} catch (Exception e) {
			
		}
		return null;
	}
	
	public  JSONArray funlist2(){
		JSONArray children=new JSONArray();
		conn=DBConn.getCon();
		try {
			st=conn.prepareStatement("select * from T_Function where ParentId in (1,2,3,4,5,6)");
			rs=st.executeQuery();
			
			while(rs.next()){
				JSONObject ob=new JSONObject();
				ob.put("id",rs.getInt("FunctionId"));
				ob.put("text",rs.getString("Title"));
				ob.put("pid",rs.getInt("ParentId"));
				children.add(ob);
			}
			return children;
		} catch (Exception e) {
			
		}
		return null;
	}

}
