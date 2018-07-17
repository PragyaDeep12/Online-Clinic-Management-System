package com.clinicmanagement.Action;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.clinicmanagement.Dao.AppointmentDao;
import com.clinicmanagement.Dao.BusinessDao;
import com.clinicmanagement.Model.Appointment;
import com.clinicmanagement.Model.Business;

public class AdminAccount {
	private String firstDate;
    private String lastDate;
    private double totalProfit=0;
    private ArrayList<Business> appList;
	public String getFirstDate() {
		return firstDate ;
		
	}
	public void setFirstDate(String firstDate) {
		this.firstDate =firstDate;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public String viewAccount(){
		BusinessDao dao=new BusinessDao();
		this.setAppList(dao.fetchAdminAccount(this.getFirstDate(),this.getLastDate()));
		
		for(Business b:appList){
		totalProfit=totalProfit+Double.parseDouble(b.getAdminProfit());	
		}
		
		return "SUCCESS";
	}
	public String viewAccountPage(){
		return "SUCCESS";
	}
	public ArrayList<Business> getAppList() {
		return appList;
	}
	public void setAppList(ArrayList<Business> appList) {
		this.appList = appList;
	}
	public double getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(double totalProfit) {
		this.totalProfit = totalProfit;
	}
}
