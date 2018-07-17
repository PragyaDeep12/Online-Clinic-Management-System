package com.clinicmanagement.Action;

import java.util.ArrayList;

import com.clinicmanagement.Dao.DoctorDao;
import com.clinicmanagement.Model.Doctor;
import com.opensymphony.xwork2.ActionSupport;

public class AdminViewAllDoctorsAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Doctor> doctorList;
	private boolean noData=false;
	public ArrayList<Doctor> getDoctorList() {
		return doctorList;
	}
	public void setDoctorList(ArrayList<Doctor> doctorList) {
		this.doctorList = doctorList;
	}
	
	
	public String viewDoctors()
	{
		DoctorDao daoobj=new DoctorDao();
		this.setDoctorList(daoobj.selectAll());
		if(this.doctorList.size()>0)
		{
			this.setNoData(true);
		}
		return "SUCCESS";
	}
	public boolean isNoData() {
		return noData;
	}
	public void setNoData(boolean noData) {
		this.noData = noData;
	}
}
