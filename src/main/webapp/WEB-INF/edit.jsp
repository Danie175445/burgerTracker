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
	<form:form action="/burger/${burgers.id}" method="post" modelAttribute="burgers" >
	 <input type="hidden" name="_method" value="put">
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
	<button><a href="/home">Home</a></button>
</body>
</html>