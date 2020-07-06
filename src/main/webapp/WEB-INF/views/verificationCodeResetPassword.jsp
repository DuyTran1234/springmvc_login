<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>

<p>Enter the verification code:</p>

<c:url value="/confirm-code-reset" var="confirmCodeResetUrl" />
<form action="${confirmCodeResetUrl}" method="post">
	<input name="code">
	<button type="submit">Continue</button>
</form>

<p>${msgVerificationCode}</p>

<a href="<c:url value='/lay-mat-khau' />">Didn't get a code?</a>
