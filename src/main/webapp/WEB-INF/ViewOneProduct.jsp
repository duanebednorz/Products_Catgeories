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
			<h1>${product.name}</h1>
		</div>
		<div>
			<a href="/products/new">Add New Product</a> | <a
				href="/categories/new">New Category</a> | <a href="/dashboard">Dashboard</a>
		</div>
		<hr>
		<div class="col-sm-8">
			<div class="form-group">
				<form:form action="/addCategory" method="post">
				<input type ="hidden" value ="${product.id}" name="product_id">
					<label>Categories:</label>
					<select name="category_id" class="form-control">
						<c:forEach items="${allCategories}" var="cat">
							<option value="${cat.id}">${cat.name}</option>
						</c:forEach>
					</select>
					<br>
					<input type="submit" value="Add" class="btn btn-primary" />
				</form:form>
			</div>
		</div>
		<hr>
		<h2>Current Categories:</h2>
		<ul>
			<c:forEach items="${product.categories}" var="cat">
			<li>${cat.name}</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>