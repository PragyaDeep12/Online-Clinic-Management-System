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
	<s:form action="updatepatientdetails.action">
	<li class="list-group-item list-group-item-action active"><h4>Patient Details</h4>
	</li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Name : </h5><input type='text' value="<%=p.getFullName() %>"  name="fullName">
   
  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center" name="emailId" >
    <h5>Email : </h5><input type="email" name="emailId" value="<%=p.getEmailId() %>" readonly="readonly">
    
  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Age : </h5><input type="number" value="<%=p.getAge() %>" name="age">
    
  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Contact : </h5><input type="number" value="<%=p.getContact() %>" name="contact">
    
  </li>
  <li class="list-group-item d-flex justify-content-between align-items-center" >
 <s:submit cssClass="btn btn-success" ></s:submit> 
  </li>
  </s:form>
  <li>
  <a href="#" class="list-group-item list-group-item-action">Change Password</a>
  </li>
</ul>
</div>
</div>
</div>
</body>
<jsp:include page="Includes/Footer.jsp" ></jsp:include>
</html>
