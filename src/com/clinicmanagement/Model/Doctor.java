package com.clinicmanagement.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String serialNo;
	private String emailId;
	private String password;
	private String registrationNo;
	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	private String contact;
	private String age;
	private String gender;
	private String specialty;
	private ArrayList<String> slotList;
	private String [] slotString;
	private String slots;
	private String fees;
	private String rent;
	private String certificate;
	private String experience;
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getSlots() {
		return slots;
	}
	public void setSlots(String slots) {
		this.slots = slots;
	}
	public String getFees() {
		return fees;
	}
	public void setFees(String fees) {
		this.fees = fees;
	}
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String [] getSlotString() {
		return slotString;
	}
	public void setSlotString(String [] slotString) {
		this.slotString = slotString;
		slotList =new ArrayList<>();
		String h="";
		for(String s:slotString)
		{
			h=h+"/"+s;
			System.out.println("s="+s);
			
			slotList.add(s);
		}
		this.setSlots(h);
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public ArrayList<String> getSlotList() {
		return slotList;
	}
	public void setSlotList(ArrayList<String> slotList) {
		this.slotList = slotList;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	
}
