package com.clinicmanagement.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.clinicmanagement.Model.Doctor;

public class DoctorDao {

	public boolean insert(Doctor doc)
	{
		boolean reply=false;
		Connection con=DBConnect.getMySQLConnection();
		try {
			System.out.println("first");
			PreparedStatement psmt= con.prepareStatement("insert into Doctor (registration_no,first_name,middle_name,last_name,address,contact,age,gender,fees,clinic_rent,email_id,speciality,slots,password,experience,allowed) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
			psmt.setString(1, doc.getRegistrationNo());
			psmt.setString(2, doc.getFirstName());
			psmt.setString(3, doc.getMiddleName());
			psmt.setString(4, doc.getLastName());
			psmt.setString(5, doc.getAddress());
			psmt.setString(6, doc.getContact());
			psmt.setString(7, doc.getAge());
			psmt.setString(8, doc.getGender());
			psmt.setString(9, doc.getFees());
			psmt.setString(10, doc.getRent());
			psmt.setString(11, doc.getEmailId());
			psmt.setString(12, doc.getSpecialty());
			psmt.setString(13, doc.getSlots());
			psmt.setString(14, doc.getPassword());
			psmt.setString(15, doc.getExperience());
			psmt.setString(16, "false");
			System.out.println("secondfirst");
			psmt.executeUpdate();
			System.out.println("secondfirst");
			psmt.close();
			for(String s:doc.getSlotString())
			{
				psmt=con.prepareStatement("Select occupied from DoctorSlots where slot=?;");
				psmt.setString(1, s);
				ResultSet rset=psmt.executeQuery();
				int i=0;
				while(rset.next())
				{
					i=rset.getInt(1);
				}
				psmt=con.prepareStatement("update DoctorSlots set occupied=? where slot=?;");
				psmt.setInt(1, i+1);
				psmt.setString(2, s);
				psmt.executeUpdate();
			}
			DBConnect.closeMySQLPreaparedStatementConnection(psmt);
			reply=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnect.closeMySQLConnection(con);
	
		return reply;
	}
	public ArrayList<String> fetchSlots()
	{
		ArrayList<String> slots=new ArrayList<>();
		Connection con=DBConnect.getMySQLConnection();
		try {
			PreparedStatement psmt=con.prepareStatement("Select * from DoctorSlots where occupied < 6;");
			ResultSet rs=psmt.executeQuery();
			while(rs.next())
			{//System.out.println("secondfirst");
				String slot=rs.getString("slot");
				//System.out.println("secondfirst"+slot);
				slots.add(slot);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String s:slots)
			System.out.println(s);
		return slots;
	}
	
	
	public ArrayList<Doctor> selectRecord(String registrationNo)
	{
		ArrayList<Doctor> list= new ArrayList<>();
		Connection con=DBConnect.getMySQLConnection();
		PreparedStatement psmt;
		try {
			psmt = con.prepareStatement("select * from Doctor where registration_no=?;");
			psmt.setString(1, registrationNo);
			ResultSet rs=psmt.executeQuery();
			while(rs.next())
			{
				Doctor doc=new Doctor();
				doc.setRegistrationNo(rs.getString(2));
				doc.setFirstName(rs.getString(3));
				doc.setMiddleName(rs.getString(4));
				doc.setLastName(rs.getString(5));
				doc.setContact(rs.getString(6));
				doc.setAddress(rs.getString(7));
				doc.setAge(rs.getString(8));
				doc.setGender(rs.getString(9));
				doc.setEmailId(rs.getString(10));
				doc.setSpecialty(rs.getString(11));
				doc.setCertificate(rs.getString(12));
				doc.setSlots(rs.getString(13));
				doc.setSlotString(doc.getSlots().split("/"));
				doc.setFees(rs.getString(14));
				doc.setRent(rs.getString(15));
				System.out.println("executed");
				list.add(doc);
				System.out.println("executed2");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnect.closeMySQLConnection(con);
		return list;
	}
	public boolean verify(Doctor doc)
	{
		boolean reply=false;
		Connection con= DBConnect.getMySQLConnection();
		{
			try {
				PreparedStatement psmt= con.prepareStatement("Select count(*) from Doctor where registration_no =? and password=?");
				psmt.setString(1, doc.getRegistrationNo());
				psmt.setString(2, doc.getPassword());
				ResultSet rs=psmt.executeQuery();
				while(rs.next())
				{
					if(rs.getInt(1)>0)
					{
						reply=true;
					}
						
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DBConnect.closeMySQLConnection(con);;
		return reply;
	}
	public ArrayList<Doctor> selectAll()
	{		ArrayList<Doctor> list= new ArrayList<>();
	Connection con=DBConnect.getMySQLConnection();
	PreparedStatement psmt;
	try {
		psmt = con.prepareStatement("select * from Doctor;");
	
		ResultSet rs=psmt.executeQuery();
		while(rs.next())
		{
			Doctor doc=new Doctor();
			doc.setRegistrationNo(rs.getString(2));
			doc.setFirstName(rs.getString(3));
			doc.setMiddleName(rs.getString(4));
			doc.setLastName(rs.getString(5));
			doc.setContact(rs.getString(6));
			doc.setAddress(rs.getString(7));
			doc.setAge(rs.getString(8));
			doc.setGender(rs.getString(9));
			doc.setEmailId(rs.getString(10));
			doc.setSpecialty(rs.getString(11));
			
			doc.setCertificate(rs.getString(12));
			doc.setSlots(rs.getString(13));
			doc.setSlotString(doc.getSlots().split("/"));
			doc.setFees(rs.getString(14));
			doc.setRent(rs.getString(15));
			doc.setExperience(rs.getString("experience"));
			System.out.println("executed");
			list.add(doc);
			System.out.println("executed2");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	DBConnect.closeMySQLConnection(con);
	return list;

		
	}
	
	
	
	public boolean deleteDoctor(String registrationNo)
	{
		boolean reply=false;
		Connection con=DBConnect.getMySQLConnection();
		try {
			PreparedStatement psmt= con.prepareStatement("select * from Doctor where registration_no=?;");
			psmt.setString(1, registrationNo);
			ResultSet rs=psmt.executeQuery();
			while(rs.next())
			{
				String slot=rs.getString("slots");
				System.out.println("slot string"+slot);
				String []slotArray=slot.split("/");
				for(String s:slotArray)
				{
					System.out.println("slots"+s);
					psmt=con.prepareStatement("select * from DoctorSlots where slot=?;");
					psmt.setString(1, s);
					ResultSet rset=psmt.executeQuery();
					while(rset.next())
					{
						int occupied=rset.getInt("occupied");
						psmt=con.prepareStatement("update DoctorSlots set occupied=? where slot=?;");
						psmt.setInt(1, occupied-1);
						psmt.setString(2, s);
						psmt.executeUpdate();
					}
				}
			}
			DBConnect.closeMySQLPreaparedStatementConnection(psmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnect.closeMySQLConnection(con);
		return reply;
	}
	
	public boolean updateDoctorDetails(Doctor doc) {
		boolean reply=false;
		Connection con=DBConnect.getMySQLConnection();
		try {
			PreparedStatement psmt= con.prepareStatement("update Doctor set first_name=? ,middle_name=?,last_name=?,address=?,contact=?,gender=?,email_id=?,speciality=?,fees=?,clinic_rent=?,certificate=?,experience=?,age=? where registration_no=?;");
			psmt.setString(1, doc.getFirstName());
			psmt.setString(2, doc.getMiddleName());
			psmt.setString(3, doc.getLastName());
			psmt.setString(4, doc.getAddress());
			psmt.setString(5, doc.getContact());
			psmt.setString(6, doc.getGender());
			psmt.setString(7, doc.getEmailId());
			psmt.setString(8, doc.getSpecialty());
			psmt.setString(9, doc.getFees());
			psmt.setString(10, doc.getRent());
			psmt.setString(11, doc.getCertificate());
			psmt.setString(12, doc.getExperience());
			psmt.setString(13, doc.getAge());
			psmt.setString(14, doc.getRegistrationNo());
			psmt.executeUpdate();
			reply=true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnect.closeMySQLConnection(con);
		return reply;
	}
	public boolean updateSlots(String[] listOfSlot,String registrationNo)
	{
		boolean reply=false;
		Connection con=DBConnect.getMySQLConnection();
		try {
			PreparedStatement psmt=con.prepareStatement("select * from Doctor where registration_no=?;");
			psmt.setString(1, registrationNo);
			ResultSet rs=psmt.executeQuery();
			System.out.println("executed syso1"+registrationNo);
			while(rs.next()){
				String []slots=rs.getString("slots").split("/");
				for(String s:slots)
				{System.out.println("executed syso2");
					psmt=con.prepareStatement("select * from DoctorSlots where slot=?;");
					psmt.setString(1, s);
					ResultSet  rset=psmt.executeQuery();
					while(rset.next()){
					int occupied=rset.getInt("occupied");
					psmt=con.prepareStatement("update DoctorSlots set occupied=? where slot=?;");
					psmt.setInt(1, occupied-1);
					psmt.setString(2, s);
					psmt.executeUpdate();
					System.out.println("executed syso3");
					}
				}
				String newSlot="";
				for(String s:listOfSlot)
				{
					newSlot=newSlot+s;
					System.out.println("executed syso4");
					psmt=con.prepareStatement("select * from DoctorSlots where slot=?;");
					psmt.setString(1, s);
					ResultSet  rset=psmt.executeQuery();
					while(rset.next()){
					int occupied=rset.getInt("occupied");
					psmt=con.prepareStatement("update DoctorSlots set occupied=? where slot=?;");
					psmt.setInt(1, occupied+1);
					psmt.setString(2, s);
					psmt.executeUpdate();
				}}
				psmt=con.prepareStatement("update Doctor set slots=? where registration_no=?;");
				psmt.setString(1, newSlot);
				psmt.setString(2, registrationNo);
				psmt.executeUpdate();
			}
			reply=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reply;
	
	
}
	
	public ArrayList<Doctor> getDoctors(String type){
		ArrayList<Doctor> doctors =new ArrayList<>();
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet rs = null;
		try{
		connection=DBConnect.getMySQLConnection();
		System.out.println("type : "+type);
		statement=connection.prepareStatement("select * from doctor where speciality=?");
		statement.setString(1, type);
		rs=statement.executeQuery();
		while(rs.next()){
			Doctor doctor=new Doctor();
			doctor.setSerialNo(rs.getString("serial_no"));
			doctor.setFirstName(rs.getString("first_name"));
			doctor.setMiddleName(rs.getString("middle_name"));
			doctor.setLastName(rs.getString("last_name"));
			doctor.setFees(rs.getString("fees"));
			doctor.setAge(rs.getString("age"));
			doctor.setGender(rs.getString("gender"));
			doctor.setExperience(rs.getString("experience"));
			
			doctor.setSlots(rs.getString("slots"));
			System.out.println("doctor: dr."+doctor.getFirstName());
			doctors.add(doctor);
		}
		}catch(Exception e){
			e.getMessage().toString();
		}finally{
			DBConnect.closeMySQLResulsetConnection(rs);
			DBConnect.closeMySQLConnection(connection);
			DBConnect.closeMySQLPreaparedStatementConnection(statement);
		}
		return doctors;
	}

	public ArrayList<String> gettypes(){
		ArrayList<String> strings=new ArrayList<String>();
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet rs = null;
		try{
		connection=DBConnect.getMySQLConnection();
		statement=connection.prepareStatement("select deptname from department");
		rs=statement.executeQuery();
		while(rs.next()){
			strings.add(rs.getString("deptname"));
		}
		}catch(SQLException e){
			e.getMessage().toString();
		}
		return strings;
		
	}

	public Doctor gettheDoctor(String serial){
		
		Doctor d=new Doctor();
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet rs = null;
		try{
			connection=DBConnect.getMySQLConnection();
			statement=connection.prepareStatement("select * from doctor where serial_no=?");
			statement.setString(1, serial);
			rs=statement.executeQuery();
			if(rs.next()){
				d.setSerialNo(rs.getString("serial_no"));
				d.setFirstName(rs.getString("first_name"));
				d.setMiddleName(rs.getString("middle_name"));
				d.setLastName(rs.getString("last_name"));
				d.setFees(rs.getString("fees"));
				d.setSlots(rs.getString("slots"));
				d.setSlotString(d.getSlots().split("/"));
			}
			System.out.println(d.getFirstName());
		
        	}catch(SQLException e){
        		e.getMessage().toString();
        	}
		return d;
 }

	public String getPassword(String registrationNo)
	{
		String password=null;
		Connection con=DBConnect.getMySQLConnection();
		try {
			PreparedStatement psmt= con.prepareStatement("select password from Doctor where registration_no=?;");
			psmt.setString(1, registrationNo);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()){
				password =rs.getString(1);
			}
			DBConnect.closeMySQLPreaparedStatementConnection(psmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnect.closeMySQLConnection(con);
return password;		
	}
	public boolean updatePassword(String registrationNo,String password){
		boolean reply=false;
		Connection con=DBConnect.getMySQLConnection();
		try {
			PreparedStatement psmt= con.prepareStatement("update Doctor set password=? where registration_no=?;");
			psmt.setString(1, password);
			psmt.setString(2, registrationNo);
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



	
}
