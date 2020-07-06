<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
	img {
		width: 100px;
		height: 100px
	}
</style>

<c:if test="${userSession.avatarUrl == null}">
	<img src="<c:url value='/avatar/default.jpg' />">
</c:if>
<c:if test="${userSession.avatarUrl != null}">
	<img src="<c:url value='/avatar/${userSession.avatarUrl}' />">
</c:if>

<c:url value="/user/update-avatar" var="updateAvatarController" />
<form action="${updateAvatarController}" method="post" enctype="multipart/form-data">
	<input type="file" name="file-avatar">
	<br><br>
	<button type="submit">Update Avatar</button>
</form>


<h4>Update Information</h4>
<c:url value="/user/update-information-controller" var="updateUserInformationController" />
<form action="${updateUserInformationController}" method="post">
	<p>Name</p><input name="name" value="${userSession.name}"><br>
	<p>Phone</p><input name="phone" value="${userSession.phone}"><br>
	<br>
	<button type="submit">Update</button>
</form>

<h4>Update Email</h4>
<p>Email</p><input value="${userSession.email}" readonly>
<br><br>

<p>Change Email</p>
<input id="email">
<button onclick="sendEmail()">Send code</button>
<br><br>

<div id="confirmCode"></div>

<p>${msgConfirmCode}</p>

<c:url value="/user/send-code-change-email-controller" var="codeChangeEmailUrl" />

<a href="<c:url value='/user/lich-su-giao-dich'/>">Transaction History</a>

<script>
	function sendEmail() {
		var email = document.getElementById("email").value;
		var url = "${codeChangeEmailUrl}" + "?email=" + email;
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("confirmCode").innerHTML = this.responseText;
			}
		};
		xhttp.open("GET", url, true);
		xhttp.send(); 
	}
</script>