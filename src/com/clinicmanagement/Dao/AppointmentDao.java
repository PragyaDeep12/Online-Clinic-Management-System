package com.clinicmanagement.Dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import com.clinicmanagement.Model.Appointment;
import com.clinicmanagement.Model.Business;
import com.clinicmanagement.Model.Doctor;
import com.clinicmanagement.Model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AppointmentDao {
 public boolean addAppointment(Appointment appointment){
	 Connection conn=null;
	 PreparedStatement statement =null;
	 boolean result=false;
	 try{
		 conn=DBConnect.getMySQLConnection();
		 statement=conn.prepareStatement("insert into appointment ( doctorserial, doctorname, idpatient, patientname, date, slot) values (?,?,?,?,?,?);");
		 statement.setString(1, appointment.getDoctorSerial());
		 statement.setString(2, appointment.getDoctorName());
		 statement.setString(3, appointment.getIdPatient());
		 statement.setString(4, appointment.getPatientName());
		 statement.setString(5, appointment.getDate());
		 statement.setString(6,appointment.getSlot());
		 if(statement.executeUpdate()>0){
			  if(fillBusinessObj(appointment))
				  result=true;
			 }
			
		 }
	 catch(SQLException e){
		 e.getMessage().toString();
	 }finally{
		 DBConnect.closeMySQLConnection(conn);
		 DBConnect.closeMySQLPreaparedStatementConnection(statement);
		 
	 }
	return result;
	 
 }
 
 
 
public boolean fillBusinessObj(Appointment appointment) {
	boolean reply=false;
	Business business= new Business();
	 Connection conn=DBConnect.getMySQLConnection();
	 PreparedStatement statement;
	try {
		statement = conn.prepareStatement("select idappointment from appointment where doctorserial=? and idpatient=? and date=?;");
		 statement.setString(1, appointment.getDoctorSerial());
		 statement.setString(2, appointment.getIdPatient());
		 statement.setString(3, appointment.getDate());
		System.out.println(appointment.getDoctorSerial()+"/"+appointment.getIdPatient()+"/"+appointment.getDate());
		 ResultSet rs=statement.executeQuery();
		 System.out.println("helloe world");
		 if(rs.next())
		 {System.out.println("helloe");
		 System.out.println("fees"+appointment.getFees());
			 business.setAppointmentId(rs.getInt(1));
			 business.setDoctorId(appointment.getDoctorSerial());
			 business.setPatientId(appointment.getIdPatient());
			 business.setDate(appointment.getDate());
			 business.setDoctorFees(String.valueOf((Integer.parseInt(appointment.getFees())*0.70)));
			 business.setAdminProfit(String.valueOf((Integer.parseInt(appointment.getFees())*0.30)));
			 BusinessDao dao= new BusinessDao();
			 if(dao.insert(business))
				 reply=true;
			
		 }
	DBConnect.closeMySQLPreaparedStatementConnection(statement);
	DBConnect.closeMySQLResulsetConnection(rs);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	DBConnect.closeMySQLConnection(conn);
	return reply;
	
}
 public ArrayList<Appointment> getAppointmentPatient(Patient patient){
	 ArrayList<Appointment> appointments=new ArrayList<>();
	 Connection conn=null;
	 PreparedStatement statement =null;
	 ResultSet resultSet=null;
	 try{
		 conn=DBConnect.getMySQLConnection();
		 statement=conn.prepareStatement("select * from appointment where idpatient=?");
		 statement.setString(1, patient.getEmailId());
		 System.out.println(patient.getContact());
		resultSet= statement.executeQuery();
		while(resultSet.next()){
			
			Appointment appointment =new Appointment();
			appointment.setDate(resultSet.getString("date"));
			appointment.setDoctorName(resultSet.getString("doctorname"));
			appointment.setDoctorSerial(resultSet.getString("doctorserial"));
			appointment.setIdAppointment(resultSet.getString("idappointment"));
			appointment.setIdPatient(resultSet.getString("idpatient"));
			appointment.setPatientName(resultSet.getString("patientname"));
			appointment.setSlot(resultSet.getString("slot"));
			appointments.add(appointment);
		}
		 System.out.println(appointments.size());
	 }catch(SQLException e){
		 e.getMessage().toString();
	 }finally{
		 DBConnect.closeMySQLConnection(conn);
		 DBConnect.closeMySQLPreaparedStatementConnection(statement);
		 DBConnect.closeMySQLResulsetConnection(resultSet);
	 }
	 return appointments;
 }

 public ArrayList<Appointment> getAppointmentDoctor(Doctor doctor){
	 ArrayList<Appointment> appointments=new ArrayList<>();
	 Connection conn=null;
	 PreparedStatement statement =null;
	 ResultSet resultSet=null;
	 try{
		 conn=DBConnect.getMySQLConnection();
		 statement=conn.prepareStatement("select * from appointment where doctorserial=?");
		 statement.setString(1, doctor.getSerialNo());
		resultSet= statement.executeQuery();
		while(resultSet.next()){
			Appointment appointment =new Appointment();
			appointment.setDate(resultSet.getString("date"));
			appointment.setDoctorName(resultSet.getString("doctorname"));
			appointment.setDoctorSerial(resultSet.getString("doctorserial"));
			appointment.setIdAppointment(resultSet.getString("idappointment"));
			appointment.setIdPatient(resultSet.getString("idpatient"));
			appointment.setPatientName(resultSet.getString("patientname"));
			appointment.setSlot(resultSet.getString("slot"));
			appointments.add(appointment);
		}
		 
	 }catch(SQLException e){
		 e.getMessage().toString();
	 }finally{
		 DBConnect.closeMySQLConnection(conn);
		 DBConnect.closeMySQLPreaparedStatementConnection(statement);
		 DBConnect.closeMySQLResulsetConnection(resultSet);
	 }
	 return appointments;
 }
public boolean cancelAppointment(String appointmentId)
{
	boolean reply=false;
	Connection con=DBConnect.getMySQLConnection();
	try {
		PreparedStatement psmt=con.prepareStatement("delete from Appointment where idappointment=?;");
		psmt.setString(1, appointmentId);
		psmt.executeUpdate();
		BusinessDao dao= new BusinessDao();
		if(dao.cancelAppointment(appointmentId)){
			reply=true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return reply;
}
 public ArrayList<Appointment> getAppList(String registrationNo) {
	 ArrayList<Appointment> appList=new ArrayList<>();
	 Connection con=DBConnect.getMySQLConnection();
	
	 try {PreparedStatement psmt=con.prepareStatement("select serial_no from Doctor where registration_no=?;");
	 psmt.setString(1, registrationNo);
	 ResultSet rs=psmt.executeQuery();
	 String serial=null;
	 if(rs.next())
	 {
		 serial=rs.getString("serial_no");
	 }
		 
		 psmt= con.prepareStatement("select * from Appointment where doctorserial=?");
		 psmt.setString(1, serial);
		 rs=psmt.executeQuery();
		 while(rs.next())
		 {
			 Appointment app= new Appointment();
			 app.setDoctorSerial(rs.getString("doctorserial"));
			 app.setDate(rs.getString("date"));
			 app.setIdAppointment(rs.getString("idappointment"));
			 app.setIdPatient(rs.getString("idpatient"));
			 app.setPatientName(rs.getString("patientname"));
			 app.setDoctorName(rs.getString("doctorname"));
			 app.setSlot(rs.getString("slot"));
			 appList.add(app);
		 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return appList;
	
}
 
 
 
 public boolean checkValidAppointment(Doctor doctor,String date,String pat_email){
	 int flag=0;
	 Connection connection=DBConnect.getMySQLConnection();
	 PreparedStatement psmt=null;
	 ResultSet resultSet=null;
	 try {
		psmt=connection.prepareStatement("select date,doctorserial from appointment where idpatient=?;");
		psmt.setString(1, pat_email);
		System.out.println("pat email="+pat_email );
		resultSet=psmt.executeQuery();
		while(resultSet.next()){
			String past_doc_serial=resultSet.getString("doctorserial");
			String past_date=resultSet.getString("date");
			 Date pdate = null;
			 Date ndate = null;
			try {
				System.out.println(past_date+","+date);
				pdate = new SimpleDateFormat("yyyy-MM-dd").parse(past_date);
				ndate=new SimpleDateFormat("yyyy-MM-dd").parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("Unable to covert dates");
				e.printStackTrace();
			}
			
			DoctorDao dao=new DoctorDao();
			Doctor doct=dao.gettheDoctor(past_doc_serial);
			Doctor doct1=dao.gettheDoctor(doctor.getSerialNo());
			String doc_type=doct.getSpecialty();
			String doc_type_new=doct1.getSpecialty();
			System.out.println(doc_type);
			System.out.println(doc_type_new);
			  
			if(doc_type.equals(doc_type_new) && ((ndate.before(pdate)) ||(ndate.equals(pdate))) ){
				flag=1;
			}
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 if(flag==1){
			return false;
			
		}else{
			return true;
		}
 }

}
