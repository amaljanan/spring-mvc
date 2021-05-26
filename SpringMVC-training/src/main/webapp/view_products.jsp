<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page </title>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store"); 
	

	response.setHeader("pragma", "no-cache");
	
	response.setHeader("Expires", "0");
	response.addHeader("Cache-Control","no-cache"); //HTTP 1.1
	response.addHeader("Pragma","no-cache"); //HTTP 1.0
	response.addDateHeader ("Expires", 0); //prevent caching at the proxy server
	
	if(session.getAttribute("username")==null)
		response.sendRedirect("index.jsp");
%>
<h2 align = "center" > Product Page</h2>
<table border="1" align = "center">
			
			<tr>
				<th>Product_Name</th>
				<th>Price</th>
			</tr>
			
			<c:forEach items="${plist}" var="product">
			
				<tr>
					<td>${product.product_name}</td>
					<td>${product.price}</td>
				</tr>
				
			</c:forEach>
			
		</table>


<form align="center" action="logout">
    <input type="submit" value="Logout"/>
</form>
</body>
</html>