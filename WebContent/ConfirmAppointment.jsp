<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="CSS/CustomFlatly.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Appointment</title>
<jsp:include page="Includes/Master.jsp"/>
</head>
<body style="background-image: url('Images/back.jpg');background-size: 100%">
<div class="row">
<div align="left" style="padding-top: 30px;padding-left: 50px" class="col"  >
<div style="max-width: 20rem;" class="card border-primary mb-3">
<div class="card-header bg-primary" style="color: white;"><h5>Confirm Appointment</h5></div>
  <div style="padding: 10px">
  <s:form action="bookconfirmedappointment.action">
  <s:iterator value="doctor">
  	<h5>Confirm Your Appointment for
  	<div style="color: blue;"> 
  	Dr. <s:property value="firstName"></s:property> 
  	<s:property value="middleName"></s:property>
  	<s:property value="lastName"></s:property>
  	</div>
  	in slot
  	<div style="color: blue;"><s:property value="slot"></s:property></div>
  	on date
  	<s:textfield name="serialNo" hidden="true"></s:textfield>
  	<s:textfield name="slot" hidden="true"></s:textfield>
  	<s:textfield name="date" hidden="true"></s:textfield>
  	<s:textfield name="fees" hidden="true"></s:textfield>
  	<input type="hidden" value='<%=session.getAttribute("uid") %>' name="emailid">
  	<div style="color: blue;"><s:property value="date"></s:property></div>
  	with Fees
  	<div style="color: blue;"> Rs<s:property value="fees"></s:property></div> </h5>
  	
  	</s:iterator>
  	
 	<s:submit value="Confirm Appointment"></s:submit>
   </s:form>
</div>
</div>
</div>
</div>
</body>
<jsp:include page="Includes/Footer.jsp"></jsp:include>
</html>