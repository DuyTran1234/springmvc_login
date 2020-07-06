<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>

<h3>Menu</h3>
	<security:authorize access="hasRole('ADMIN')">
		<a href="<c:url value='/admin/them-nguoi-dung'/>">Add User</a><br>
		<a href="<c:url value='/admin/danh-sach-nguoi-dung'/>">List User</a><br>
		<a href="<c:url value='/admin/danh-sach-san-pham' />">List Product</a><br>
	</security:authorize>
	
	<security:authorize access="hasAnyRole('ADMIN', 'USER')">
		<a href="<c:url value='/user/profile' />">User Profile</a><br>
	</security:authorize>
	
	<security:authorize access="true">
		<a href="<c:url value='/xem-san-pham' />">View products</a>
	</security:authorize>
<hr>