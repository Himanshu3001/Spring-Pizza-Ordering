<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
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


<title>Pizza Order Manager</title>

<style>
      .error {
         color: #ff0000;
      }

      .errorblock {
         color: #000;
         background-color: #ffEEEE;
         border: 3px solid #ff0000;
         padding: 8px;
         margin: 16px;
      }
   </style>


	
</head>
<body>	
<div >
	 
</div>

 <form:errors cssClass = "errorblock" element = "div" /> 
<div class="container" style="font-size:1.5vw;">

	
	
		<jsp:include page="navBar.jsp" />
	<table class="table table-hover">
				<tr class="info">
					<th>Pizza Image</th>
					<th>Pizza Name</th>
					<th>Price</th>
					<th>Category</th>
					<th>Description</th>
					<th>Add to Cart</th>
					
				</tr>
				
				<c:forEach var="tempItems" varStatus="myIndex"  items="${items}" >

				<c:url var="addToCart" value="/addToCart">
						
								<c:param name="itemId" value="${tempItems.itemId}"></c:param>	
				</c:url>
				
					<tr class="success">
						<td>  <img class="d-block img-fluid" src="<c:url value="resources/images/${myIndex.index}.jpg"/>" alt="image" /> </td>
						<td>${tempItems.itemName}</td>
						<td>${tempItems.price}</td>
						<td>${tempItems.category}</td>
						<td width="400" >${tempItems.description}</td>
						<td>	
							<a  class="btn btn-outline-success" href="${addToCart}">Add to Cart</a>	
						</td>
						
					</tr>
					
					
					
				</c:forEach>
			</table>

	</div>
	</body>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>

</html>