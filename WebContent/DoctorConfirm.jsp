<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EnterOtp</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">

<jsp:include page="Includes/Master.jsp"/>
</head>
<body style="background-image: url('Images/back.jpg');background-size: 100%">

<div class="row">
<div align="center" style="padding-top: 50px;" class="col"  >
<div style="max-width: 20rem;box-shadow: 10px 20px 30px black;" class="card border-primary mb-3">
<div class="card-header bg-primary" style="color: white;"><h4>Confirmation Code</h4></div>
  <div style="padding: 10px">
<s:form action="confirmdoctorregistration.action" >
<s:textfield name="passcode" label="pascode"></s:textfield>
<s:submit></s:submit>
</s:form>
</div>
</div>
</div>
</div>
</body>
<jsp:include page="Includes/Footer.jsp"></jsp:include>
</html>