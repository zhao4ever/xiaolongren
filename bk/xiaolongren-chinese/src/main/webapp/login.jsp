<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>

  <title>小龙人中文堂</title>

  <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css' />
  <link rel="stylesheet" href="${contextPath}/resources/css/login.css" />

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  
</head>
<body>
  <form method="POST" action="${contextPath}/login" class="form-signin">
    <div class="logo"></div>
	<div class="login-block" ${error != null ? 'has-error' : ''}>
	  <h1>Login</h1>
 	    <span>${message}</span>
  		  <input id="username" name="username" type="text" placeholder="Username" autofocus="autofocus" />
          <input id="password" name="password" type="password" placeholder="Password"/>
		<span>${error}</span>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<button type="submit">Log In</button>
	    <p class="message">Not registered? <a href="${contextPath}/registration">Create an account</a> </p>
	</div>
  </form>
</body>
</html>