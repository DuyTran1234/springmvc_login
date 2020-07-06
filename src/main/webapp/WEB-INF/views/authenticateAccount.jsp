<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>
<p>Confirm Email:</p>

<c:url value="/send-email" var="confirmEmailController" />
<form action="${confirmEmailController}" method="post">
	<input name="email" value="${emailConfirm}">
	<button type="submit">Confirm</button>
</form>

<p>${msgAuthenticate}</p>