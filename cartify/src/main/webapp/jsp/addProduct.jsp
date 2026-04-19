<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% model.User user=(model.User)session.getAttribute("user");
 	if(user==null || !user.getRole().equals("admin")){
 		response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
 		return;
 	}
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>
<form action="<%= request.getContextPath()%>/addProduct" method="post">

<label>Product Name:</label>
<input type="text" name="productName" placeholder="Enter Product Name" required>
<br>
<br>

<label>Price:</label>
<input type="number" name="price" placeholder="Enter Price" step="0.01" >
<br><br>

<label>Quantity</label>
<input type="number"  name="quantity" placeholder="Enter Quantity">
<br><br>

<label>Image URL:</label>
<input type="text" name="image" placeholder="Enter Image Path ">
<br><br>

<label>Brand:</label>
<input type="text" name="brand" placeholder="Enter brand">
<br><br>

<label>Description:</label>
<textarea name="description" placeholder="Enter description"></textarea>
<br><br>

<input type="submit" value="Add Product">

</form>

</body>
</html>