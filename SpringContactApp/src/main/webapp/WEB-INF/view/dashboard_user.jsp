<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Dashboard - Contact Application</title>
		<s:url var="url_css" value="/resources/css/style.css" />
		<link href="${url_css}" rel="stylesheet" type="text/css" />
	</head>
	<s:url var="url_bg" value="/resources/images/bg.jpg" />
	<body background="${url_bg}">
		<table border="1" width="80%" align="center">
			<tr>
				<td height="80px">
				<!-- Header -->
					<jsp:include page="include/header.jsp"></jsp:include>
				</td>
			</tr>
			<tr>
				<td height="25px">
				<!-- Menu -->
					<jsp:include page="include/menu.jsp"></jsp:include>
				</td>
			</tr>
			<tr>
				<td height="350px" valign="top">
				<!-- Page Content Area -->
					<h1>User Dashboard</h1>
				</td>
			</tr>
			<tr>
				<td height="25px">
				<!-- footer -->
					<jsp:include page="include/footer.jsp"></jsp:include>
				</td>
			</tr>
		</table>
	</body>
</html>