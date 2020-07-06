<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>

<p>Total Products: </p>

<table>
	<tr>
		<th>Product Name</th>
		<th>Price</th>
		<th>Quantity</th>
	</tr>
	<c:forEach items="${cartSession}" var="item">
		<tr>
			<td>${item.productDTO.getProductName()}</td>
			<td>${item.productDTO.getPrice()}</td>
			<td>${item.quantityOrder}</td>
		</tr>
	</c:forEach>
</table>

<c:url value="/user/payment-cart-controller" var="paymentCartController"/>
<form action="${paymentCartController}" method="post">
	<button type="submit">Payment</button>
</form>