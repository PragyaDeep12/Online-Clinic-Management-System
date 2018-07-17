package com.clinicmanagement.Action;

import java.util.ArrayList;

import com.clinicmanagement.Dao.AppointmentDao;
import com.clinicmanagement.Model.Appointment;
import com.opensymphony.xwork2.ActionSupport;

public class DoctorAppointment extends ActionSupport{
private String registrationNo;
private ArrayList<Appointment> appList;
 private boolean noData=false;
 private String appodate;
public String getRegistrationNo() {
	return registrationNo;
}

public String checkdocappo(){
	AppointmentDao dao= new AppointmentDao();
	System.out.println("next register="+registrationNo);
	ArrayList<Appointment> appointments=dao.getAppList(registrationNo);
	ArrayList<Appointment> new_appointments=new ArrayList<Appointment>();
	System.out.println(appodate);
	for(Appointment appo:appointments){
		if((appo.getDate()).equals(appodate)){
			new_appointments.add(appo);
		}
	}
	
	this.setAppList(new_appointments);
	if(this.getAppList().size()>0)
		this.setNoData(true);
	return "SUCCESS";
}
public void setRegistrationNo(String registrationNo) {
	this.registrationNo = registrationNo;
}

public ArrayList<Appointment> getAppList() {
	return appList;
}

public void setAppList(ArrayList<Appointment> appList) {
	this.appList = appList;
}
public String checkApp()
{
	AppointmentDao dao= new AppointmentDao();
	System.out.println(registrationNo);
	this.setAppList(dao.getAppList(registrationNo));
	if(this.getAppList().size()>0)
		this.setNoData(true);
	return "SUCCESS";
}

public boolean isNoData() {
	return noData;
}

public void setNoData(boolean noData) {
	this.noData = noData;
}

public String getAppodate() {
	return appodate;
}

public void setAppodate(String appodate) {
	this.appodate = appodate;
}
}
