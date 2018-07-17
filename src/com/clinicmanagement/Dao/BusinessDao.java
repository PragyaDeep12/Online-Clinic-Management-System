package com.clinicmanagement.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.clinicmanagement.Model.Business;

public class BusinessDao {
public boolean insert(Business obj)
{
	boolean reply=false;
	Connection con=DBConnect.getMySQLConnection();
	try {
		PreparedStatement psmt=con.prepareStatement("insert into Business values (?,?,?,?,?,?);");
		psmt.setInt(1, obj.getAppointmentId());
		psmt.setString(2, obj.getDoctorId());
		psmt.setString(3, obj.getPatientId());
		psmt.setString(4, obj.getDoctorFees());
		psmt.setString(5, obj.getAdminProfit());
		psmt.setString(6, obj.getDate());
		psmt.executeUpdate();
		reply=true;
		DBConnect.closeMySQLPreaparedStatementConnection(psmt);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	DBConnect.closeMySQLConnection(con);
	return reply;
}
public boolean cancelAppointment(String appointmentId){
	boolean reply=false;
	Connection con=DBConnect.getMySQLConnection();
	try {
		PreparedStatement psmt=con.prepareStatement("update Business set doctor_fees=0 where appointment_id=?;");
		psmt.setString(1, appointmentId);
		psmt.executeUpdate();
		reply=true;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return reply;
}

public ArrayList<Business> fetchAdminAccount(String firstDate,String lastDate){
	Date fdate=null;
	Date ldate=null;
	ArrayList<Business> list=new ArrayList<>();
	try {
		 fdate = new SimpleDateFormat("yyyy-MM-dd").parse(firstDate);
		 ldate=new SimpleDateFormat("yyyy-MM-dd").parse(lastDate);
		 

	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Connection con= DBConnect.getMySQLConnection();
	try {
		PreparedStatement psmt=con.prepareStatement("select * from Business;");
		ResultSet rs= psmt.executeQuery();
		while(rs.next())
		{System.out.println("hello");
			String date=rs.getString("date");
			Date fetchDate=null;
			try {
				fetchDate=new SimpleDateFormat("yyyy-MM-dd").parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("fetch"+fetchDate+"fdate"+fdate+"ldate"+ldate);
			if((fetchDate.before(ldate))&&(fetchDate.after(fdate))){
				System.out.println("jhdsj");
				Business business= new Business();
				business.setAdminProfit(rs.getString("admin_profit"));
				business.setAppointmentId(rs.getInt("appointment_id"));
				business.setDate(rs.getString("date"));
				list.add(business);
				
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	
}
}
