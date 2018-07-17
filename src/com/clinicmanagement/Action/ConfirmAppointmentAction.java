package com.clinicmanagement.Action;

import com.clinicmanagement.Dao.AppointmentDao;
import com.clinicmanagement.Dao.DatabaseHandler;
import com.clinicmanagement.Dao.DoctorDao;
import com.clinicmanagement.Model.Appointment;
import com.clinicmanagement.Model.Doctor;


public class ConfirmAppointmentAction {
	private String doctid;
	private String date;
	private Doctor doctor;
	private String slot;
	private String serialNo;
	private String emailid;
	private String fees;
	private String firstName;
	public String confirmappointment(){
		System.out.println(getDate());
		System.out.println(getDoctid());
		DoctorDao dao=new DoctorDao();
		doctor=dao.gettheDoctor(getDoctid());
		AppointmentDao dao2=new AppointmentDao();
		if(dao2.checkValidAppointment(doctor, date, emailid))
		{
		return "DONE";
		}else{
			System.out.println("hello failed");
			return "FAIL";}
	}
	
	public String bookconfirmedappointment(){
		AppointmentDao dao=new AppointmentDao();
		DoctorDao dao1=new DoctorDao();
		Appointment appointment=new Appointment();
		Doctor d1=dao1.gettheDoctor(getSerialNo());
		appointment.setDate(date);
		appointment.setSlot(slot);
		appointment.setDoctorSerial(d1.getSerialNo());
		appointment.setDoctorName("Dr. "+d1.getFirstName()+" "+d1.getMiddleName()+" "+d1.getLastName());
		appointment.setIdPatient(emailid);
		appointment.setFees(fees);
		appointment.setPatientName(DatabaseHandler.getPatientbyId(emailid).getFullName());
		dao.addAppointment(appointment);
		return "DONE";
	}
	public String getDoctid() {
		return doctid;
	}
	public void setDoctid(String doctid) {
		this.doctid = doctid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}
	
}
