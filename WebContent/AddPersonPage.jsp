<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.assignment2.dao.PersonService"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Person</title>
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
	    <form action="DoSave" method="get">
	        <tr>
				<td>
					<input type="hidden" name="personID" value=<%=PersonService.getInstance().getNextPId() %>></input>
					<input type="text" name="firstName" ></input>
				</td>
				<td>
					<input type="text" name="lastName"  ></input>
				</td>
				<td>
					<input type="text" name="address"></input>
				</td>
				<td>
					<input type="text" name="phone"></input>
				</td>
			</tr>

	</table>
	</br>
	<table>
		<tr>
		
				<td><input type="submit" value="Save"></input></td>
			</form>
			<form action="DoCancel" method="get">
				<td><input type="submit" value="Cancel"></input></td>
			</form>
			
		</tr>
	</table>
</center>
</body>
</html>