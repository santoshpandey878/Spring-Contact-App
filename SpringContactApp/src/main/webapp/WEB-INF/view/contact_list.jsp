<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Contact List - Contact Application</title>
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
					<h3>Contact List</h3>
					<c:if test="${param.act eq 'sv'}">
						<p class="success">Contact Saved Successfully.</p>
					</c:if>
					<c:if test="${param.act eq 'ed'}">
						<p class="success">Contact Updated Successfully.</p>
					</c:if>
					<c:if test="${param.act eq 'del'}">
						<p class="success">Contact Deleted Successfully.</p>
					</c:if>
					
					<table width="100%">
						<tr> 
							<td align="right">
								<form action="<s:url value="/user/contact_search" />">
									<input type="text" name="freeText" value="${param.freeText}" placeholder="Enter Text To Search">
									<button>Find</button>
								</form>
						</td>
						</tr>
					</table>
					
					<form action="<s:url value="/user/bulk_cdelete" />">
						<button>Delete Selected Records</button><br/><br/>
						<table border="1" cellpadding="3">
							<tr>
								<th>SELECT</th>
								<th>SR</th>
								<th>CID</th>
								<th>NAME</th>
								<th>PHONE</th>
								<th>EMAIL</th>
								<th>ADDRESS</th>
								<th>REMARK</th>
								<th>ACTION</th>
							</tr>
							<c:if test="${empty contactList}">
								<tr>
									<td colspan="8" class="error" align="center">No Records Present</td>
								</tr>
							</c:if>
							<c:forEach var="c" items="${contactList}" varStatus="st">
								<tr>
									<td align="center"><input type="checkbox" name="cid" value="${c.contactId}" /></td>
									<td>${st.count}</td>
									<td>${c.contactId}</td>
									<td>${c.name}</td>
									<td>${c.phone}</td>
									<td>${c.email}</td>
									<td>${c.address}</td>
									<td>${c.remark}</td>
									<s:url var="url_upd" value="/user/upd_contact">
										<s:param name="cid" value="${c.contactId}"></s:param>
									</s:url>
									<s:url var="url_del" value="/user/del_contact">
										<s:param name="cid" value="${c.contactId}"></s:param>
									</s:url>
									<td><a href="${url_upd}">Edit</a> | <a href="${url_del}">Delete</a></td>
								</tr>
							</c:forEach>
						</table>
					</form>
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