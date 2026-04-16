<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cartify - Register</title>
</head>
<body>
<h2>Register</h2>
<form action="<%= request.getContextPath() %>/register" method="post">
Name:<input type="text" name="name" required ><br>
Email:<input type="text" name="email" required ><br>
Password:<input type="text" name="password" required><br>
<input type="submit" value="Register">

</form>

</body>
</html>