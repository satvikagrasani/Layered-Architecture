<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="in.mindcraft.pojos.Laptop" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Here should be the output
	

	<c:forEach items="${requestScope.Laptop}" var="laptop">
    	<p>Laptop ID: ${laptop.lid} Laptop Name: ${laptop.make} Laptop Cost: ${laptop.cost}</p>
	</c:forEach>
	<p>Debug Info: ${empty requestScope.Laptop}</p>
</body>
</html>