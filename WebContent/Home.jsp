<%@page import="com.clinicmanagement.Model.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

 <link rel="stylesheet" type="text/css" href="CSS/CustomFlatly.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<jsp:include page="Includes/Master.jsp"/>
</head>
<body style="background-image: url('Images/back.jpg');background-size: 100%;">
<%
Patient uid1=null;
uid1=(Patient)session.getAttribute("patient");

%>
<div class="jumbotron" style="box-shadow: 10px 20px 30px black;background: url('Images/jumbo_large.jpg');background-size: 100%">
  <h3 style="color: #2C3E50">We Care About</h3>
  <h1 class="display-3" style="color: #2C3E50">Every Client</h1>
  <br>
  <%
  if(uid1==null){ %>
  <p class="lead">
    <a class="btn btn-primary btn-lg" href="patientloginview.action" >Please Login to Schedule Appointment</a>
  </p>
  <%}
  else{ %>
  <p class="lead">
    <a class="btn btn-primary btn-lg" href="viewappointment.action" >Schedule an Appointment for  <%=uid1.getEmailId() %></a>
  </p>
  <%} %>
</div>


<div style="padding-left: 20px;padding-right: 20px;padding-bottom: 20px;">
<div class="row">

	<div class="col" id="card1" style="padding-top: 260px;">
		<div class="card text-white bg-success mb-3" style="max-width: 20rem;" >
  				<div class="card-header"><h4>Leadership & Excellence</h4></div>
  				<div class="card-body">
    				<h4 class="card-title"></h4>
    				<p class="card-text">With a commitment to deliver the best outcome in everything we do through exemplary action and behavior.</p>
  				</div>
		</div>
	</div>
<div class="col" id="card2" style="padding-top: 260px">
		<div class="card text-white bg-warning mb-3" style="max-width: 20rem;" >
  				<div class="card-header"><h4>Integrity & Courage</h4></div>
  				<div class="card-body">
    				<h4 class="card-title"></h4>
    				<p class="card-text">Maintaining high ethical standards through putting the patient's interest ahead of the institution and demonstrating the courage to do only what is right</p>
  				</div>
		</div>		
	</div>
	<div class="col" id="card3" style="padding-top: 260px">
		<div class="card text-white bg-info mb-3" style="max-width: 20rem;" >
  				<div class="card-header"><h4>Compassion & Service</h4></div>
  				<div class="card-body">
    				<h4 class="card-title"></h4>
    				<p class="card-text">Fostering a culture where everyone of us is committed to care for patients and their care givers beyond our duty.</p>
  				</div>
		</div>		
	</div>
	<div class="col" id="card4"	style="padding-top: 260px">
		<div class="card text-white bg-secondary mb-3" style="max-width: 20rem;" >
  				<div class="card-header"><h4>Collaboration , learning & innovation</h4></div>
  				<div class="card-body">
    				<h4 class="card-title"></h4>
    				<p class="card-text">Promote team work and collaboration,welcome change and creativity to encourage innovation and seek better ways to achieve our goals.</p>
  				</div>
		</div>		
	</div>
	</div>
</div>
<script type="text/javascript">
document.getElementById("card1").style.paddingTop="100px";
var i = 260; 
var j=0;
function myLoop1 () {           
   setTimeout(function () {    
     // alert('hello');        
      i--;               
      j+=0.006;      
      if (i>=0) {            
    	  document.getElementById("card1").style.paddingTop=i+"px";
    	  document.getElementById("card1").style.opacity=j;	
    	  myLoop1();              
      }else{
    	  i = 260;
    	  j=0;
    	  myLoop2();
    	  }
                              
   }, 2);
}

myLoop1();
                     
function myLoop2() { 
	
   setTimeout(function () {    
     // alert('hello');        
      i--;                     
      j+=0.006;      
      if (i>=0) {            
    	  document.getElementById("card2").style.paddingTop=i+"px";   		
    	  document.getElementById("card2").style.opacity=j;	
    	  myLoop2();              
      }else{
    	  i = 260;
			j=0;
    	  myLoop3();
    	  }                        
   }, 5);
}

function myLoop3() { 
		j+=0.006;
	   setTimeout(function () {    
	     // alert('hello');        
	      i--;                     
	      if (i>=0) {            
	    	  document.getElementById("card3").style.paddingTop=i+"px";   		
	    	  document.getElementById("card3").style.opacity=j;	
	    	  myLoop3();              
	      }else{
	    	  i = 260;
	    	  j=0;
	    	  myLoop4();
	    	  }                        
	   }, 5);
	}
function myLoop4() { 
	
	   setTimeout(function () {    
	     // alert('hello');        
	      i--;
	      j+=0.006;                     
	      if (i>=0) {            
	    	  document.getElementById("card4").style.paddingTop=i+"px";   		
	    	  document.getElementById("card4").style.opacity=j;	
	    	  myLoop4();              
	      }                  
	   }, 5);
	}


/*
cards.style.marginTop=Max_length+"px";
int i=Max_length;
myLoop();
function myLoop () {          
	   setTimeout(function () {    
	      i--;                     
	      if (i>0) {  
	    	  cards.style.marginTop=i+"px";
							                
	         myLoop();   
	      }              
	   }, 3000);
	}*/
</script>
</body>
<jsp:include page="Includes/Footer.jsp"></jsp:include>
</html>