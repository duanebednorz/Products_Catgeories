<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Dashboard</h1>
		</div>
		<div>
			<a href="/products/new">Add New Product</a> | <a
				href="/categories/new">New Category</a> | <a href="/dashboard">Dashboard</a>
		</div>
		<hr>
		<div class="col-sm-8">
			<table class="table table-striped">
				<tr class="bg-dark text-light">
					<th>Product Name</th>
					<th>Description</th>
					<th>Price</th>
				</tr>
				<c:forEach items="${allProducts}" var="prod">
					<tr>
						<td><a href ="/products/${prod.id}">${prod.name}</a></td>
						<td>${prod.description}</td>
						<td>${prod.price}</td>
						<c:forEach items="${product.catgeories}" var="pc">
						<ul>
						<li>${pc.name}</li>
						</ul>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
			<hr>
		</div>
		<div class="col-sm-8">
			<table class="table table-striped">
				<tr class="bg-dark text-light">
					<th>Category Name</th>
				</tr>
				<c:forEach items="${allCategories}" var="cat">
					<tr>
						<td><a href ="/categories/${cat.id}">${cat.name}</a></td>
					</tr>
				</c:forEach>
			</table>
			<hr>
		</div>
	</div>
</body>
</html>