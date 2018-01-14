<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Contact Form - Contact Application</title>
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
					<h3>Contact Form</h3>
					<c:if test="${err != null}">
						<p class="error">${err}</p>
					</c:if>
					<s:url var="url_csave" value="/user/save_contact" />
					<f:form action="${url_csave}" modelAttribute="command">
						<table border="1">
							<tr>
								<td>Name:</td>
								<td><f:input path="name"/></td>
							</tr>
							<tr>
								<td>Phone:</td>
								<td><f:input path="phone"/></td>
							</tr>
							<tr>
								<td>Email:</td>
								<td><f:input path="email"/></td>
							</tr>
							<tr>
								<td>Address:</td>
								<td><f:textarea path="address"/></td>
							</tr>
							<tr>
								<td>Remark:</td>
								<td><f:input path="remark"/></td>
							</tr>
							
							<tr>
								<td colspan="2" align="right"><button>Save</button><br>
								
								</td>
								
							</tr>
						</table>
					</f:form>
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