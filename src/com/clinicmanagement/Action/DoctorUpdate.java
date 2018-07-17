package com.clinicmanagement.Action;

import java.util.ArrayList;

import com.clinicmanagement.Dao.DoctorDao;
import com.clinicmanagement.Model.Doctor;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class DoctorUpdate extends ActionSupport {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	/**
	 *   <action name="doctorupdateview"class="com.clinicmanagement.Action.DoctorUpdate" method="viewUpdate">
	   <result name="SUCCESS">/UpdateDoctor.jsp</result>
	   </action>
	 */
	private String registrationNo;
	
	private ArrayList<Doctor> list;
	private boolean noData = false;
	private ArrayList<String> doctorSlot;
	private ArrayList<String> listOfSlot;
	
 public String getRegistrationNo() {
		return registrationNo;
	}




	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	
	
	
public String viewUpdate()
{System.out.println("regis"+getRegistrationNo());
	DoctorDao daoobj=new DoctorDao();
	list=daoobj.selectRecord(getRegistrationNo());
	if(list.size()>0)
	{
		Doctor doc=list.get(0);
		setDoctorSlot(doc.getSlotList());
		setListOfSlot(daoobj.fetchSlots());
		for(String s:getDoctorSlot())
		{int i=0;
			for(String s1:listOfSlot)
			{
				if(s1.equalsIgnoreCase(s))
			i=1;
		}
			if(i==0)
			listOfSlot.add(s);
		}
		
		System.out.println("ssssssssss"+list.size());
		setNoData(true);
		
	}
	return "SUCCESS";
}
public String viewSlotUpdate()
{
	return "SUCCESS";
}


@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
	return "SUCCESS";
}




public ArrayList<Doctor> getList() {
	return list;
}




public void setList(ArrayList<Doctor> list) {
	this.list = list;
}




public boolean isNoData() {
	return noData;
}




public void setNoData(boolean noData) {
	this.noData = noData;
}




public ArrayList<String> getListOfSlot() {
	return listOfSlot;
}




public void setListOfSlot(ArrayList<String> listOfSlot) {
	this.listOfSlot = listOfSlot;
}




public ArrayList<String> getDoctorSlot() {
	return doctorSlot;
}




public void setDoctorSlot(ArrayList<String> doctorSlot) {
	this.doctorSlot = doctorSlot;
}





}
