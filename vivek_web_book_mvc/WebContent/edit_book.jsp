<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>EDIT PRODUCT</title>
</head>
<body style="text-align: center">
	<h1><u>Edit BOOK</u></h1>
        <a href="home">HOME</a><br>
        <a href="view_book">View Book</a>
        <form action="edit" method="post">

            <table>
                <tr>
                    <td>BOOK ID::</td>
                    <td>BOOK Name::</td>
                    <td>AUTHOR::</td>
                    <td>STATUS::</td>
                    <td>PRICE::</td>
                    <td>CATEGORY::</td>
                    
                </tr>
                <tr>
                    <td><input class="input_deco" readonly type="text" value="${dto.bookid}" placeholder="Book Id" name="bookid"></td>
                    <td><input class="input_deco"  type="text" value="${dto.bookName}" placeholder="Book Name" name="bookname"></td>
                    <td><input class="input_deco"  type="text" value="${dto.author}"  placeholder="Author" name="author"></td>
                    <td><input class="input_deco"  type="text" value="${dto.status}"  placeholder="STATUS" name="status"></td>
                    <td><input class="input_deco"  type="text" value="${dto.price}"  placeholder="price" name="price"></td>
                    <td><input class="input_deco"  type="text" value="${dto.category}"  placeholder="category" name="category"></td>
                </tr>
                <tr>
                    <td colspan="6"> <button class="btn_deco" type="submit">Update</button></td>
                </tr>
            </table>

        </form>
</body>
</html>