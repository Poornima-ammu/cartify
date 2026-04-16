<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cartify-login</title>
</head>
<body>
<h2>Login</h2>
<form action="<%= request.getContextPath() %>/login" method="post">
<label>Email:</label>
<input type="email" name="email" placeholder="Enter Your Email" required>
<label>Password:</label>
<input type="password" name="password" placeholder="Enter Your Password" required>
<input type="submit" name="Login">


</form>

</body>
</html>