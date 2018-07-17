<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

 <link rel="stylesheet" type="text/css" href="CSS/CustomFlatly.css">
<jsp:include page="Includes/Master.jsp"/>

</head>
<body style="background-image: url('Images/back.jpg'); background-size: 100%">
<div class="row" style="margin-left: 10px">

<div style="padding-top: 10px;" class="col"  >
<div style="max-width: 20rem;box-shadow: 10px 20px 30px black;" class="card border-primary mb-3">
<div class="card-header bg-primary" style="color: white;"><h1>Select Slots</h1></div>
  <div style="padding: 10px">
  
<s:form action="doctorupdateslot.action">
<s:checkboxlist list="listOfSlot" name="slotString" cssStyle="width:50%" ></s:checkboxlist>
<s:iterator value="list">
<input type="hidden" name="registrationNo" value='<s:property value="registrationNo"/>'>
</s:iterator>
<s:submit>
</s:submit>
</s:form>

</div>
</div>
</div>
<div class="col" style="padding-top: 50px">
<div class="card text-white bg-primary mb-3" style="max-width: 20rem;box-shadow: 10px 20px 30px black;">

  <div class="card-header"><h4>Your Slots</h4><br><h6></h6></div>
  <div class="card-body">
  
    <p class="card-text">
    <s:iterator value="doctorSlot">
	<s:property/>
	<br>
    </s:iterator>
</p>

</div>
</div>
</div>
</div>
</body>
<jsp:include page="Includes/Footer.jsp"></jsp:include>
</html>