<%@taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="CSS/CustomFlatly.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Appointment</title>
<jsp:include page="Includes/Master.jsp"/>
</head>
<body style="background-image: url('Images/back.jpg');background-size: 100%">
<div class="row" >
<div align="left" style="padding-top: 30px;padding-left: 50px" class="col"  >
<div style="max-width: 20rem;" class="card border-primary mb-3">
<div class="card-header bg-primary" style="color: white;" ><h5>Select Department</h5></div>
  <div style="padding: 10px">
<s:form action="UpdateDocList.action" >
<s:select list="list_types" name="dept_type" cssClass="form-control"></s:select>
<s:submit value="Search" cssClass="btn btn-primary" cssStyle="margin-top: 5px"></s:submit>
</s:form>
</div>
</div>
</div>
</div>


<table class="table table-hover" style="background-color: white;padding-left: 10px;padding-right: 10px">
	<thead>
	<tr>
	<th>Doctor Firstname</th>
	<th>Doctor Lastname</th>
	<th>Doctor Fees</th>
	<th>Doctor Age</th>
	<th>Doctor Experience</th>
	<th>Appointment</th>
	</tr>
	</thead>
	<tbody>
	<s:iterator value="list_docs">
		<tr>
						<td><s:property value="firstName" /></td>
						<td><s:property value="lastName" /></td>
						<td><s:property value="fees" /></td>
						<td><s:property value="age" /></td>
						<td><s:property value="experience" /></td>
						
						
						<td><a href="bookappointment.action?doctorid=<s:property value="serialNo" />"> Check Slots</a></td>
					</tr>
	</s:iterator>
	</tbody>
</table>

</body>
<jsp:include page="Includes/Footer.jsp"></jsp:include>
</html>