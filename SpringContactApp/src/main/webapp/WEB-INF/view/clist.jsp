<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact List - Contact Application </title>
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
				<h3>Contact List</h3>
				<c:if test="${param.act eq 'sv'}">
					<p class="success">Contact Saved Successfully.</p>
				</c:if>
				<c:if test="${param.act eq 'del'}">
					<p class="success">Contact Deleted Successfully.</p>
				</c:if>
				<table width="100%">
					<tr>
						<td align="right">
							<form action="<s:url value="/user/contact_search"/>">
								<input type="text" name="freeText" value="${param.freeText}" placeholder="Enter Text to Search">
								<button>Find</button>
							</form>
						</td>
					</tr>
				</table>
				<form action="<s:url value="/user/bulk_cdelete"/>">
					<button style="width: 20 px; height: 20px; text-align: center; color:green;">Delete Selected Records</button>
					 <br/>
					<table BORDER="1" cellpadding="3">
						<tr>
							<th>SNO</th>
							<th>C.ID</th>
							<th>NAME</th>
							<th>PHONE</th>
							<th>EMAIL</th>
							<th>ADDRESS</th>
							<th>REMARK</th>
							<th>ACTION</th>
						</tr>
						<c:if test="${empty contactList}">
							<tr>
								<td align="center" colspan="8" class="error">No records found!</td>
							</tr>
						</c:if>
						<c:forEach var="c" items="${contactList}" varStatus="st">
							<tr>
								<td align="center"><input type="checkbox" name="cId" value="${c.contactId}"></td>
								<td>${c.contactId}</td>
								<td>${c.name}</td>
								<td>${c.phone}</td>
								<td>${c.email}</td>
								<td>${c.address}</td>
								<td>${c.remark}</td>
								<s:url var="url_del" value="/user/del_contact">
									<s:param name="cId" value="${c.contactId}"/>
								</s:url>
								<s:url var="url_edit" value="/user/edit_contact">
									<s:param name="cId" value="${c.contactId}"/>
								</s:url>
								<td><a href="${url_edit}">Edit </a>| <a href="${url_del}">Delete</a></td>
						</tr>
						</c:forEach>
					</table>
				</form>
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