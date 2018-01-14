<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User List - Contact Application</title>
		<s:url var="url_css" value="/resources/css/style.css" />
		<link href="${url_css}" rel="stylesheet" type="text/css" />
		<s:url var="url_jqlib" value="/resources/js/jquery-3.2.1.min.js" />
		<script src="${url_jqlib}"></script>
		<script>
			function changeStatus(uid, lStatus){
				//alert(userId+ " "+loginStatus);
				$.ajax({
					url : 'change_status',
					data : {userId:uid, loginStatus:lStatus},
					success : function(data){
						alert(data);
					}
				});
			}
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
					<h3>User List</h3>
					
					<table border="1">
						<tr>
							<th>SR</th>
							<th>USER ID</th>
							<th>NAME</th>
							<th>PHONE</th>
							<th>EMAIL</th>
							<th>ADDRESS</th>
							<th>USERNAME</th>
							<th>STATUS</th>
						</tr>
						<c:forEach var="u" items="${users}" varStatus="st">
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
										$("#id_${u.userId}").val('${u.loginStatus}');
									</script>
									
								</td>
							</tr>
						</c:forEach>
					</table>
					
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