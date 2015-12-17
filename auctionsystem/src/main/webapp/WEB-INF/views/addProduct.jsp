<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

	<section class="container">
		<form:form   action="add"
			method="post" modelAttribute="newProduct" enctype="multipart/form-data">		
		
		<fieldset>
				<legend>Add a product</legend>
				
				<form:errors path="*" cssStyle="color:red;" />
			<p>
				<label for="name"><spring:message code="product.name" /></label>
				<form:input id="name" path="name" />
			</p>
			<p>
				<label for="description"><spring:message
						code="product.description" /></label>
				<form:input path="description" />
			</p>
			<p>
				<label for="category"><spring:message
						code="product.category" /> </label>
				<form:select id="category" path="category.id">
					<form:option value="0" label="--Select Category--" />
					<form:options items="${categories}" itemLabel="name" itemValue="id" />
				</form:select>
			</p>
			<p>
 				<label for="imageFile"><spring:message code="product.image" />
 				</label> 
 				<form:input type="file"  path="imageFile" id="image" /> 
 			</p>

			<p>
				<label for="minBiddingPrice"><spring:message
						code="product.minBiddingPrice" /></label>
				<form:input path="minBiddingPrice" />
			</p>

			<p>
				<label for="timeToBid"><spring:message
						code="product.timeToBid" /></label>
				<form:input   path="timeToBid" />
			</p>
			<p id="buttons">
				<input id="reset" type="reset"
					value="<spring:message code="product.reset" />"> <input
					id="submit" type="submit"
					value="<spring:message code="product.submit" />">
			</p>
			</fieldset>

		</form:form>
	</section>
