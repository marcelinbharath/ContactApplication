<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login - Contact Application </title>
<link href="static/css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body background="static/images/my_bg_img.jpg">
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
				<h3>User Login</h3>
				<c:if test="${err!=null}">
					<p style="color:red;">${err}</p>
				</c:if>
				<c:if test="${param.act eq 'lo'}">
					<p class="success">Logout Successfully! Thanks for using Contact Application.</p>
				</c:if>
				<c:if test="${param.act eq 'reg'}">
					<p class="success">User Registered Successfully! Please Login.</p>
				</c:if>
				<f:form action="login" modelAttribute="command">
					<table border="1">
						<tr>
							<td>Username</td>
							<td><f:input path="loginName"/></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><f:password path="password"/></td>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<button>Login</button>
								<br />
								<a href="#">New User Registration</a>
							</td>
						</tr>
					</table>
				</f:form>
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