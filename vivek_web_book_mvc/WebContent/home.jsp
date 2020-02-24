<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html lang="en">
<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/style.css">
		<title>Home</title>
</head>
<body style="text-align: center">
<c:choose>
		<c:when test="${!empty result}">
			<h5>${result}</h5>
		</c:when>
	</c:choose>
	<h1>Welcome to book Shop</h1>
	<a class="linkproduct linkdeco1" href="view_book.htm">VIEW BOOK</a>
	<a class="linkproduct linkdeco2" href="add_book">ADD BOOK</a>
</body>
</html>