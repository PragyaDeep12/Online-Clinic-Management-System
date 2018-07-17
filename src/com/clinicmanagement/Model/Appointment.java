package com.clinicmanagement.Model;

public class Appointment {
private String idAppointment;
private String doctorSerial;
private String doctorName;
private String idPatient;
private String patientName;
private String date;
private String slot;
private String fees;
public String getIdAppointment() {
	return idAppointment;
}
public void setIdAppointment(String idAppointment) {
	this.idAppointment = idAppointment;
}
public String getDoctorSerial() {
	return doctorSerial;
}
public void setDoctorSerial(String doctorSerial) {
	this.doctorSerial = doctorSerial;
}
public String getDoctorName() {
	return doctorName;
}
public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}
public String getIdPatient() {
	return idPatient;
}
public void setIdPatient(String idPatient) {
	this.idPatient = idPatient;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getSlot() {
	return slot;
}
public void setSlot(String slot) {
	this.slot = slot;
}
public String getFees() {
	return fees;
}
public void setFees(String fees) {
	this.fees = fees;
}

}
