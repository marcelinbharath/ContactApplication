<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>User List - Contact Application</title>
		<link href="../static/css/style.css" rel="stylesheet" type="text/css" />
		<s:url var="url_jqlib" value="../static/js/jquery-3.4.1.min.js" />
		<script src="${url_jqlib}"></script>
		<script>
			function changeStatus(uId, lStatus){
				//alert(userId+"    ,"+loginStatus);
				$.ajax({
					url:'change_status',
					data:{userId:uId, loginStatus:lStatus},
					success: function(data){
						alert(data);
					}
				});
			}
		</script>
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
				<h3>User List</h3>
				<table BORDER="1" cellpadding="3">
						<tr>
							<th>SR</th>
							<th>USER ID</th>
							<th>NAME</th>
							<th>PHONE</th>
							<th>EMAIL</th>
							<th>ADDRESS</th>
							<th>USERNAME</th>
							<th>LOGIN STATUS</th>
						</tr>
						<c:forEach var="u" items="${userList}" varStatus="st">
							<tr>
								<td>${st.count}</td>
								<td>${u.userId}</td>
								<td>${u.name}</td>
								<td>${u.phone}</td>
								<td>${u.email}</td>
								<td>${u.address}</td>
								<td>${u.loginName}</td>
								<td>
									<select id="id_${u.userId}" onchange="changeStatus(${u.userId}, $(this).val())">
										<option value="1">Active</option>
										<option value="2">Block</option>
									</select>
									<script>
										$('#id_${u.userId}').val(${u.loginStatus});
									</script>
								</td>
						</tr>
						</c:forEach>
					</table>
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