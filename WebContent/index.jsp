<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
</head>
<body>
<h1><center>Welcome to the Assignment 2</center></h1> 
<%
//Lazyload the person container
//Get # of rows from person container

	out.println("<table border=\"1\"");
	out.println("<tr><td>Person ID</td><td>Name</td><td></td><td></td>");
	Person currentPerson = new Person();
	while(/*peoplecontainer hasnext*/)
	{
		out.println("<tr><td>"+CurrentPerson.getID+"</td><td>"+currentperson.getFirstName+
				" "+currentPerson.getLastName+"</td><td>"+UpdateButton+"</td><td>"+DeleteButton+"</td>");
	}
	out.println("</table>");



%>
</body>
</html>