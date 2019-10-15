<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard - Contact Application </title>
<link href="../static/css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body background="../static/images/my_bg_img.jpg">
	<table border="1" width="80%" align="center">
		<tr>
			<td height="100px">	
				<%-- Header --%>
				<jsp:include page="include/header.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td height="25px">	
				<%-- Menu --%>
				<jsp:include page="include/menu.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td height="350px" valign="top">	
				<%-- Page Content --%>
				<h1>Admin Dashboard</h1>
				TODO - Admin option in this page
			</td>
		</tr>
		<tr>
			<td height="25px">	
				<%-- Footer  --%>
				<jsp:include page="include/footer.jsp"></jsp:include>
			</td>
		</tr>
	
	</table>
</body>
</html>