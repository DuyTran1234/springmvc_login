<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<c:url value="/admin/add-product-controller" var="addProductController" />

<form:form modelAttribute="addProduct" method="post" action="${addProductController}">
	<p>Product Name</p><form:input path="productName" /><br>
	<p>Price</p><form:input path="price" /><br>
	<p>Quantity</p><form:input path="quantity" /><br>
	<br>
	<form:button type="submit">Add Product</form:button>
</form:form>
