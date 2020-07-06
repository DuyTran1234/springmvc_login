<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>

<c:url value="/user/update-email-controller" var="updateEmailController" />
<form action="${updateEmailController}" method="post">
	<input name="code">
	<br><br>
	<button type="submit">Confirm Email</button>
</form>