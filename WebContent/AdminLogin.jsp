<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
<jsp:include page="Includes/Master.jsp"/>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<body style="background-image: url('Images/back.jpg');background-size: 100%">
<div align="center">
<div class="card border-success mb-3" style="max-width: 20rem;">
  <div class="card-header" style="color:green">Admin-Login</div>
  <div class="card-body text-success">
    <h4 class="card-title"></h4>
    <p class="card-text"><s:form action="adminlogin.action">
<s:textfield name="username" label="User Name"></s:textfield>
<s:password name="password" label="password"></s:password>
<br>
<s:submit ></s:submit>
</s:form></p>
  </div>
</div>
</div>
</body>
<jsp:include page="Includes/Footer.jsp"></jsp:include>
</html>