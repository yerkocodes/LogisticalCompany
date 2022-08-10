<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.logistiqal.model.Product"%>
<%@page import="com.logistiqal.vo.ProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=ISO-8859-1">
<title>JSP CRUD</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
	<h1>JSP CRUD</h1>
	<h3>${mensaje}</h3>
	<a href="/addForm">Add new product</a>
	<br style="margin-top: 15px" />

	<!-- ... Botón agregar usuario -->
	<ul class="pagination pagination-lg justify-content-center">
		<c:forEach items="${pages}" var="page">
			<li class="page-item ${currentPage == page ? 'disabled' : ''}">
				<a class="page-link" href="home?p=${page}" tabindex="-1">${page}</a>
			</li>
		</c:forEach>
	</ul>

	<!-- Inicio Tabla ... -->
	<table border="1" width="90%">
		<tr>
			<th>Id</th>
			<th>Code</th>
			<th>Name</th>
			<th>Price</th>
			<th>Stock</th>
			<th></th>
		</tr>
		<c:forEach items="${VO.getProductList()}" var="p">
			<tr>
				<td>${p.getIdProduct()}</td>
				<td>${p.getCode()}</td>
				<td>${p.getName()}</td>
				<td>${p.getPrice()}</td>
				<td>${p.getStock()}</td>
				<td><a href="updateForm?idProduct=${p.getIdProduct()}">Update</a>
					<br /> <a href="delete?idProduct=${p.getIdProduct()}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>