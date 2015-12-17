<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<section>
		<div class="jumbotron">
			<div class="container">
				<img src="<spring:url value='/resource/images/loneRanger.jpg' />" />
				<h1> ${greeting} </h1>
			</div>	 
 
				  <div class="container">
	
	
 				<p> <security:authorize access="isAuthenticated()">
 				<a href="<spring:url  value="/doLogout" />" class="btn btn-danger btn-mini pull-right">Logout</a>	
 				</security:authorize>
	
		
					 <a href="<spring:url value='/products' />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> View Products
					</a>
				</div>	
		</div>	
	</section>
	
</body>
</html>


