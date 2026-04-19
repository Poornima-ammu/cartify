<%@ page import ="java.util.*,model.Product" %>
<% List<Product> list=(List<Product>)request.getAttribute("products");
%>
	<%
	for(Product p:list){
	%>
<div style="border:1px solid black;margin:10px;padding:10px;">
<h3><%= p.getProductName() %></h3>
<p>Price:<%= p.getPrice() %></p>
<p>Quantity:<%= p.getQuantity() %></p>
<p>Brand:<%= p.getBrand() %></p>
<p>Description:<%= p.getDescription() %></p>
</div>
<form action="<%=request.getContextPath() %>/addToCart" method="post">
<input type="hidden" name="productId" value="<%=p.getProductId() %>">
<input type="submit" value="Add to Cart">
</form>
<% } %>
