package com.clinicmanagement.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.clinicmanagement.Dao.DatabaseHandler;
import com.clinicmanagement.Model.Patient;
import com.clinicmanagement.Utility.EmailConfirmation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class RegisterPatientAction extends ActionSupport implements ModelDriven<Patient>,ServletRequestAware{
	private Patient patient=new Patient();
	private String passcode;
	private String password;
	private String email;
	private static final long serialVersionUID = 1L;
	HttpSession session;
	public String viewPage() {
		return "valid";
	}
	public String AddPatient(){
		EmailConfirmation confirmation=new EmailConfirmation();
		String code = confirmation.MailSender(patient.getEmailId());
		session.setAttribute("passcode_gen", code);
		session.setAttribute("temp_email", patient.getEmailId());
		session.setAttribute("patient",patient);
		
		return "success";
		
	}
	public String AddPatientConfirmed(){
		String Email_temp=(String) session.getAttribute("temp_email");
		String Pass_Gen=(String) session.getAttribute("passcode_gen");
		System.out.println("Email_temp : "+Email_temp);
		System.out.println("Pass_Gen : "+Pass_Gen);
		System.out.println("Pass : "+getPasscode());
		
		if(Pass_Gen.equals(getPasscode())){
			if(DatabaseHandler.Addrecord((Patient)session.getAttribute("patient"))){
				session.setAttribute("uid", ((Patient)session.getAttribute("patient")).getEmailId());
				return "success";
			}else{
				return "failed";	
			}	
		}else{
			return "failed";
		}
		
	}
	
	
	@Override
	public Patient getModel() {
		// TODO Auto-generated method stub
		return patient;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
	this.session= request.getSession();
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
