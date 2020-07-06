<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>

<h3>Reset Password</h3>
<p>Enter email:</p>
<c:url value="/send-email-password" var="forgetPasswordController" />
<form action="${forgetPasswordController}" method="post">
	<input name="email" value="${userResetPassword.email}">
	<button type="submit">Continue</button>
</form>
<br>
<p>${msgForgetPassword}</p>