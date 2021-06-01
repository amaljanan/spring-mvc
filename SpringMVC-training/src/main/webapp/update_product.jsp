<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME</title>
</head>
<h1 align="center">Update Product ${productName}</h1>
<body>

	<%
	response.setHeader("Cache-Control", "no-cache, no-store");
	
	response.setHeader("pragma", "no-cache");
	
	response.setHeader("Expires", "0");
	
	if(session.getAttribute("user")==null)
		response.sendRedirect("index.jsp"); 
%>
	<form align="left" action="login" method="get">
		<input type="submit" value="Home" />
	</form>

	<form align="center" action="update_product" method="post">
		<input type="text" name="price" placeholder="price" required><br>
		<input type="text" name="stocksAvailable" placeholder="stock_available" required><br>
		<input type="hidden" name="productName" value="${productName}" />
		<input align="center" type="submit" value="Update Product"><br>

	</form>

	<form align="center" action="logout" method="get">
		<input type="submit" value="Logout" />
	</form>
</body>
</html>