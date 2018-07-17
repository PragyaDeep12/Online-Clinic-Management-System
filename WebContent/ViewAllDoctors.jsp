<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctors</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<body>
<jsp:include page="Includes/Master.jsp"/>
<s:if test="noData==true">
<h2 >Doctors in the clinic</h2>
<br>
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">RegistrationNo</th>
      <th scope="col">First Name</th>
      <th scope="col">Middle Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Address</th>
      <th scope="col">Contact</th>
      <th scope="col">Gender</th>
      <th scope="col">Email-Id</th>
      <th scope="col">Experience</th>
      <th scope="col">Specialty</th>
      <th scope="col">Slot</th>
      <th scope="col">Age</th>
      <th scope="col">Fees</th>
      <th scope="col">Clinic Rent</th>
    </tr>
  </thead>
  <s:iterator value="doctorList">
  <tbody>
    <tr class="table-active">
      <td><s:property value="registrationNo"/></td>
     <td><s:property value="firstName"/></td> 
     <td><s:property value="middleName"/></td>
     <td><s:property value="lastName"/></td>
     <td><s:property value="address"/></td>
     <td><s:property value="contact"/></td>
     <td><s:property value="gender"/></td>
     <td><s:property value="emailId"/></td>
     <td><s:property value="experience"/></td>
     <td><s:property value="specialty"/></td>
     <td><s:property value="slots"/></td>
     <td><s:property value="age"/></td>
     <td><s:property value="fees"/></td>
     <td><s:property value="rent"/></td>
    </tr>
</tbody>
</s:iterator>
</table>
</s:if>
<s:else>
<h1>No data found!!!!</h1>

</s:else>
</body>
<jsp:include page="Includes/Footer.jsp"></jsp:include>
</html>