<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Registration</title>
<link href="<c:url value="resources/CSS/styles.css" /> " rel="stylesheet" >
<script type="text/javascript" src="<c:url value="resources/js/registerValid.js" />"></script>
</head>
<body>

<div class="topbar">
    <h1>REGISTERATION</h1>
</div>

<form name="registerForm" modelAttribute="user" action="registerProcess" onsubmit="return validateform()" method="post">
Username: <input type="text" name="username"/><br/><br/>
E-mail: <input type="email" name="email"/><br/><br/>
Password: <input type="password" name="password"/><br/><br/>
Phone: <input type="phone" name="phone"/><br/><br/>
<center>
<button type="submit" value="register" class="form-button">Register</button>
</center>
</form>
</body>
</html>