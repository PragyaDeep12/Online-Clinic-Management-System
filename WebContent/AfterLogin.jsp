<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AfterLogin</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<body style="background-image: url('Images/back.jpg');background-size: 100%">
<jsp:include page="Includes/Master.jsp"/>

<div class="col" style="padding-top: 50px">
<div class="card text-white bg-primary mb-3" style="max-width: 20rem;box-shadow: 10px 20px 30px black;">
  <div class="card-header"><h4>Rules And Regulation</h4></div>
  <div class="card-body">
    <p class="card-text">
<a href="doctorview.action?registrationNo=<%=session.getAttribute("regno") %>"class="btn btn-primary">Your Details</a>
<a href="doctorupdateview.action?registrationNo=<%=session.getAttribute("regno") %>"class="btn btn-primary">Update Personal Details</a>
<a href="doctorupdateslotview.action?registrationNo=<%=session.getAttribute("regno") %>"class="btn btn-primary">Update Slot Details</a>
<a href="doctorcheckappointmentview.action?registrationNo=<%=session.getAttribute("regno") %>" class="btn btn-primary">CheckAppointment</a>
<a href="doctorchangepasswordview.action?registrationNo=<%=session.getAttribute("regno") %>"class="btn btn-primary">Change Password</a>


   </p>
  </div>
</div>
</div>

 </body>
 <jsp:include page="Includes/Footer.jsp"></jsp:include>
</html>