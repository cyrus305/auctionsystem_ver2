<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<form:form modelAttribute="newCategory" method="post"
	action="addCategory">

	<fieldset>
		<legend>Add category</legend>

		<form:errors path="*" cssStyle="color:red;"></form:errors>

		<p>
			<label for="name">Name:</label>
			<form:input path="name" id="name" />
		</p>

		<p>
			<label for="description">Description:</label>
			<form:input path="description" id="name" />
		</p>
		<p id="buttons">
			<input type="submit" value="Create Category" >
		</p>

	</fieldset>


</form:form>
