<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Your Details</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<body style="background-image: url('Images/back.jpg');background-size: 100%">


<jsp:include page="Includes/Master.jsp"/>

<div align="center" style="padding-top: 50px;" class="col"  >
<div style="max-width: 30rem;box-shadow: 10px 20px 30px black;" class="card border-primary mb-3">
<div class="card-header bg-primary" style="color: white;"><h1>Register</h1></div>
  <div style="padding: 10px">


<s:iterator  value="list">


<s:form action="updatedoctor.action">

<div class="form-group">
      <label >Registration Number</label>
     
          <input  name="registrationNo" value='<s:property value="registrationNo"/>' readonly="readonly" />
</div>
<div class="form-group">
      <label>FirstName</label>
     
          <input  name="firstName" value= "<s:property value="firstName"/>"/>
</div>
<div class="form-group">
      <label >Middle Name</label>
     
          <input  name="middleName" value="<s:property value="middleName"/>"  />
  </div>
  <div class="form-group">
      <label >Last Name</label>
     
          <input  name="lastName" value="<s:property value="lastName"/>" />
          </div>
          <div class="form-group">
      <label >Contact</label>
     
           <input  name="contact" value="<s:property value="contact"/>" type="number" maxLength="10"  required="true"/>
        </div>
       <div class="form-group">
      <label>Address</label>
        
           <input  name="address" value="<s:property value="address"/>" required="true"/>
</div>
<div class="form-group">
      <label>Age</label>
     
          <input name="age" value="<s:property value="age"/>" type="number" maxLength="3" required="true" />
     </div>
    
          <s:radio type="radio" name="gender" label="Gender" list="{'Male','Female'}"   required="true"/>
      
         <div class="form-group">
      <label>Email address</label>
      <input type="email"  id="emailId" aria-describedby="emailHelp" placeholder="Enter email" name="emailId" value="<s:property value="emailId"/>">
          </div>
          <div class="form-group">
      <label>Certificate</label>
     
          <input  name="certificate" value="" />
          </div>
          
          <s:select list="{'Gynecologist','Orthopedic','Neurologist','GeneralPhysician'}" name="specialty" label="Specialty"></s:select>
<div class="form-group">
      <label >Fees</label>
     
          <input name="fees" value="<s:property value="fees"/>" type="number" maxLength="4"  />
          </div>
          <div class="form-group">
      <label>Experience</label>
     
           <input name="experience" value="<s:property value="experience"/>" type="number" maxLength="3" />
         </div>
         <div class="form-group">
      <label>Clinic Rent</label>
      
          <input name="rent" value="<s:property value="rent"/>"  maxLength="4" />
     </div>
          <s:submit value="Update" align="center" />
    </s:form>     
</s:iterator>
 
</div>
</div>
</div>
</body>
<jsp:include page="Includes/Footer.jsp"></jsp:include>
</html>