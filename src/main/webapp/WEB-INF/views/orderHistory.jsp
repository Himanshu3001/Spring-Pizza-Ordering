<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.himanshu.ecom.entity.Item"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="<c:url value="resources/css/styles.css"/>" rel="stylesheet">
<link rel="stylesheet" href="resources/css/styles.css"/>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Order History</title>
</head>
<body>
<div class="container" style="font-size:1.5vw;">
<jsp:include page="navBar.jsp" /> 
	
	

		<table border="1" align="center">
				
				<tr>
					<!-- <th>Pizza Image</th> -->
					<th>Pizza Id</th>
					<th>Pizza Name</th>	
				</tr>
				
				<c:forEach var="temp" items="${allItems}" >
				
					<tr>
						<td>${temp.itemId}</td>
						<td>${temp.itemName }</td>
						
					</tr>
	
				</c:forEach>
	
			</table>
			
</div>
</body>
</html>