package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONObject;

import com.MedicimeMS.Tool.DBConn;

public class getFunConDao {

		private Connection conn;
		private PreparedStatement prst;
		private ResultSet rs;
		
		public int funcon(int userid){
			conn=DBConn.getCon();
			try {
				
				prst=conn.prepareStatement("select count(*) as i from T_RoleFunction where RoleId=" +
						                        "(select RoleId from T_UserRole where UserId='"+userid+"')");
				rs=prst.executeQuery();
				while(rs.next()){
					
					return rs.getInt("i");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			
			}finally{
				DBConn.closeDB(conn, prst, rs);
			}	
			return 0;
			
		}
	}
