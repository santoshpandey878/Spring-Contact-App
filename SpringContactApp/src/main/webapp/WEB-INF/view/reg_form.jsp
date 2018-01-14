<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Registration - Contact Application</title>
		<s:url var="url_css" value="/resources/css/style.css" />
		<link href="${url_css}" rel="stylesheet" type="text/css" />
		<s:url var="url_jqlib" value="/resources/js/jquery-3.2.1.min.js" />
		<script src="${url_jqlib}"></script>
		<script>
			$(document).ready(function(){
				//alert('jquery is ready');
				$("#id_check_avail").click(function(){
					//alert('hi');
					$.ajax({
						url : 'check_avail',
						data : {username:$("#id_username").val()},
						success : function(data){
							$("#id_res_div").html(data);
						}
					});
				});
			});
		</script>
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
					<h3>User Registration</h3>
					<c:if test="${err != null}">
						<p class="error">${err}</p>
					</c:if>
					
					<f:form action="register" modelAttribute="command">
						<table border="1">
							<tr>
								<td>Name:</td>
								<td><f:input path="user.name"/></td>
							</tr>
							<tr>
								<td>Phone:</td>
								<td><f:input path="user.phone"/></td>
							</tr>
							<tr>
								<td>Email:</td>
								<td><f:input path="user.email"/></td>
							</tr>
							<tr>
								<td>Address:</td>
								<td><f:textarea path="user.address"/></td>
							</tr>
							<tr>
								<td>Username:</td>
								<td><f:input id="id_username" path="user.loginName"/>
									<button type="button" id="id_check_avail">Check Availability</button>
									<div id="id_res_div" class="error"></div>
								</td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><f:password path="user.password"/></td>
							</tr>
							<tr>
								<td colspan="2" align="right"><button>Submit</button><br>
								
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