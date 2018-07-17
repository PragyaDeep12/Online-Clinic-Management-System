package com.clinicmanagement.Action;

import com.clinicmanagement.Dao.DoctorDao;
import com.clinicmanagement.Model.Doctor;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DoctorUpdateDetails extends ActionSupport implements ModelDriven<Doctor>{
/**
	 * 
	 */private String registrationNo;
	 private String []slotList;
	public String[] getSlotList() {
		return slotList;
	}
	public void setSlotList(String[] slotList) {
		this.slotList = slotList;
	}
	private static final long serialVersionUID = 1L;
Doctor doc= new Doctor();
	@Override
	public Doctor getModel() {
		// TODO Auto-generated method stub
		return doc;
	}
	public String update()
	{this.setRegistrationNo(doc.getRegistrationNo());
		DoctorDao daoobj= new DoctorDao();
		if(daoobj.updateDoctorDetails(doc))
		return "SUCCESS";
		else
			return"FAIL";
	}
	
	
	public String updateSlot()
	{this.setRegistrationNo(doc.getRegistrationNo());
	for(String s:doc.getSlotString())
	{
		System.out.println("slot is="+s);
	}
		DoctorDao daoobj= new DoctorDao();
		if(daoobj.updateSlots(doc.getSlotString(), registrationNo))
		
		return "SUCCESS";
		return "FAIL";
		
	}
	
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	

}
