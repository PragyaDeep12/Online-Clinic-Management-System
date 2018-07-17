package com.clinicmanagement.Action;

import java.util.ArrayList;

import com.clinicmanagement.Dao.DatabaseHandler;
import com.clinicmanagement.Dao.DoctorDao;
import com.clinicmanagement.Dao.SlotsDao;
import com.clinicmanagement.Model.Doctor;
import com.opensymphony.xwork2.ActionSupport;

public class PatientAppointmentAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ArrayList<Doctor> list_docs=new ArrayList<Doctor>();
	private ArrayList<String> list_types=new ArrayList<String>();
	private ArrayList<String> list_slot=new ArrayList<String>();
	private String dept_type;
	private String doctorid;
	private String dtaval;

	public String getDtaval() {
		return dtaval;
	}


	public void setDtaval(String dtaval) {
		this.dtaval = dtaval;
	}


	public ArrayList<Doctor> getList_docs() {
		return list_docs;
	}


	public String setList_docs() {
		DoctorDao dao=new DoctorDao();
		ArrayList<Doctor> doctors=dao.getDoctors("Orthopedic");
		ArrayList<String> doctypes=dao.gettypes();
		this.list_docs = doctors;
		this.list_types=doctypes;
		return "DONE";
	}


	public ArrayList<String> getList_types() {
		return list_types;
	}


	public void setList_types(ArrayList<String> list_types) {
		this.list_types = list_types;
	}
	
	public String setList_docsnew(){
		System.out.println("reached");
		DoctorDao dao=new DoctorDao();
		System.out.println(dept_type);
		ArrayList<Doctor> doctors=dao.getDoctors(dept_type);
		ArrayList<String> doctypes=dao.gettypes();
		this.list_types=doctypes;
		this.list_docs=doctors;
		return "DONE";
		
	}

	
	public String checkslots(){
		SlotsDao dao=new SlotsDao();
		System.out.println("Doctor Id:"+doctorid);
		System.out.println("Date:"+dtaval);
		list_slot= dao.getslot(getDtaval(), doctorid);
		System.out.println(list_slot.size());
		return "DONE";
	}
	

	public String getDept_type() {
		return dept_type;
	}


	public void setDept_type(String dept_type) {
		this.dept_type = dept_type;
	}
	
	

	public String getDoctorid() {
		return doctorid;
	}


	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}
	
	public String bookappointment(){
		return "DONE";
	}


	public ArrayList<String> getList_slot() {
		return list_slot;
	}


	public void setList_slot(ArrayList<String> list_slot) {
		this.list_slot = list_slot;
	}

}
