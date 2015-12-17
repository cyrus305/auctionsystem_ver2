<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<li><a href="<spring:url value="/"/>"><spring:message
			code="navigation.home.label" /></a></li>
<li><a href="<spring:url value="/products"/>"><spring:message
				code="navigation.products.label" /></a></li>


<security:authorize access="hasRole('ROLE_ADMIN')">
	<li><a href="<spring:url value="/products/add"/>"><spring:message
				code="navigation.addproduct.label" /></a></li>

	<li><a href="<spring:url value="/products/addCategory"/>"> <spring:message
				code="navigation.addCategory.label" /> </a></li>
</security:authorize>

<security:authorize access="isAuthenticated()">
	<li><a href="<spring:url value="/logout"/>"><spring:message
				code="navigation.logout.label" /></a></li>
</security:authorize>

<security:authorize access="isAnonymous()">
<li><a href="<spring:url value="/login"/>"><spring:message
				code="navigation.login.label" /></a></li>
<li><a href="<spring:url value="/signup"/>"><spring:message
				code="navigation.signup.label" /></a></li>
</security:authorize>

			
