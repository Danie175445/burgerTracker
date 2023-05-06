<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Burger Tracker</h1>
		<table>
			<tr>
				<th>Burger Name</th>
				<th>Restaurant Name</th>
				<th>Rating (out of 5)</th>
			</tr>
			<c:forEach var="burger" items="${burgers }">
				<tr>
					<td><c:out value="${burger.name }" /></td>
					<td><c:out value="${burger.restaurant }" /></td>
					<td><c:out value="${burger.rating }" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<h1>Add a Burger:</h1>
		<form:form action="/burger" method="post" modelAttribute="burger" >
			<div>
				<form:label path="name">Burger Name</form:label>
				<form:errors path="name"/>
				<form:input type="text" path="name"/>
			</div>
			<div>
				<form:label path="restaurant">Restaurant Name</form:label>
				<form:errors path="restaurant" />
				<form:input type="text" path="restaurant"/>
			</div>
			<div>
				<form:label path="rating">Rating</form:label>
				<form:errors path="rating" />
				<form:input type="number" path="rating"/>
			</div>
			<div>
				<form:label path="notes">Notes</form:label>
				<form:errors path="notes" />
				<form:textarea rows="3" cols="15" path="notes"></form:textarea>
			</div>
			<input type="submit">
		</form:form>
	</div>
</body>
</html>