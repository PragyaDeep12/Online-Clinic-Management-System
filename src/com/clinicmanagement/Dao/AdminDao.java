package com.clinicmanagement.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDao {
	public ArrayList<String> fetchDepartment() {
		ArrayList<String> department= new ArrayList<>();
		Connection con=DBConnect.getMySQLConnection();
		try {
			PreparedStatement psmt= con.prepareStatement("select * from Department;");
			ResultSet rs=psmt.executeQuery();
			while(rs.next())
			{
				department.add(rs.getString("deptname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return department;
		}
public boolean addDepartment(String deptname){
	boolean reply=false;
	Connection con=DBConnect.getMySQLConnection();
	try {
		PreparedStatement psmt= con.prepareStatement("insert into Department (deptname) values (?);");
		psmt.setString(1, deptname);
		psmt.executeUpdate();
		reply=true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return reply;
	
}
}
