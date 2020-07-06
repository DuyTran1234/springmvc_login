<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>

<table>
	<tr>
		<th>Bill id</th>
		<th>Product name</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Date</th>
	</tr>
	<c:forEach items="${listTransactionHistory}" var="item">
		<tr>
			<td>${item.id}</td>
			<td>${item.productDTO.getProductName()}</td>
			<td>${item.productDTO.getPrice()}</td>
			<td>${item.quantityOrder}</td>
			<td>${item.date}</td>
		</tr>
	</c:forEach>
</table>