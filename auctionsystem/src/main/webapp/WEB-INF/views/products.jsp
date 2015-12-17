<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

	<section>
	<!-- <div class="jumbotron">
		<div class="container">
			<h1>Products</h1>
			<p>All the available products in auction</p>
		</div>
		
	</div> -->

	</section>
	
	<fieldset>
				<legend>Available Products</legend>

	<section class="container">
	<div class="row">
		<c:forEach items="${products}" var="product">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<p>Category: ${product.category.name}</p>
						<p>
							<img alt=""
								src='<spring:url value="resource/images/${product.image }"></spring:url>' height="100px" width="125px" >
						</p>
						<h3>${product.name}</h3>
						<p>${product.description}</p>
						
						<p>Min Bidding price(USD): $${product.minBiddingPrice}</p>
						<p>
							Available Date:
							<fmt:formatDate value="${product.timeToBid}" pattern="MM/dd/yyyy" />
						</p>
						<p>Bidded By:</p>

						<p>
							<security:authorize access="hasRole('ROLE_USER')">
							<button>Bid This</button>
							</security:authorize>
							
							<security:authorize access="hasRole('ROLE_ADMIN')">
							<a href=" <spring:url value="/products/edit/${product.id}" />  ">
								<button>Edit</button>
							</a>
							</security:authorize>
							
							
							<security:authorize access="hasRole('ROLE_ADMIN')">
							<a
								href="  <spring:url value="/products/delete/${product.id}" />  "><button>Delete</button></a>
						
							</security:authorize>
							
							
							 </p>

					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	</section>
	
	</fieldset>
