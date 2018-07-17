<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<body style="background-image: url('Images/back.jpg');background-size: 100%">


<jsp:include page="Includes/Master.jsp"/>

<div class="col">
<div align="center" style="width: 65%;padding-left: 35%;min-width: 600px;padding-top: 50px">
	<s:iterator value="list">
	<ul class="list-group" >
	<li class="list-group-item list-group-item-action active"><h4>Your Details</h4>
	</li>
	<li class="list-group-item d-flex justify-content-between align-items-center">
    <h5><s:property value="registrationNo"/></h5></li>
    <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Name: <s:property value="firstName"/><s:property value="middleName"/><s:property value="lastName"/></h5></li>
    <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Address: <s:property value="address"/></h5>
    </li>
    <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Gender: <s:property value="gender"/></h5></li>
    <li class="list-group-item d-flex justify-content-between align-items-center">
    <h6>Slots :</h6>
    <table>
    
  <s:iterator value="slotList"><tr><td style="padding-right: 160px"><s:property/></td></tr></s:iterator>
   
    </table>
    </li>
    <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Specialty: <s:property value="specialty"/></h5>
    </li>
       <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Email-Id: <s:property value="email-ID"/></h5></li>
       <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Experience: <s:property value="experience"/></h5></li>
       <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Contact: <s:property value="contact"/></h5></li>
       <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Age: <s:property value="age"/></h5></li>
       <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Fees: <s:property value="fees"/></h5></li>
       <li class="list-group-item d-flex justify-content-between align-items-center">
    <h5>Clinic Rent: <s:property value="rent"/></h5></li>
</ul>
</s:iterator>
</div>
</div>
</body>
<jsp:include page="Includes/Footer.jsp"></jsp:include>
</html>