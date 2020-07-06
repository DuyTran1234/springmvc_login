<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<h1>Register</h1>
<c:url value="/register-controller" var="registerController" />
<form:form modelAttribute="registerUser" action="${registerController}" method="post">
	<p>(*)Name:</p>
	<form:input path="name"/><br>
	<form:errors path="name" />
	
	<p>(*)Email:</p>
	<form:input path="email"/><br>
	<form:errors path="email" />
	
	<p>Phone:</p>
	<form:input path="phone"/><br>
	
	<p>(*)Username:</p>
	<form:input path="username"/><br>
	<form:errors path="username" />
	
	<p>(*)Password:</p>
	<form:input path="password"/><br>
	<form:errors path="password" />
	
	<br>
	<form:button type="submit">Register</form:button>
</form:form>