<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME</title>
<script type="text/javascript">
function toggleSelect(id)
{
	
    if (id == '0')
    {
          document.getElementById('Admin').style['display'] = 'none';
          document.getElementById('Normal').style['display'] = 'block';
    }

    if (id == '1')
    {
          document.getElementById('Normal').style['display'] = 'none';
          document.getElementById('Admin').style['display'] = 'block';
    }
}
</script>

</head>
<h1 align="center">User Registarion Page ${username}</h1>
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

	<form align="center" action="create_user" method="post">
		<input type="text" name="username" placeholder="username" required><br>
		<input type="password" name="password" placeholder="password" required><br>
		<INPUT TYPE="radio" NAME="radios" VALUE='1' onclick="toggleSelect('1');"> Admin User <BR>
		<INPUT TYPE="radio" NAME="radios" VALUE='0'  onclick="toggleSelect('0');" checked='1'> Normal User <BR>
<div align="center">	
	<select name="departmentN" id='Normal'>
    <c:forEach items="${dlist}" var="department">
        <option value="${department}">${department}</option>
    </c:forEach>
	</select>	
</div>	
<div align="center">
	<select name="departmentA" id='Admin' style='display: none;' >
        <option value="all">All</option>
	</select>	
</div>		
		 <input align="center" type="submit"
			value="Create User"><br>
	
	</form>

	<form align="center" action="logout" method="get">
		<input type="submit" value="Logout" />
	</form>
	

</body>
</html>