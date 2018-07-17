<%@page import="com.clinicmanagement.Model.Patient"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Account</title>
<jsp:include page="Includes/Master.jsp"></jsp:include>
</head>
<%Patient p=(Patient)session.getAttribute("patient"); %>
<body style="background-image: url('Images/back.jpg');background-size: 100%">



<div class="row">
<div class="col">
<div align="center" style="width: 65%;padding-left: 35%;min-width: 600px;padding-top: 50px">
	<ul class="list-group" >
	<li class="list-group-item list-group-item-action active"><h4>Patient Details</h4>
	</li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Name : </h5><h6><%=p.getFullName() %></h6>
  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Email : </h5><h6><%=p.getEmailId()%></h6>
  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Age : </h5><h6><%=p.getAge() %></h6>
  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Contact : </h5><h6><%=p.getContact() %></h6>
  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Gender : </h5><h6><%=p.getGender() %></h6>
  </li>
  <li>
  <a href="PatientUpdate.action" class="list-group-item list-group-item-action">Update Details</a>
  </li>
</ul>
</div>
</div>
<div class="col" style="width: 90%;padding-right: 60px;padding-top: 50px">
<div >
<h2 style="color: #2C3E50 ">Booking History</h2>
<table class="table table-hover">
  <thead style="background-color:  #2C3E50;">
    <tr>
      <th scope="col" style="color: white;">Date</th>
      <th scope="col" style="color: white;">Appointment Id</th>
      <th scope="col" style="color: white;">Doctor Name</th>
      <th scope="col" style="color: white;">Doctor Slot</th>
      <th scope="col" style="color: white;">Cancel</th>
    </tr>
  </thead>
  <tbody>
   <s:iterator value="AppointmentHistory">
   <tr class="table-success">
   		<th><s:property value="date"/></th>
   		<td><s:property value="idAppointment"/></td>
   		<td><s:property value="doctorName"/></td>
   		<td><s:property value="slot"/></td>
   		<td><a href="patientcancelappointment.action?appointmentId=<s:property value="idAppointment"/>" style="color: white;">cancel</a></td>
   </tr>
   </s:iterator>
    
	</tbody>
	</table>
</div>
</div>
</div>
</body>
<jsp:include page="Includes/Footer.jsp" ></jsp:include>
</html>