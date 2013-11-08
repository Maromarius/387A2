<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.assignment2.controller.PersonController"%>
<%@page import="com.assignment2.model.PeopleContainer"%>
<%@page import="com.assignment2.model.Person"%>
<%@page import="java.util.ArrayList"%>


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
			<th>Modify</th>
		</tr>
	    <%
	    PersonController controller = new PersonController();
	    PeopleContainer container = (PeopleContainer) session.getAttribute("currentpersonList");
	    ArrayList<Person> personList = container.GetPersonList();
	    
	    for(int i = 0; i < personList.size(); i++)
	    {
	    %>
	        <tr>
				<td ><%personList.get(i).getFirstName(); %> </td>
				<td><%personList.get(i).getLastName(); %></td>
				<td>Edit</td>
			</tr>
		<%}%>

	</table>
</center>
</body>
</html>