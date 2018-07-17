<%@page import="com.clinicmanagement.Utility.CheckUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="CSS/CustomFlatly.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%
String uid=null;
uid=(String)session.getAttribute("uid"); 
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="Home.jsp"><h4 style="font-size: x-large;">Dimension HealthCare</h4></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor01">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <%if(uid==null){ %>
      <!-- <li class="nav-item">
        <a class="nav-link" href="RegisterPatient.jsp">Patient Register</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="doctorfilllist.action">Doctor Register</a>
      </li> -->
      
      <li class="nav-item">
        <a class="nav-link" href="patientloginview.action">Patient</a>
      </li>
      
       <li class="nav-item">
        <a class="nav-link" href="doctorloginview.action">Doctor</a>
      </li>
      
      </ul>
      
       <%}
      else{ %>
      
    <ul class="navbar-nav mr-auto">
    <%if((CheckUser.DoctorOrPatient(uid)).equals("doctor")){ %>
    	<li>
        <a class="nav-link"  href="doctorafterlogin.action">My Account</a>
        <input type="hidden" name="registrationNo" value="<%=session.getAttribute("regno") %>>"> 
        </li>
        
        <li class="nav-item">
            <a class="nav-link" href="doctorcheckappointmentview.action?registrationNo=<%=session.getAttribute("regno") %>">Appointment</a>
          </li>
        	
    <%}else{%>
    <li>
    <a class="nav-link"  href="patientviewaccount.action">My Account</a>
    </li>
    
    <li class="nav-item">
        <a class="nav-link" href="viewappointment.action">Appointment</a>
      </li>
      <% }%>
     <li>
    <a class="nav-link"  href="Logout.action">Logout</a>
    </li>
     
    </ul>
    
    
   
  </div	>
   <form class="form-inline my-2 my-lg-0">
    <small class="form-text text-muted" style="size: 14pt;"><%=uid %></small>
    </form>
  <%} %>
</nav>

</body>
</html>
