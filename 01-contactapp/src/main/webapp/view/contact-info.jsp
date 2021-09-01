<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>contact info</title>
	</head>
	<body>
		<h2>Save Contact</h2>
		<font color="green">${success}</font>
		<font color="green">${error}</font>
		<form:form action="savecontact?contactId=${contact.contactId}" modelAttribute="contact" method="post">
			<table>
			<tr>
				<td>Contact Name: </td>
				<td><form:input path="contactName"/></td>
			</tr>
			<tr>
				<td>Contact Email: </td>
				<td><form:input path="contactEmail"/></td>
			</tr>
			<tr>
				<td>Contact Number: </td>
				<td><form:input path="contactNumber"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save"></td>
			</tr>
			</table>
			<a href="viewcontact">View All Contact</a>	
		</form:form>
	</body>
</html>