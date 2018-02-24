package com.MedicimeMS.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.MedicimeMS.Tool.DBConn;

public class SaveFunDao {

	private Connection conn=null;
	private PreparedStatement st=null;
	private ResultSet rs=null;

    
    public int baocun(int roleid,int funid){
    	try {
			conn=DBConn.getCon();
			st=conn.prepareStatement("insert into T_RoleFunction"+"(RoleId,FunctionId)"+"values(?,?)");
			st.setInt(1, roleid);
			st.setInt(2, funid);
			int i=st.executeUpdate();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		    	try {
					   rs.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
				   try {
					st.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
				   try {
					conn.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
		    
    	return 0;
    }
}
