package com.clinicmanagement.Dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.clinicmanagement.Model.Patient;
import com.clinicmanagement.Utility.EmailConfirmation;
import com.clinicmanagement.Dao.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseHandler {
	
	public static boolean Addrecord(Patient patient){
		Connection conn =null;
		PreparedStatement psmt=null;
		boolean result=false;
		try {
			conn=DBConnect.getMySQLConnection();
			psmt=conn.prepareStatement("insert into patient (emailid,password,fullname,age,gender,contact) values (?,?,?,?,?,?);");
			psmt.setString(1, patient.getEmailId());
			psmt.setString(2, patient.getPassword());
			psmt.setString(3, patient.getFullName());
			psmt.setString(4, patient.getAge());
			psmt.setString(5, patient.getGender());
			psmt.setString(6, patient.getContact());
			int i= psmt.executeUpdate();
			if(i>0){
				result=true;
			}else{
				result=false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage().toString());
			// TODO Auto-generated catch block
			
		} finally 
	     {
	    	 DBConnect.closeMySQLPreaparedStatementConnection(psmt);
	    	 DBConnect.closeMySQLConnection(conn);
		 }
		return result;
	}
	public static Patient logincheck(Patient patient){
		Connection conn=null;
		PreparedStatement psmt=null;
		System.out.println(patient.getEmailId());
		System.out.println(patient.getPassword());
		try {
			conn=DBConnect.getMySQLConnection();
			Patient p=new Patient();
			psmt=conn.prepareStatement("select * from patient where emailid=?");
			psmt.setString(1, patient.getEmailId());
			ResultSet rs=psmt.executeQuery();
			while(rs.next()){
				p.setFullName(rs.getString("fullname"));
				p.setEmailId(rs.getString("emailId"));
				p.setPassword(rs.getString("password"));
				p.setGender(rs.getString("gender"));
				p.setAge(rs.getString("age"));
				p.setContact(rs.getString("contact"));	
			}
			if((patient.getPassword()).equals(p.getPassword()))
			{
				return p;
			}else{
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 finally 
	     {
	    	 DBConnect.closeMySQLPreaparedStatementConnection(psmt);
	    	 DBConnect.closeMySQLConnection(conn);
		 }
		
	}
	public static Patient getPatientbyId(String emailid){
		Connection conn=null;
		PreparedStatement psmt=null;
		try {
			conn=DBConnect.getMySQLConnection();
			Patient p=new Patient();
			System.out.println("Email ID: "+emailid);
			psmt=conn.prepareStatement("select * from patient where emailid=?;");
			psmt.setString(1, emailid);
			ResultSet rs=psmt.executeQuery();
			if(rs.next()){
			
				p.setFullName(rs.getString("fullname"));
				p.setEmailId(rs.getString("emailId"));
				p.setPassword(rs.getString("password"));
				p.setGender(rs.getString("gender"));
				p.setAge(rs.getString("age"));
				p.setContact(rs.getString("contact"));	
				System.out.println("fullname"+p.getFullName()+p.getAge()+p.getContact()+p.getGender());
			}
			System.out.println("Fullname="+p.getFullName());
			if(p.getFullName().length()>0)
			return p;
			else
			return null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 finally 
	     {
	    	 DBConnect.closeMySQLPreaparedStatementConnection(psmt);
	    	 DBConnect.closeMySQLConnection(conn);
		 }

	}

	
	public  Patient updatePatient(Patient patient){
		
		Connection conn =null;
		PreparedStatement psmt=null;
		Patient p=null;
		
		try {
			conn=DBConnect.getMySQLConnection();
			System.out.println(patient.getFullName()+"/"+patient.getAge()+"/"+patient.getContact()+"/"+patient.getEmailId());
			psmt=conn.prepareStatement("update patient set fullname=?,age=?,contact=? where emailid=?;");
			psmt.setString(1, patient.getFullName());
			psmt.setString(2, patient.getAge());
			psmt.setString(3, patient.getContact());
			psmt.setString(4, patient.getEmailId());
			
			if( psmt.executeUpdate()>0){
				p=patient;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage().toString());
			// TODO Auto-generated catch block
			
		} finally 
	     {
	    	 DBConnect.closeMySQLPreaparedStatementConnection(psmt);
	    	 DBConnect.closeMySQLConnection(conn);
		 }
		
		return p;
	}
}
