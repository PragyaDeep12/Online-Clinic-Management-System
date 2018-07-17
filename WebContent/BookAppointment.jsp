<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="CSS/CustomFlatly.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Slots</title>
<jsp:include page="Includes/Master.jsp"/>
</head>
<body style="background-image: url('Images/back.jpg');background-size: 100%">
<div class="row">
<div align="left" style="padding-top: 30px;padding-left: 50px" class="col"  >
<div style="max-width: 20rem;" class="card border-primary mb-3">
<div class="card-header bg-primary" style="color: white;"><h5>Select Slots</h5></div>
  <div style="padding: 10px">
<s:form action="checkslots.action">
<s:textfield name="doctorid" hidden="true"></s:textfield>
<s:textfield type="date" name="dtaval" id="dateid" required="true" cssClass="form-control" />
<s:submit value="Check Slots" cssClass="btn btn-success"></s:submit>
</s:form>
</div>
</div>
</div>
</div>
<div style="padding-left: 35px">
<table class="table table-hover" style="background-color: white;padding-left: 10px;padding-right: 10px;width: 40%" >
	<thead style="background-color: #2C3E50">
	<tr>
	<th style="color: white;">Slots</th>
	<th style="color: white;">Appointment</th>
	</tr>
	</thead>
	<tbody>
	<s:iterator value="list_slot">
		<tr>
						<td><s:property/></td>
						<td><a href="confirmappointment.action?doctid=<s:property value="doctorid"/>&date=<s:property value="dtaval"/>&slot=<s:property/>"> Book Appointment</a></td>
		</tr>
	</s:iterator>
	</tbody>
</table>
</div>
<script type="text/javascript">
var today = new Date();
var onmonth=new Date();
var dd = today.getDate();
var mm = today.getMonth()+1; //January is 0!
var yyyy = today.getFullYear();
if(dd<10){
    dd='0'+dd
} 
if(mm<10){
    mm='0'+mm
} 

today = yyyy+'-'+mm+'-'+dd;

if((mm+1)>12){
	mm=mm-12;
	yyyy=yyyy+1;
	onmonth=yyyy+"-"+mm+"-"+dd;
	if(dd<10){
	    dd='0'+dd
	} 
	if(mm<10){
	    mm='0'+mm
	}
}else{
	
	mm=parseInt(mm)+1;
	if(dd<10){
	    dd='0'+dd
	} 
	if(mm<10){
	    mm='0'+mm
	}
	onmonth=yyyy+"-"+mm+"-"+dd;
}
 

alert(onmonth);
document.getElementById("dateid").setAttribute("min", today);
document.getElementById("dateid").setAttribute("max", onmonth);


</script>
<!-- 2018-01-10 -->
</body>
<jsp:include page="Includes/Footer.jsp"></jsp:include>
</html>