<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
</head>
<body>
	<h2>Please enter student details:</h2>
	<form:form method="post" modelAttribute="s">
		<table border="1" style="columns: 2">
			<tr>
				<th colspan="2">
					<h3>Registration Form</h3>
				</th>
			</tr>
			<tr>
				<td>
					<spring:message code="s.name"/>
				</td>
				<td>
					<form:input path="name"/>
				</td>
				<form:errors path="name"/>
			</tr>
			<tr>
				<td>
					<spring:message code="s.age"/>
				</td>
				<td>
					<form:input type="number" path="age"/>
				</td>
				<form:errors path="age"/>
			</tr>
			<tr>
				<td>
					<spring:message code="s.mobile"/>
				</td>
				<td>
					<form:input type="number" path="mobile"/>
				</td>
				<form:errors path="mobile"/>
			</tr>
			<tr>
				<td>
					<spring:message code="s.address"/>
				</td>
				<td>
					<form:input path="address"/>
				</td>
				<form:errors path="address"/>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Submit"/>
				</td>
				<td>
					<input type="reset" value="Reset"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>