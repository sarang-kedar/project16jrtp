<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>View All Contact</title>
		<script>
			function confirmDelete(){
				return confirm("Are you sure you want to delete the contact?")
			}
		</script>
	</head>
	<body>
		<a href="contact">+Add New Contact</a>
		<table>
			<thead>
				<tr>
					<td>Name</td>
					<td>Email</td>
					<td>Number</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody align="left">
				<c:forEach items="${contacts}" var="contact" >
					<tr>
						<th>${contact.contactName}</th>
						<th>${contact.contactEmail}</th>
						<th>${contact.contactNumber}</th>
						<th>
							<a href="edit?cid=${contact.contactId}">Edit</a>
							<a href="delete?cid=${contact.contactId}" onclick="return confirmDelete()">Delete</a></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>