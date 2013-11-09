<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.assignment2.controller.PersonController"%>
<%@page import="com.assignment2.controller.UnitOfWork"%>
<%@page import="com.assignment2.dao.PersonService"%>
<%@page import="com.assignment2.model.PeopleContainer"%>
<%@page import="com.assignment2.model.Person"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>People List</title>
	</head>
	
<body>
<center>
	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th colspan="2" >Modify</th>
		</tr>
	    <%
	    PeopleContainer container = PersonService.getInstance().getContainer();
	    ArrayList<Person> personList = container.GetPersonList();
	    
	    for(int i = 0; i < personList.size(); i++)
	    {
	    	String isDirty = "";
	    	if(UnitOfWork.GetInstance().ContainsKey(personList.get(i).getpId()))
    			{
    				isDirty = "*";
    			}
	    %>
	        <tr>
				<td ><%=isDirty+personList.get(i).getFirstName() %> </td>
				<td><%=personList.get(i).getLastName() %></td>
				<td>
					<form action="EditPersonInfo" method="get">
						<input Value="Edit" type="submit"/>
						<input Value="<%=personList.get(i).getpId()%>" type="hidden" Name="personID" >
					</form>
				</td>
				<td>
					<form action="DeletePerson" method="get">
						<input Value="Delete" type="submit"/>
						<input Value="<%=personList.get(i).getpId()%>" type="hidden" Name="personID" >
					</form>
				</td>
			</tr>
		<%}%>

	</table>
	<br/>
	<table>
		<tr>
			<form action="DoCommit" method="get">
				<td><input type="submit" value="Commit Changes"></input></td>
			</form>
			<form action="AddPersonPage.jsp" >
				<td><input type="submit" value="Add Person..."></input></td>
			</form>
		</tr>
	</table>
</center>
</body>
</html>