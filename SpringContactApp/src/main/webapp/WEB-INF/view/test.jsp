<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<s:url var="url_jqlib" value="/resources/js/jquery-3.2.1.min.js" />
	<script src="${url_jqlib}"></script>
	<script>
		$(document).ready(function(){
			//alert('jquery is ready');
			$("#id_get_time").click(function(){
				//alert('hi');
				$.ajax({
					url : 'get_time',
					success : function(data){
						$("#id_time").html(data);
					}
				});
			});
		});
	</script>
	<title>jsp page</title>
</head>
<body>
	<h1>Ajax test</h1>
	<button id="id_get_time">Get Server Time</button><br/>
	<p id="id_time"></p>
</body>
</html>