<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="stylesheet" type="text/css" href="CSS/CustomFlatly.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Email</title>

<jsp:include page="Includes/Master.jsp"/>
</head>
<body style="background-image: url('Images/back.jpg');background-size: 100%">

<div class="row">
<div align="center" style="padding-top: 50px;" class="col"  >
<div style="max-width: 20rem;box-shadow: 10px 20px 30px black;" class="card border-primary mb-3">
<div class="card-header bg-primary" style="color: white;"><h4>Confirmation Code</h4></div>
  <div style="padding: 10px">
<s:form action="RegisterPatientConfirmSubmit.action" method="post">
	<s:password label="Passcode " name="passcode" value=""></s:password>
	<s:submit value="Verify" align="center"></s:submit>
	
</s:form>
</div>
</div>
</div>

<div class="col" style="padding-top: 50px">
<div class="card text-white bg-primary mb-3" style="max-width: 20rem;box-shadow: 10px 20px 30px black;">
  <div class="card-header"><h4>Rules And Regulation</h4></div>
  <div class="card-body">
    <p class="card-text">
    <ul>
    <li>Patient Should Come 20 Minutes prior to Appointment</li>
    <li>100% Payment Should be made 5 days prior to Appointment</li>
    <li>No Refund for Cancellation of Appointment</li>
    <li>Payment Should be made 15 days prior to Appointment</li>
    <li>Patient Should Come 20 Minutes prior to Appointment</li>
    <li>Payment Should be made 15 days prior to Appointment</li>
    
    </ul>
    </p>
  </div>
</div>
</div>
</div>

</body>
<jsp:include page="Includes/Footer.jsp"></jsp:include>
</html>