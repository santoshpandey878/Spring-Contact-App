<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<s:url var="url_logout" value="/logout" />

<c:if test="${sessionScope.userId == null}">
	<%-- User is not yet logged in : Guest Menu --%>
	<s:url var="url_reg_form" value="/reg_form" />
	<s:url var="url_login_form" value="/index" />
	<a href="${url_login_form}">Home</a> | <a href="${url_login_form}">Login</a> | <a href="${url_reg_form}">Register</a> | <a href="#">About</a>
</c:if>
<c:if test="${sessionScope.userId != null && sessionScope.role == 1}">
	<%-- Admin is logged in : Admin Menu --%>
	<s:url var="url_ausers" value="/admin/users" />
	<s:url var="url_ahome" value="/admin/dashboard" />
	<a href="${url_ahome}">Home</a> | <a href="${url_ausers}">User List</a> | <a href="${url_logout}">Logout</a>
</c:if>
<c:if test="${sessionScope.userId != null && sessionScope.role == 2}">
	<%-- General User is logged in : User Menu --%>
	<s:url var="url_uhome" value="/user/dashboard" />
	<s:url var="url_cform" value="/user/contact_form" />
	<s:url var="url_clist" value="/user/contact_list" />
	<a href="${url_uhome}">Home</a> | <a href="${url_cform}">Add Contact</a> | <a href="${url_clist}">Contact List</a> | <a href="${url_logout}">Logout</a>
</c:if>