<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME</title>
</head>
<h1 align="center">Product Registarion Page</h1>
<body>

	<%
	response.setHeader("Cache-Control", "no-cache, no-store");
	
	response.setHeader("pragma", "no-cache");
	
	response.setHeader("Expires", "0");
	response.addHeader("Cache-Control","no-cache"); //HTTP 1.1
	response.addHeader("Pragma","no-cache"); //HTTP 1.0
	response.addDateHeader ("Expires", 0); //prevent caching at the proxy server
	
	if(session.getAttribute("user")==null)
		response.sendRedirect("index.jsp"); 
%>
	<form align="left" action="login" method="get">
		<input type="submit" value="Home" />
	</form>

	<form align="center" action="product_register" method="post">
		<input type="text" name="product_name" placeholder="name" required><br>
		<input type="text" name="price" placeholder="price" required><br>
		<input type="text" name="department" placeholder="department" required><br>
		<input align="center" type="submit" value="Create Product"><br>

	</form>

	<form align="center" action="logout" method="get">
		<input type="submit" value="Logout" />
	</form>
</body>
</html>