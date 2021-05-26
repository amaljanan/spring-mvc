<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME</title>
</head>
<h1 align="center">User Registarion Page</h1>
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

	<form align="center" action="create_user" method="post">
		<input type="text" name="username" placeholder="username" required><br>
		<input type="password" name="password" placeholder="password" required><br>
		<INPUT TYPE="radio" NAME="radios" VALUE="1"> Admin User <BR>
		<INPUT align="center" TYPE="radio" NAME="radios" VALUE="0" CHECKED>
		Normal User <BR> <input align="center" type="submit"
			value="Create User"><br>

	</form>

	<form align="center" action="logout" method="get">
		<input type="submit" value="Logout" />
	</form>
</body>
</html>