package com.clinicmanagement.Action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.clinicmanagement.Dao.AdminDao;
import com.clinicmanagement.Dao.DoctorDao;
import com.clinicmanagement.Model.Doctor;
import com.clinicmanagement.Utility.EmailConfirmation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DoctorRegistration extends ActionSupport implements ModelDriven<Doctor> ,ServletRequestAware{
	
	/**
	 * 
	 */
	private String registrationNo;
	HttpSession session;
	private String code;
	private String passcode;
	private List<String> slot;
	private List<String> list_types;
	private static final long serialVersionUID = 1L;
	Doctor doc= new Doctor();
 public String viewRegistration()
 {	
	 DoctorDao daoobj=new DoctorDao();
	 
	 //System.out.println("hfhgfv");
	 List<String> s=new ArrayList<>();
			s= (daoobj.fetchSlots());
	AdminDao dao =new AdminDao();
	setList_types(dao.fetchDepartment());
	 this.setSlot(s);
	 return "SUCCESS";
 }

 
 
 
 
 
 public String registerConfirm()
 {
	 session.setAttribute("uid", doc.getEmailId());
	 EmailConfirmation mail=new EmailConfirmation();
	session.setAttribute("doctor", doc);
	session.setAttribute("regno", doc.getRegistrationNo());
	 setCode( mail.MailSender(doc.getEmailId()));
	 session.setAttribute("code", code);
	 
		 return "VALID";
 }
 public String register()
 {
	 if(((String)session.getAttribute("code")).equals(getPasscode()))
 { DoctorDao daoobj=new DoctorDao();
	 if(daoobj.insert((Doctor)session.getAttribute("doctor")))
	 {this.setRegistrationNo((String)session.getAttribute("regno"));
	 System.out.println("registrationno"+this.getRegistrationNo());
		 return "VALID";
	 }
	 
	 else
	 return "INVALID";}
 else
	 return"INVALID";
 }
@Override
public Doctor getModel() {
	// TODO Auto-generated method stub
	return doc;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

@Override
public void setServletRequest(HttpServletRequest request) {
	// TODO Auto-generated method stub
	session=request.getSession();
	
}

public String getPasscode() {
	return passcode;
}

public void setPasscode(String passcode) {
	this.passcode = passcode;
}

public List<String> getSlot() {
	return slot;
}

public void setSlot(List<String> slot) {
	this.slot=new ArrayList<>();
	for(String s:this.slot)
	System.out.println(s+"ghchh");
	System.out.println("cdhgdfg");
	this.slot=slot;
}






public String getRegistrationNo() {
	return registrationNo;
}






public void setRegistrationNo(String registrationNo) {
	this.registrationNo = registrationNo;
}






public List<String> getList_types() {
	return list_types;
}






public void setList_types(List<String> list_types) {
	this.list_types = list_types;
}


}
