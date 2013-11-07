<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.assignment2.model.Person"
    import="com.assignment2.model.PeopleContainer"
    import="java.util.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
</head>
<body>

<h1><center>Welcome to the Assignment 2</center></h1>
<br>

<%
//Lazyload the person container
//Get # of rows from person container

	out.println("<table border=\"1\"");
	out.println("<tr><td>Person ID</td><td>First Name</td><td>Last Name</td><td></td><td></td></tr>");
	Person currentPerson;
	PeopleContainer currentList = (PeopleContainer) session.getAttribute("currentpersonList");
	//HashMap<Integer,Person> map = currentList.GetContainer();
	//Iterator it = map.entrySet().iterator();
	//while(it.hasNext())
	//{
		//Map.Entry pair = (Map.Entry)it.next(); 
		currentPerson = currentList.GetPerson(100);
		out.println("<tr><td>"+currentPerson.getpId()+"</td><td>"+currentPerson.getFirstName()+
				" "+currentPerson.getLastName()+"</td><td>"+"UpdateButton"+"</td><td>"+"DeleteButton"+"</td></tr>");
	//}
	out.println("</table>");



%>
</body>
</html>