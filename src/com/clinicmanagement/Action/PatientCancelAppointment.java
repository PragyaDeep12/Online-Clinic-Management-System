package com.clinicmanagement.Action;

import com.clinicmanagement.Dao.AppointmentDao;
import com.opensymphony.xwork2.ActionSupport;

public class PatientCancelAppointment extends ActionSupport{
private String appointmentId;

public String getAppointmentId() {
	return appointmentId;
}

public void setAppointmentId(String appointmentId) {
	this.appointmentId = appointmentId;
}
public String cancelAppointment(){
	AppointmentDao dao= new AppointmentDao();
	if(dao.cancelAppointment(getAppointmentId()))
		return "SUCCESS";
	else return "FAIL";
	
}
}
