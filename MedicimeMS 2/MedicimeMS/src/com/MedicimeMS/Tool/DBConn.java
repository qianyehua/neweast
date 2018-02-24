package com.MedicimeMS.Tool;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConn {

	public static Connection getCon(){
		Connection conn=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection("jdbc:sqlserver://115.29.175.26:1433;DatabaseName=MedicimeMS","ljb","19950103");
		} catch (Exception e) {
			System.out.println("------数据库连接失败------");
			e.printStackTrace();
		}
		//System.out.println("------数据库连接成功------");
		return conn;
	} 
	

	
	
	public static void closeDB(Connection conn,PreparedStatement prst,ResultSet rs){
		try {
			if(rs!=null)
				rs.close();
			if(prst!=null)
				prst.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		getCon();
	}
}
