<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<title>Add_book_details</title>
</head>
<body style="text-align: center">
	<h1>Add Book</h1>
		<form action="add" method="post">
		<table>
			<tr>
				<td>bookid</td>
				<td>bookname</td>
				<td>author</td>
				<td>status</td><br>
				<td>price</td><br>
				<td>category</td><br>
			</tr>
			<tr>
				<td><input class="input_deco" type="text" placeholder="bookid" name="id"></td>
				<td><input class="input_deco" type="text" placeholder="bookname" name="name"></td>
				<td><input class="input_deco" type="text" placeholder="author" name="author"></td>
				<td><input class="input_deco" type="text" placeholder="status" name="status"></td><br>
				<td><input class="input_deco" type="text" placeholder="price" name="price"></td><br>
				<td><input class="input_deco" type="text" placeholder="category" name="category"></td><br>
			</tr>
			<tr>
				<td colspan="6"><button type="submit">Submit</button>
			</tr>	
		</table>
		
	</form>
</body>
</html>