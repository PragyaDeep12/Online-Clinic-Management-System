<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="stylesheet" type="text/css" href="CSS/CustomFlatly.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<jsp:include page="Includes/Master.jsp"/>
</head>
<body style="background-image: url('Images/back.jpg');background-size: 100%">

<div class="row">
<div align="center" style="padding-top: 50px;" class="col"  >
<div style="max-width: 20rem;box-shadow: 10px 20px 30px black;" class="card border-primary mb-3">
<div class="card-header bg-primary" style="color: white;"><h1>Log In</h1></div>
  <div style="padding: 10px">
<s:form action="LoginPatientSubmit.action" method="post">
	<s:textfield label="Email Id " name="emailId" value="" required="true" cssClass="form-control"></s:textfield>
	<s:password label="Password " name="password" value="" required="true" cssClass="form-control"></s:password>
	<s:submit value="Log In " align="center" cssClass="btn btn-success"></s:submit>
</s:form>
<a href="RegisterPatient.jsp" class="btn btn-success" style="margin: 10px">Register</a>
</div>
</div>
</div>

<div class="col" style="padding-top: 50px">
<div class="card text-white bg-primary mb-3" style="max-width: 20rem;box-shadow: 10px 20px 30px black;">
  <div class="card-header"><h4>Rules And Regulation</h4></div>
  <div class="card-body">
    <p class="card-text">
    <ul>
    <li>Patient Should Come <b>20 Minutes</b> prior to Appointment</li>
    <li>100% Payment Should be made <b>5 days</b> prior to Appointment</li>
    <li>No Refund for Cancellation of Appointment</li>
    <li>Change of <b>Department / unit</b> not be allowed</li>
    <li>change in appoinment will not be allowed</li>    
    <li>Please provide atleast <b>Govt. Related ID</b> proof when you present yourself at the entrance</li>
    <li>Request for appointments via post/phone will not be accepted</li>
    <li><b>Demand Draft/Cash</b> will not be accepted only online accepted</li>    
    
    </ul>
    </p>
  </div>
</div>
</div>
</div>

</body>

</html>
<jsp:include page="Includes/Footer.jsp"></jsp:include>
