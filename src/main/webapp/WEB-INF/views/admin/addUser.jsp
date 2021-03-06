<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/admin/add-user-controller" var="addUserController" />

<form:form modelAttribute="addUser" method="post" action="${addUserController}">
	<p>Name:</p><form:input path="name"/><br>
		
	<p>Phone:</p><form:input path="phone"/><br>
	
	<p>Username:</p><form:input path="username"/><br>
	
	<p>Password:</p><form:input path="password"/><br>
	
	<p>Role:</p><form:input path="role"/><br>
	
	<p>Enabled:</p><form:input path="enabled"/><br>
	
	<p>Email:</p><form:input path="email"/><br>
	
	<form:button type="submit">ADD USER</form:button>
</form:form>    
