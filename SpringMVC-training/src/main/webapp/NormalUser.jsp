<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME</title>
</head>
<h1 align="center">WELCOME ${username}</h1>
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
<div align="center">
Login successfull

</div>
<div align="center">
		<p>
			Click <a href="view_products"> here </a> to view Products.
		</p>
</div>
<form align="center" action="logout">
    <input type="submit" value="Logout"/>
</form>

</body>
</html>