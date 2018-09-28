<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
  <title>小龙人中文堂</title>

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="${contextPath}/resources/css/register.css" />

</head>
<body>
	<div class="container">
		<header>
    	<h1 style="text-align:center">
		<span>欢迎注册小龙人中文堂！</span>
		</h1>
    	</header>
    	<div class="form">
			<form id="contactform" action="/rigister/user" method="POST">
				<!-- First Name -->
				<p class="contact">
					<label for="name">First Name</label>
				</p>
				<input id="firstName" name="firstname" placeholder="First name"
					tabindex="1" type="text" required="required" />
			
				<!-- Last Name -->
				<p class="contact">
					<label for="name">Last Name</label>
				</p>
				<input id="lastName" name="lastname" placeholder="Last name"
					tabindex="1" type="text" required="required" />

				<!-- Email -->
				<p class="contact">
					<label for="email">Email</label>
				</p>
				<input id="email" name="email" placeholder="example@domain.com"
					required="required" type="email" />

				<!-- username -->
				<p class="contact">
					<label for="username">Create a username</label>
				</p>
				<input id="userName" name="username" placeholder="username" required="required"
					tabindex="2" type="text" />

				<!-- password -->
				<p class="contact">
					<label for="password">Create a password</label>
				</p>
				<input type="password" id="password" name="password" required="required" />

				<!-- confirm password -->
				<p class="contact">
					<label for="repassword">Confirm your password</label>
				</p>
				<input type="password" id="repassword" name="repassword" required="required" />

				<!-- birthday ymd -->
				<fieldset>
					<label>Year<input class="birthyear" maxlength="4"
						name="BirthYear" placeholder="Year" required="required" />
					</label>
					<label>Month</label> <label class="month">
						<select
							class="select-style" name="BirthMonth">
							<option value="">Month</option>
							<option value="01">January</option>
							<option value="02">February</option>
							<option value="03">March</option>
							<option value="04">April</option>
							<option value="05">May</option>
							<option value="06">June</option>
							<option value="07">July</option>
							<option value="08">August</option>
							<option value="09">September</option>
							<option value="10">October</option>
							<option value="11">November</option>
							<option value="12">December</option>
						</select>
					</label>
					<label>Day<input class="birthday" maxlength="2"
						name="BirthDay" placeholder="Day" required="required" />
					</label>
				</fieldset>

				<!-- sex -->
				<select class="select-style gender" name="gender">
					<option value="select">my sex is</option>
					<option value="m">Male</option>
					<option value="f">Female</option>
					<option value="others">Other</option>
				</select>
				<br/>

				<!-- phone -->
				<p class="contact">
					<label for="phone">Mobile phone</label>
				</p>
				<input id="phone" name="phone" placeholder="phone number" required="required"
					type="text" /> 
				<br/>
			
				<input class="buttom" name="submit"
					id="submit" tabindex="5" value="Sign me up!" type="submit" />
			</form>
		</div>
	</div>
</body>
</html>
