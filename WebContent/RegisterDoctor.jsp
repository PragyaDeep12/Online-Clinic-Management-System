<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="CSS/CustomFlatly.css">
</head>

<body style="background-image: url('Images/back.jpg');background-size: 100%">
<jsp:include page="Includes/Master.jsp"/>

<div align="center" style="padding-top: 50px;width: 70%;padding-left: 30%" class="col"  >
<div style="max-width: 100rem;box-shadow: 10px 20px 30px black;" class="card border-primary mb-3">
<div class="card-header bg-primary" style="color: white;"><h1>Register</h1></div>
  <div style="padding: 10px">

<s:form action="registerdoctor.action" align="left">

          <s:textfield label="REGISTRATION NUMBER" name="RegistrationNo" required="true"  />

          <s:textfield label="FIRST NAME" name="firstName" value="" required="true"/>

          <s:textfield label="MIDDLE NAME" name="middleName" value=""  />
  
          <s:textfield label="LAST NAME" name="lastName" value="" />
          
           <s:textfield label="CONTACT" name="contact" value="" type="number" maxLength="10"  required="true"/>
           
           <s:textarea label="ADDRESS" name="address" value="" required="true"/>

          <s:textfield label="AGE" name="age" value="" type="number" maxLength="3" required="true" />
          
          <s:radio label="GENDER" name="gender"  list="{'Male','Female'}" value=""  required="true"/>
          
          <s:textfield label="EMAIL ID" name="emailId" value="" type="email" required="true"/>
    
          
          <s:textfield label="QUALIFICATION" name="certificate" value="" />
          
          <s:select list="list_types" name="specialty" label="SPECIALITY"></s:select>
		  
		  <s:checkboxlist list="slot" cssStyle="width: 50%" name="slotString" label="SLOT"></s:checkboxlist>
				
          <s:textfield label="FEES" name="fees" value="" type="number" maxLength="4" required="true" />
          
          <s:password label="PASSWORD" name="password" value="" required="true" />
          
          <s:textfield label="EXPERIENCE(NUMBER OF YEARS)" name="experience" value="" type="number" maxLength="3" required="true"/>
          
          <s:textfield label="RENT" name="rent" value="" type="number" maxLength="4" required="true"/>
     
          <s:submit value="Resgister" align="center" />

</s:form>
</div>
</div>
</div>
</body>
<jsp:include page="Includes/Footer.jsp"></jsp:include>
</html>