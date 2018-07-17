package com.clinicmanagement.Action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.clinicmanagement.Dao.AppointmentDao;
import com.clinicmanagement.Dao.DatabaseHandler;
import com.clinicmanagement.Model.Appointment;
import com.clinicmanagement.Model.Patient;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginPatientAction extends ActionSupport implements ModelDriven<Patient>,ServletRequestAware {
	private static final long serialVersionUID = 1L;
	private Patient patient=new Patient();
	private HttpSession session;
	private ArrayList<Appointment> AppointmentHistory=new ArrayList<>();
	
	@Override
	public Patient getModel() {
		// TODO Auto-generated method stub
		return patient;
	}
	public String viewLogin(){
		return "SUCCESS";
	}
	public String logout() {
		session.invalidate();
		return "SUCCESS";
	}
	public String viewAccount()
	{
		AppointmentDao dao=new AppointmentDao();
		setAppointmentHistory(dao.getAppointmentPatient((Patient)session.getAttribute("patient")));
		return "SUCCESS";
	}
	
	
	public String PatientUpdate(){
		if(session.getAttribute("patient")!=null)
		return "SUCCESS";
		else return "FAIL";
	}
	public String updatepatientdetails() {
		System.out.println("email"+patient.getEmailId());
		DatabaseHandler databaseHandler=new DatabaseHandler();
		Patient p=databaseHandler.updatePatient(this.patient);
		AppointmentDao dao=new AppointmentDao();
		setAppointmentHistory(dao.getAppointmentPatient(this.patient));
	
		session.setAttribute("patient", p);
		return "SUCCESS";
	}
	
	public String PatientLogin(){
		 // System.out.println("email: "+getModel().getEmailId()+", password: "+getModel().getPassword());
		  
		  Patient pat=DatabaseHandler.logincheck(getModel());
		if(pat!=null){
	    	session.setAttribute("patient", pat);
	    	session.setAttribute("uid", pat.getEmailId());
	    	this.patient=pat;
	    	AppointmentDao dao=new AppointmentDao();
			setAppointmentHistory(dao.getAppointmentPatient(pat));
		return "success";
		}else{
			return "failed";
		}
	}

		@Override
	public void setServletRequest(HttpServletRequest r) {
		session=r.getSession();
		
	}
		public ArrayList<Appointment> getAppointmentHistory() {
			return AppointmentHistory;
		}
		public void setAppointmentHistory(ArrayList<Appointment> appointmentHistory) {
			AppointmentHistory = appointmentHistory;
		}

	
}
