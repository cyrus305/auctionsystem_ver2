<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


	<section class="container">
		<form:form action="edit/${product.id}" method="post"
			modelAttribute="product">

			<fieldset>
				<legend>Edit a product</legend>
				<p><img alt=""
					src='<spring:url value="resource/images/${product.image }"></spring:url>'
					height="100px" width="125px"></p>

				<form:errors path="*" cssStyle="color:red;" />
				<p>
					<label for="name"><spring:message code="product.name" /></label>
					<form:input id="name" path="name" value="${product.name}" />
				</p>
				<p>
					<label for="description"><spring:message
							code="product.description" /></label>
					<form:input path="description" value="${product.name}" />
				</p>
				<p>
					<label for="category"><spring:message
							code="product.category" /> </label>
					<form:select id="category" path="category.id">
						<form:option value="${product.category.id}"
							label="${product.category.name}" />
						<form:options items="${categories}" itemLabel="name"
							itemValue="id" />
					</form:select>
				</p>
				<!-- 			<p> -->
				<%-- 				<label for="image"><spring:message code="product.image" /></label> --%>
				<%-- 				<form:input  path="image" id="image" /> --%>
				<!-- 			</p> -->

				<p>
					<label for="minBiddingPrice"><spring:message
							code="product.minBiddingPrice" /></label>
					<form:input path="minBiddingPrice"
						value="${product.minBiddingPrice}" />
				</p>

				<p>
					<label for="timeToBid"><spring:message
							code="product.timeToBid" /></label>
					<form:input path="timeToBid" value="${product.timeToBid}" />
				</p>
				<p id="buttons">
					<input id="reset" type="reset"
						value="<spring:message code="product.reset" />"> <input
						id="submit" type="submit"
						value="<spring:message code="product.update" />">
				</p>
			</fieldset>

		</form:form>
	</section>

