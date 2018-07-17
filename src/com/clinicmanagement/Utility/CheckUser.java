package com.clinicmanagement.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.clinicmanagement.Dao.DBConnect;

public class CheckUser {

	public static String DoctorOrPatient(String uid){
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			conn=DBConnect.getMySQLConnection();
			psmt=conn.prepareStatement("select registration_no from doctor where email_id=?;");
			psmt.setString(1,uid);
			rs=psmt.executeQuery();
			if(rs.next()){
				return "doctor";	
			}else{
				return "patient";
			}
			
		} catch (SQLException e) {
			return "patient";
		}finally {
			DBConnect.closeMySQLConnection(conn);
			DBConnect.closeMySQLPreaparedStatementConnection(psmt);
		}
		
	}
}
