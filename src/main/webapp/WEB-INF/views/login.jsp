<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>

<c:url value="/dang-nhap" var="loginController" />
    
<form action="${loginController}" method="post">
	<input name="username" placeholder="Username">
	<input name="password" type="password" placeholder="Password">
	<button type="submit">Login</button>
</form>
<br>

<a href="<c:url value='/xac-thuc' />">Confirm email?</a>
<br>
<a href="<c:url value='/lay-mat-khau' />">Forget Password?</a>

<%=request.getAttribute("errorsLogin")!=null?request.getAttribute("errorsLogin"):"" %>
