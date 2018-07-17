package com.clinicmanagement.Action;



import com.clinicmanagement.Dao.DoctorDao;


public class AdminDeleteDoctorAction {
	private String registrationNo;

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
public String delete()
{
	DoctorDao daoobj= new DoctorDao();
	daoobj.deleteDoctor(this.getRegistrationNo());
	System.out.println("registration no"+this.getRegistrationNo());
	return "SUCCESS";
}

}
