<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Registration</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.login-form {
	width: 340px;
	margin: 50px auto;
}

.login-form form {
	margin-bottom: 15px;
	background: #f7f7f7;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.login-form h2 {
	margin: 0 0 15px;
}

.form-control, .btn {
	min-height: 38px;
	border-radius: 2px;
}

.btn {
	font-size: 15px;
	font-weight: bold;
}
</style>
</head>


<body>
<body>
	<div class="login-form">

		<h2 class="text-center">Register</h2>

		<form:form action="registerPage" modelAttribute="userReg">

		

			<div class="form-group">
				<form:input name="name" path="name" class="form-control"
					placeholder="Name" required="required" />
			</div>

			<div class="form-group">
				<form:input name="email" path="email" class="form-control"
					placeholder="Email" required="required" />
			</div>
			<div class="form-group">
				<form:input type="password" name="password" path="password"
					class="form-control" placeholder="Password" required="required" />
			</div>
				
			<div class="form-group">
				<form:input  name="mobile" path="mobile"
					class="form-control" placeholder="Mobile" required="required" />
			</div>
			<div class="form-group">
				<form:input  name="city" path="city"
					class="form-control" placeholder="City" required="required" />
			</div>
					
			<div class="form-group">

				<button type="submit" class="btn btn-primary btn-block">Register</button>
			</div>
			<!-- <div class="clearfix">
				<label class="pull-left checkbox-inline"><input
					type="checkbox"> Remember me</label> <a href="#" class="pull-right">Forgot
					Password?</a>
			</div> -->
		</form:form>
		<p class="text-center">
			<a href="./">Already Registered? Login Here</a>
		</p>
	</div>
</body>
</html>





