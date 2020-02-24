<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>View_Book</title>
<!-- <style>
	body{
		background:skyblue;
			}
	table
	{
		width:1000px;
		margin:auto;
		margin-top:100px;
		table-layout:fixed;
	}
	table th,td{
	color:#fff;
	border-collapse:collapse;
	border:1px dotted white;
	text-align:center;
	font-family:arial;
	}
	th
	{
	font-size:20px;
	padding:17px;
	}
	td
	{
	padding:17px 20px;
	font-size:17px;
	}
	tr:nth-child(even)
	{
	background-color:#181b2f;
	}
	tr:nth-child(odd){background-color:#000}
</style> -->
</head>
<body style="text-align: center">
		<!-- <div style="overflow-x:auto;">-->
	<a href="home.jsp">HOME</a><br>	
    <a href="add_book.jsp">Add Book</a>
   <c:choose>
    	<c:when test="${!empty result}">
    		<h5>${result}</h5>
    	</c:when>
    </c:choose>
        <h1><u>View Book</u></h1>
<
<c:choose>
	<c:when test="${!empty Books}">
		<table>
	        <tr>
	            <th>BookID</th>
	            <th>BOOK NAME</th>
	            <th>AUTHOR</th>
	            <th>STATUS</th>
	            <th>PRICE</th>
	            <th>CATEGORY</th>
	            <th colspan="2">ACTION</th>
	        </tr>
	        <c:forEach var="dto" items="${Books}">
		        <tr>
		            <td>${dto.bookid}</td>
		            <td>${dto.bookName}</td>
		            <td>${dto.author}</td>
		            <td>${dto.status}</td>
		            <td>${dto.price}</td>
		            <td>${dto.category}</td>
		            <td><a href="edit_book?id=${dto.bookid}"><img class="img_prop" title="Click to Edit" src="assets/plan.svg" alt=""></a></td>
		            <td><a href="delete_book?id=${dto.bookid}"><img class="img_prop" title="Click to Delete"src="assets/delete.svg" alt=""></a></td>
		        </tr>
	        
	        </c:forEach>
	        
	    </table>
	
	</c:when>
	<c:otherwise><h5>No data found</h5></c:otherwise>
</c:choose>
</form>
</body>
</html>