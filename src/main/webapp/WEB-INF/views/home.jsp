<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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



</head>

<body>

	
<div class="container" style="font-size:5vw;">
	


	<jsp:include page="navBar.jsp"/>
	

	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<%-- <div class="item active">
        <img src="<c:url value="resources/images/img1.jpg"/>" alt="Pizza image" style="width:100%;">
      </div> --%>

			<div class="item active">
				<img src="<c:url value="resources/images/home1.jpg"/>"
					alt="Pizza image" style="width: 100%;">
				<!-- <div class="carousel-caption">
					<h3>Pizza Offer</h3>
					<p>Pizza so much fun!</p>
				</div> -->
			</div>

			<div class="item">
				<img src="<c:url value="resources/images/home2.jpg"/>"
					alt="Pizza image" style="width: 100%;">
				<!-- <div class="carousel-caption">
					<h3>Pizza Offer</h3>
					<p>Pizza so much fun!</p>
				</div> -->
			</div>
			<div class="item">
				<img src="<c:url value="resources/images/home3.jpg"/>"
					alt="Pizza image" style="width: 100%;">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	</div>



	<%-- 
		<img src="<c:url value="resources/images/1.jpg"/>" alt="image"  />
		 --%>


	<div></div>
	
	
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>


</body>

</html>