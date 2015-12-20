<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div>

<p class="para">
Welcome to Auction System!! Place you bid, grab the item and fulfill you wildest dream !!!!!
</p>
<c:if test="${loggedInUser ne null}">
	<%-- <p> Welcome ${loggedInUser }</p> --%>
</c:if>
</div>