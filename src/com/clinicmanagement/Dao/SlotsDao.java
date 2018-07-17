package com.clinicmanagement.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.clinicmanagement.Model.Doctor;
import com.clinicmanagement.Utility.DateToDay;

public class SlotsDao {
	private static final int MAX_ALLOTMENT_PER_SLOT=2;
	public ArrayList<String> getslot(String date,String doctorserial)
	{
		ArrayList<String> slots=new ArrayList<>();
		//ArrayList<String> finalslots=new ArrayList<>();
		Connection conn= null;
		PreparedStatement psmt = null;
		ResultSet rs=null;
		try {
			conn=DBConnect.getMySQLConnection();
			
			psmt=conn.prepareStatement("select slot from appointment where doctorserial =?and date=?;");
			System.out.println(date);
			System.out.println(doctorserial);
			psmt.setString(1, doctorserial);
			psmt.setString(2, date);
			rs=psmt.executeQuery();
			while(rs.next()){
				System.out.println("Slot2 :"+rs.getString("slot"));
				slots.add(rs.getString("slot"));
				
			}
			
			
		}catch(SQLException e){
			e.getMessage().toString();
		}
			
				return setDifference(slots,doctorserial,date);
	}
	
	
	
	private ArrayList<String> setDifference(ArrayList<String> slots,String doctorser,String date) {
		// TODO Auto-generated method stub
		ArrayList<String> finalslots=new ArrayList<>();
		DoctorDao dao=new DoctorDao();
		Doctor dr=dao.gettheDoctor(doctorser);
		ArrayList<String> allslots=dr.getSlotList();
		System.out.println("Small : "+slots.size());
		System.out.println("Large : "+allslots.size());
		for(String s:allslots){
			if(!slots.contains(s) && 
					s.contains(DateToDay.getDayfromdate((date))) && 
					getMaxCount(s, doctorser, date)<=MAX_ALLOTMENT_PER_SLOT){
				finalslots.add(s);
			}
		}
		
		return finalslots;
	}

	public int getMaxCount(String slot,String doctorser,String date){
		int alloted=0;
		Connection conn= DBConnect.getMySQLConnection();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		try {
			statement=conn.prepareStatement("select count(*) from appointment where slot=? and date=? and doctorserial=? ;");
			statement.setString(1, slot);
			statement.setString(2, date);
			statement.setString(3, doctorser);
			resultSet=statement.executeQuery();
			if(resultSet.next()){
				alloted=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alloted;
		
	}

	public ArrayList<String> getall()
	{
		ArrayList<String> slots=new ArrayList<>();
		Connection conn= null;
		PreparedStatement psmt = null;
		ResultSet rs=null;
		try {
			conn=DBConnect.getMySQLConnection();
			psmt=conn.prepareStatement("select * from doctorslots;");
			rs=psmt.executeQuery();
			while(rs.next()){
			slots.add(rs.getString("slot"));
			}
			
		}catch(SQLException e){
			e.getMessage().toString();
		}finally{
			DBConnect.closeMySQLConnection(conn);
			DBConnect.closeMySQLPreaparedStatementConnection(psmt);
		}
		return slots;
	}
	
}
