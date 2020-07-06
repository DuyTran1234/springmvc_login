<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>
<style>
	table, th, td {
		border: 1px solid black
	}
	
</style>

<table>
	<tr>
		<th>Name</th>
		<th>Phone</th>
		<th>Username</th>
		<th>Password</th>
		<th>Role</th>
		<th>Enabled</th>
		<th>Email</th>
	</tr>
	<c:forEach items="${listUser}" var="item">
		<tr>
			<td>${item.name}</td>
			<td>${item.phone}</td>
			<td>${item.username}</td>
			<td>${item.password}</td>
			<td>${item.role}</td>
			<td>${item.enabled}</td>
			<td>${item.email}</td>
			<td>
				<a href="<c:url value='/admin/cap-nhat-nguoi-dung?id=${item.id}' />">Update</a>
			</td>
			<td>
				<a href="<c:url value='/admin/xoa-nguoi-dung?id=${item.id}' />">Delete</a>
			</td>
		</tr>
	</c:forEach>
</table>