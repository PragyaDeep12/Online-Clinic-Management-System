<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<body style="background-image: url('Images/back.jpg');background-size: 100%">
<jsp:include page="Includes/Master.jsp"/>
<div>
<!--  -->

<div align="center" style="padding-top: 50px;" class="col"  >
<div style="max-width: 20rem;box-shadow: 10px 20px 30px black;" class="card border-primary mb-3">
<div class="card-header bg-primary" style="color: white;"><h5>Check Appointment By Date</h5></div>
  <div style="padding: 10px">
  <s:form action="checkdocappo.action">
					<s:textfield type="date" name="appodate" label="Appointment Date"/>
					<input type="hidden" value="<%=session.getAttribute("regno") %>" name="registrationNo">
					<s:submit value=" Check     Appointment "></s:submit>
					</s:form>
</div>
</div>
</div>
</div>

<!--  -->
<div class="col" style="width: 100%;padding-top: 50px">
<div >
<h2 style="color: #2C3E50 ">Booking History</h2>
<s:if test="noData==true">
<table class="table table-hover">
  <thead style="background-color:  #2C3E50;">
    <tr>
      <th scope="col" style="color: white;">Date</th>
      <th scope="col" style="color: white;">Appointment Id</th>
      <th scope="col" style="color: white;">Patient Id</th>
      <th scope="col" style="color: white;">Patient Name</th>
      <th scope="col" style="color: white;">Doctor Slot</th>
      
    </tr>
  </thead>
  <tbody>
   <s:iterator value="appList">
   <tr class="table-success">
   		<th><s:property value="date"/></th>
   		<td><s:property value="idAppointment"/></td>
   		<td><s:property value="idPatient"/></td>
   		<td><s:property value="patientName"/></td>
   		<td><s:property value="slot"/></td>
   		
   </tr>
   </s:iterator>
    
	</tbody>
	</table>
	</s:if><s:else>
	
	<h3>No data Found!</h3>
	
	</s:else>
</div>
</div>



</body>
<jsp:include page="Includes/Footer.jsp"></jsp:include>
</html>