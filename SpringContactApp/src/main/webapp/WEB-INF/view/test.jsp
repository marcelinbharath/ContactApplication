<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<s:url var="url_jqlib" value="../static/js/jquery-3.4.1.min.js"/>
<script src="${url_jqlib}"></script>
	<script>
		$(document).ready(function(){
			$("#id_get_time").click(function(){
				$.ajax({
					url: 'get_time',
					success : function(data){
						$("#id_time").html(data);
					}
				});
			});
		});
	</script>
<title>JSP Page</title>
</head>
<body>
	<h1>Ajax test page</h1>
	<button id="id_get_time">Get Server Time</button>
	<p id="id_time"></p>
</body>
</html>