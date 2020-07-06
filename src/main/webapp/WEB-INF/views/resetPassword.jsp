<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>

<c:url value="/reset-password-controller" var="resetPasswordController" />
<form action="${resetPasswordController}" method="post">
	<p>New Password:</p>
	<input name="new-password" >
	<button type="submit">OK</button>
</form>