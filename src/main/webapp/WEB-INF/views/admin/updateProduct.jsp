<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<c:url value="/admin/update-product-controller" var="updateProductController" />

<form:form modelAttribute="updateProduct" method="post" action="${updateProductController}">
	<form:input path="id" hidden="true"/>
	<p></p><form:input path="productName"/><br>
	<p></p><form:input path="price"/><br>
	<p></p><form:input path="quantity"/><br>
	<br>
	<form:button type="submit">Update Product</form:button>
</form:form>