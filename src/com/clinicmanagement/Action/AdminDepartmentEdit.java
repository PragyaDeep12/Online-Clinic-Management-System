package com.clinicmanagement.Action;

import java.util.ArrayList;

import com.clinicmanagement.Dao.AdminDao;
import com.opensymphony.xwork2.ActionSupport;

public class AdminDepartmentEdit extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String department;
	ArrayList<String> deptList;
	public ArrayList<String> getDeptList() {
		return deptList;
	}
	public void setDeptList(ArrayList<String> deptList) {
		this.deptList = deptList;
	}
	public String viewDepartment() {
		AdminDao dao= new AdminDao();
		setDeptList(dao.fetchDepartment());
		return "SUCCESS";
	}
	public String addDepartmentView(){
		return "SUCCESS";
	}
	
	public String addDepartment(){
		AdminDao dao= new AdminDao();
		
		if(dao.addDepartment(this.getDepartment()))
		return "SUCCESS";
		else 
			return "FAIL";
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
