<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>
<table>
	<tr>
		<th>Product name</th>
		<th>Price</th>
	</tr>
	<c:forEach items="${listProduct}" var="item">
		<tr>
			<td>${item.productName}</td>
			<td>${item.price}</td>
			<td>
				<c:if test="${item.quantity > 0}">
					<button onclick="addToCart(${item.id})">Add to Cart</button>
				</c:if>
				<c:if test="${item.quantity <= 0}">
					<p>Sell Outs</p>
				</c:if>
			</td>
		</tr>
	</c:forEach>
</table>

<c:url value="/add-to-cart" var="addToCartUrl" />
<script>
	function addToCart(id) {
		var xhttp = new XMLHttpRequest();
		var url = "${addToCartUrl}";
		xhttp.onreadystatechange = function() {
			if(this.readyState == 4 && this.status == 200) {
			}
		};
		xhttp.open("GET", url + "?id=" + id, true);
		xhttp.send();
	}
</script>