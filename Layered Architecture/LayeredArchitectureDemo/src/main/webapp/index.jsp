<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="insertlap" method="Post">
		Enter Lid &nbsp;&nbsp;&nbsp;<input type="text"name="lid"/><br>
		Enter Make &nbsp;&nbsp;&nbsp;<input type="text"name="make"/><br>
		Enter Cost &nbsp;&nbsp;&nbsp;<input type="text"name="cost"/><br>
		<input type="submit" value="Add laptop"/><br>
	</form>
	<form action="showlaptop"><br>
		<input type="submit" value="Show All laptops"/>
	</form>
</body>
</html>