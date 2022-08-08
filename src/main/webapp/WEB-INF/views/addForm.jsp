<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="com.logistiqal.model.Product"%>
<%@page import="com.logistiqal.vo.ProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=ISO-8859-1">
<title>JSP CRUD</title>
</head>
<body>
	<h1>AGREGAR USUARIO</h1>
	<h3>${mensaje}</h3>

 	<form action="/add" method="post">
		<table>
			<tr>
				<td>Code Product:</td>
				<td><input type="text" name="code" /></td>
			</tr>

			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>

			<tr>
				<td>Price:</td>
				<td><input type="number" name="price" /></td>
			</tr>

			<tr>
				<td>Stock:</td>
				<td><input type="number" name="stock" /></td>
			</tr>

 			<tr>
				<td colspan="2"><input type="submit" value="Add new product" /></td>
			</tr>
		</table>
	</form>

</body>
</html>