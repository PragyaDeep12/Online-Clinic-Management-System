package com.clinicmanagement.Model;

public class Business {
private int appointmentId;
private String doctorId;
private String patientId;
private String doctorFees;
private String adminProfit;
private String date;
public int getAppointmentId() {
	return appointmentId;
}
public void setAppointmentId(int appointmentId) {
	this.appointmentId = appointmentId;
}
public String getDoctorId() {
	return doctorId;
}
public void setDoctorId(String doctorId) {
	this.doctorId = doctorId;
}
public String getPatientId() {
	return patientId;
}
public void setPatientId(String patientId) {
	this.patientId = patientId;
}
public String getAdminProfit() {
	return adminProfit;
}
public void setAdminProfit(String adminProfit) {
	this.adminProfit = adminProfit;
}
public String getDoctorFees() {
	return doctorFees;
}
public void setDoctorFees(String doctorFees) {
	this.doctorFees = doctorFees;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

}
