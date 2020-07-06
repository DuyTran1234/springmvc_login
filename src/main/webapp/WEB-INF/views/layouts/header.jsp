<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>

<h1>Header content</h1>
	<security:authorize access="true">
		<a href="<c:url value='/xem-gio-hang'/>">Cart</a>
	</security:authorize>
	<h3><a href="<c:url value='/trang-chu' />">Home</a></h3>
	<security:authorize access="!isAuthenticated()">
		<c:url value="/dang-nhap" var="loginUrl" />
		<form action="${loginUrl}" method="get">
			<button type="submit">Login</button>
		</form>
		<br>
		<c:url value="/dang-ky" var="registerUrl" />
		<form action="${registerUrl}" method="post">
			<button type="submit">Register</button>
		</form>
	</security:authorize>
	
	<security:authorize access="isAuthenticated()">
		Welcome, <security:authentication property="name"/>
		<c:url value="/dang-xuat" var="logout" />
		<form action="${logout}" method="post">
			<button type="submit">Logout</button>
		</form>
	</security:authorize>

<hr>