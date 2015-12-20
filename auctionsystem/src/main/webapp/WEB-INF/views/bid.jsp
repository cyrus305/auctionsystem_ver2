<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form commandName="newBid" id="bidForm" , action="bidAdd"
	action="post">


	<p>
		<img alt=""
			src='<spring:url value="resource/images/${product.image }"></spring:url>'
			height="100px" width="125px">
	</p>
	<h3>${product.name}</h3>
	<p>${product.description}</p>

	<p>Min Bidding price(USD): $${product.minBiddingPrice}</p>
	<p>
		Available Date:
		<fmt:formatDate value="${product.timeToBid}" pattern="MM/dd/yyyy" />
	</p>
	<p>Bidded By:</p>


</form:form>

</body>
</html>