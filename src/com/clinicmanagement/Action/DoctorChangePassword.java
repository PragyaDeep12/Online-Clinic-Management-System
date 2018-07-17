package com.clinicmanagement.Action;

import com.clinicmanagement.Dao.DoctorDao;
import com.opensymphony.xwork2.ActionSupport;

public class DoctorChangePassword extends ActionSupport {
	private String registrationNo;
	private String newPass;
	private String oldPass;
	private String password;
	public String view(){
		DoctorDao dao=new DoctorDao();
		this.setPassword(dao.getPassword(this.getRegistrationNo()));
		
		return "SUCCESS";
	}
	
	public String change(){
		DoctorDao dao=new DoctorDao();
		this.setPassword(dao.getPassword(this.getRegistrationNo()));
		System.out.println("oldpass"+this.oldPass);
		System.out.println("newpass"+this.newPass);
		System.out.println("pass"+this.password);
		System.out.println("registration"+this.registrationNo);
		
		
		if(this.getPassword().equals(this.getOldPass()))
		{
			dao.updatePassword(this.getRegistrationNo(), this.getNewPass());
			return "SUCCESS";
		}
		return "FAIL";
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
