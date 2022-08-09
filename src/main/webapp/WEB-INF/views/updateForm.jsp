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
</head>
<body>
	<h1>EDITAR USUARIO</h1>
	<h3>${msj}</h3>
	<form action="/update" method="post">
		<table>
			<tr>
				<td>Code Product:</td>
				<td><input type="text" name="code" value="${Product.getStatusCode()}" disabled /></td>
			</tr>

			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="${Product.getName()}"/></td>
			</tr>

			<tr>
				<td>Price:</td>
				<td><input type="number" name="price" value="${Product.getPrice()}"/></td>
			</tr>

			<tr>
				<td>Stock:</td>
				<td><input type="number" name="stock" value="${Product.getStock()}"/></td>
			</tr>

 			<tr>
				<td colspan="2"><input type="submit" value="Update Product" /></td>
			</tr>
		</table>
	</form>
</body>
</html>