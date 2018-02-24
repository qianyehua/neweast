package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.MedicimeMS.Tool.DBConn;



public class LoginDao {

	private Connection conn;
	private PreparedStatement prst;
	private ResultSet rs;
	
	public int islegalBy(String uname,String upwd){
		conn=DBConn.getCon();
		try {
			
			prst=conn.prepareStatement("select UserId from T_User where UserName=? and UserPwd=?");
			prst.setString(1, uname);
			prst.setString(2, upwd);
			rs=prst.executeQuery();
			while(rs.next()){
				return rs.getInt("UserId");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		
		}finally{
			DBConn.closeDB(conn, prst, rs);
		}	
		return 0;
		
	}
	
	public String getRole(String uname){
		conn=DBConn.getCon();
		try {
			prst=conn.prepareStatement("select Role from T_Role where RoleId=(select RoleId from T_UserRole where UserId=(select UserId from T_User where UserName=?))");
			prst.setString(1, uname);
			rs=prst.executeQuery();
			while(rs.next()){
//				System.out.println(rs.getInt("RoleId"));
				return rs.getString("Role");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeDB(conn,prst,rs);
		}
		return null;
	}
	
	public int getRoleid(String uname){
		conn=DBConn.getCon();
		try {
			prst=conn.prepareStatement("select RoleId from T_UserRole where UserId=(select UserId from T_User where UserName=?)");
			prst.setString(1, uname);
			rs=prst.executeQuery();
			while(rs.next()){
//				System.out.println(rs.getInt("RoleId"));
				return rs.getInt("RoleId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeDB(conn,prst,rs);
		}
		return 0;
	}
}
