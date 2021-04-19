<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Category</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container">
   <div class="jumbotron">
			<h1>New Category</h1>
		</div>
		<div>
			<a href="/products/new">Add New Product</a> | <a href="/categories/new">New
				Category</a> | <a href="/dashboard">Dashboard</a>
			<hr>
			<div class="row">
				<div class="col-sm-4">
					<form:form action="/category/create" method="post"
						modelAttribute="newCategory">
						<div class="form-group">
							<label>Category Name:</label>
							<form:input path="name" class="form-control" />
							<form:errors path="name" class="text-danger" />
						</div>
						<input type="submit" value="Add Category" class="btn btn-primary" />
					</form:form>
				</div>
			</div>
		</div>
  </div>
</body>
</html>