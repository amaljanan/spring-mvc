<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@page import="com.pits.trainingmvc.model.User"%>
<!DOCTYPE html>
<html>
<body>
	<h1 align="center">LOGIN PAGE</h1>
	<hr>

	<%
	response.setHeader("Cache-Control", "no-cache, no-store"); 
	
	response.setHeader("pragma", "no-cache");
	
	response.setHeader("Expires", "0");
	response.addHeader("Cache-Control","no-cache"); //HTTP 1.1
	response.addHeader("Pragma","no-cache"); //HTTP 1.0
	response.addDateHeader ("Expires", 0); //prevent caching at the proxy server
	
%>

	<form align="center" action="login" method="post">
		<input type="text" name="username" placeholder="username" required><br>
		<input type="password" name="password" placeholder="password" required><br>
		<input type="submit" value="Login"><br>
	</form>
	<font color="red">
		<div align="center">
			<%
			if (null != request.getAttribute("errorMessage")) {
				out.println(request.getAttribute("errorMessage"));
			}
			%>
		</div>
	</font>
</body>
</html>