<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.assignment2.model.Person"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Address</th>
			<th>Phone Number</th>
		</tr>
	    <%
	  	Person personToEdit = (Person) session.getAttribute("personToEdit");
	    %>
	        <tr>
				<td>
					<input type="text" value=<%=personToEdit.getFirstName()%>></input>
				</td>
				<td>
					<input type="text" value=<%=personToEdit.getLastName()%> ></input>
				</td>
				<td>
					<input type="text" value=<%=personToEdit.getAddress()%>></input>
				</td>
				<td>
					<input type="text" value=<%=personToEdit.getPhoneNumber()%>></input>
				</td>
			</tr>

	</table>
	</br>
	<table>
		<tr>
			<form action="DoCancel" method="get">
				<td><input type="submit" value="Cancel"></input></td>
			</form>
			<form action="DoSave" method="get">
				<td><input type="submit" value="Save"></input></td>
			</form>
		</tr>
	</table>
</center>
</body>
</html>