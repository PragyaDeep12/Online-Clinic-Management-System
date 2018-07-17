package com.clinicmanagement.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.clinicmanagement.Dao.DoctorDao;
import com.clinicmanagement.Model.Doctor;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DoctorLogin extends ActionSupport implements ModelDriven<Doctor>,ServletRequestAware{

	/**
	 * 
	 */
	HttpSession session;
	private String registrationNo;
	
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo() {
		this.registrationNo = doc.getRegistrationNo();
	}
	public Doctor getDoc() {
		return doc;
	}
	public void setDoc(Doctor doc) {
		this.doc = doc;
	}
	private static final long serialVersionUID = 1L;
	Doctor doc= new Doctor();
	@Override
	public Doctor getModel() {
		// TODO Auto-generated method stub
		return doc;
	}
	public String viewLogin()
	{
		return "SUCCESS";
	}
	public String login()
	{   
	System.out.println(doc.getRegistrationNo());
	DoctorDao dobj=new DoctorDao();
	if(dobj.verify(doc)){
		
		ArrayList<Doctor> list=new ArrayList<>();
		list=dobj.selectRecord(doc.getRegistrationNo());
		doc=list.get(0);
		session.setAttribute("uid", doc.getEmailId());
		session.setAttribute("regno", doc.getRegistrationNo());
		System.out.println("usid"+session.getAttribute("uid"));
		
		return "VALID";}
	else return "INVALID";
		
	}
	public String viewAfterLogin(){
		return "SUCCESS";	
	}
	@Override
	public void validate() {
		// TODO Auto-generated method stub
	// validations for email
		//validations for blank field
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		session=request.getSession();
		
	}
	

}
