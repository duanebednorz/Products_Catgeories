<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Products</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>New Product</h1>
		</div>
		<div>
			<a href="/products/new">Add New Product</a> | <a href="/categories/new">New
				Category</a> | <a href="/dashboard">Dashboard</a>
			<hr>
			<div class="row">
				<div class="col-sm-4">
					<form:form action="/product/create" method="post"
						modelAttribute="newProduct">
						<div class="form-group">
							<label>Product Name:</label>
							<form:input path="name" class="form-control" />
							<form:errors path="name" class="text-danger" />
						</div>
						<div class="form-group">
							<label>Product Description:</label>
							<form:input path="description" class="form-control" />
							<form:errors path="description" class="text-danger" />
						</div>
						<div class="form-group">
							<label>Product Price:</label>
							<form:input type="number" min="0.01" step="0.01" max="2500" path="price" class="form-control" />
							<form:errors path="price" class="text-danger" />
						</div>
						<input type="submit" value="Add Product" class="btn btn-primary" />
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>