<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	
	
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	
<script type="text/javascript"
	src="<spring:url value="/resource/js/ajax.js"/>"></script>

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
									src='<spring:url value="resource/images/${product.image }"></spring:url>'
									height="100px" width="125px">
							</p>
							<h3>${product.name}</h3>
							<p>${product.description}</p>
							<input id="minBidValue" type="hidden"
								value="${product.minBiddingPrice}">

							<p id="product_${product.id}">Min Bidding price(USD): $${product.minBiddingPrice}</p>
							
							<input type="hidden" id="endDate" value="${product.timeToBid }">
							<p>
								Available Date:
								<fmt:formatDate value="${product.timeToBid}"
									pattern="MM/dd/yyyy" />
							</p>
							<%-- 
							<input type="hidden" id="bidding_user" value="${loggedInUser.firstName })"> --%>
							<p id="bid_user">Bidded By:
							<c:forEach items="${bids }" var="bid">
							<c:if test="${bid.product.id == product.id }">${bid.user.firstName}</c:if>
							</c:forEach></p> 

							<p>
								<security:authorize access="hasRole('ROLE_USER')">
									<input type="button" value="Bid This" id='${product.id}' class="bid_button"
										<%-- onclick="make_visible('formInput','${product.id}'); return false; --%>">
								</security:authorize>

								<security:authorize access="hasRole('ROLE_ADMIN')">
									<a
										href=" <spring:url value="/products/edit/${product.id}" />  ">
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

<div id="dialog-confirm" title="Bid Range Error" style="display: none">
	<p>
		<span class="ui-icon ui-icon-alert"
			style="float: left; margin: 0 7px 20px 0;"></span>Bid price is less than Min Bid price. Please enter value greater than min value.
	</p>
</div>

<div id="dialog-ok" title="Bid Submitted" style="display: none">
	<p>
		<span class="ui-icon ui-icon-alert"
			style="float: left; margin: 0 7px 20px 0;"></span>You bid was placed. Congrats!
	</p>
</div>


<div id="result" style="display: none">
		<p id="success"></p>
		<p id="errors"></p>
	</div>
	<div id="dialog-input" style="display: none" title="Biding price">

		<!-- No action method handled by AJAX-->


			<p>
				<label for="name"> Bidding Price : </label> <input type="text"
					name="bidPrice" id="bidPrice" value="" />
			</p>

	</div>


