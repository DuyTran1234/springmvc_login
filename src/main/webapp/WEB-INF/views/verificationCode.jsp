<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>
<p>sent to email: </p>
<p>${email}</p>
<p>Enter code:</p>
<c:url value="/verification-code-controller" var="verificationCodeController" />
<form action="${verificationCodeController}" method="post">
	<input name="emailVerification" value="${email}" hidden="true">
	<input name="verification-code">
	<button type="submit">Confirm</button>
</form>
<p>${msgConfirm}</p>
<br><br>

<p>Didn't receive the mail?</p>

<c:url value="/send-email" var="confirmEmailController" />
<form action="${confirmEmailController}" method="post">
	<input name="email" value="${email}">
	<button type="submit">Send Again</button>
</form>