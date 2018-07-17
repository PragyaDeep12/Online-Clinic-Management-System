<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Finance</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<body>
<jsp:include page="Includes/Master.jsp"/>
	<s:form action="adminaccount.action">
	<s:textfield name="firstDate" type="date" label="Enter starting date"></s:textfield>
	<s:textfield name="lastDate" type="date" label="Enter ending date"></s:textfield>
	<s:submit value="Check Income"></s:submit>
	</s:form>
	<table class="table table-hover">
  <thead style="background-color:  #2C3E50;">
    <tr>
      <th scope="col" style="color: white;">Date</th>
      <th scope="col" style="color: white;">Appointment Id</th>
      <th scope="col" style="color: white;">Profit</th>
      
      
    </tr>
  </thead>
  <tbody>
  <s:iterator value="appList"> 
  <tr>
  <td><s:property value="date"/></td>
  <td><s:property value="appointmentId"/></td>
  <td><s:property value="adminProfit"/></td>

  </tr>
  
  
  </s:iterator>
  <tr><td></td><td><b>Total Income</b></td><td><b><s:property value="totalProfit"/></b></td></tr>
  
  </tbody></table>
	
</body>
</html>