<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<center>

<img src="<spring:url value="/resource/images/403.jpg"  htmlEscape="true" />" alt="Page not found!!!"  
width="600" height="400" />

<H2>${requestScope['javax.servlet.error.message']}</H2>
 
 <p><button type=button onclick=window.location.href="<spring:url value="/welcome" />">Home</button></p>

</center> 