<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

</head>
<body class="p-3">

		<div class="d-flex align-items-center justify-content-center">
			<form:form id="form" class="border border-2 rounded p-2">
				<h2 class="text-center">Register an account:</h2>
					Please enter a username, email, and password:
				<div class="input-group mb-3">
					<input type="text" id="username" name="username" placeholder="Enter username" class="form-control">
				</div>
				
				<div class="input-group mb-3">
					<input type="text" id="email" name="email" placeholder="Enter e-mail" class="form-control">
				</div>
				
				<div class="input-group mb-3">
					<input type="password" id="password" name="password" placeholder="Enter password" class="form-control">
				</div>
				<div class="text-center text-danger">${error}</div>
				<div class="d-flex justify-content-center mt-3">
					<input type="submit" value="Register">
				</div>
			</form:form>
		</div>
	

</body>
</html>