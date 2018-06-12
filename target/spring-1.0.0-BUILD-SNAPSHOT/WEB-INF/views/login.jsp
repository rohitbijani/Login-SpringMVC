<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Registration</title>
<link rel="stylesheet" href="<c:url value="resources/CSS/styles.css" />">
<script type="text/javascript" src="<c:url value="resources/js/loginValid.js" />"></script>

</head>
<body>

<div class="topbar">
    <h1>LOGIN</h1>
</div>
<form name="loginForm" action="loginProcess" method="post" onsubmit="return validateform()">
Username: <input type="text" name="uname"/><br/><br/>
Password: <input type="password" name="pwd"/><br/><br/>
<button type="submit" class="form-button">Login</button>
<a href="registration.jsp"><i>Register</i></a>
</form>	
</body>
</html>