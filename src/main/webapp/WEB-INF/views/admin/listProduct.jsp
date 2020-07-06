<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>

<style>
	table, tr, th, td {
		border: 1px solid black;
	}
</style>

<a href="<c:url value='/admin/them-san-pham' />">Add Product</a>

<table>
	<tr>
		<th>ID</th>
		<th>Product Name</th>
		<th>Price</th>
		<th>Quantity</th>
	</tr>
	<c:forEach items="${listProduct}" var="item">
		<tr>
			<td>${item.id}</td>
			<td>${item.productName}</td>
			<td>${item.price}</td>
			<td>${item.quantity}</td>
			<td>
				<a href="<c:url value='/admin/cap-nhat-san-pham?id=${item.id}' />">Update</a>
			</td>
			<td>
				<a href="<c:url value='/admin/xoa-san-pham?id=${item.id}' />">Delete</a>
			</td>
		</tr>
	</c:forEach>
</table>