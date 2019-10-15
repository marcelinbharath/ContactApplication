<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>   
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Form - Contact Application </title>
<link href="/static/css/style.css" rel="stylesheet" type="text/css"/>
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
				<h3>Contact Form</h3>
				<c:if test="${err!=null}">
					<p style="color:red;">${err}</p>
				</c:if>
				<s:url var="url_csave" value="/user/save_contact"/>
				<f:form action="${url_csave}" modelAttribute="command">
					<table border="1">
						<tr>
							<td>Name</td>
							<td><f:input path="name"/></td>
						</tr>
						<tr>
							<td>Phone</td>
							<td><f:input path="phone"/></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><f:input path="email"/></td>
						</tr>
						<tr>
							<td>Address</td>
							<td><f:textarea path="address"/></td>
						</tr>
						<tr>
							<td>Remark</td>
							<td><f:textarea path="remark"/></td>
						</tr>
						<tr>						
							<td colspan="2" align="right">
								<button>Save</button>
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