package com.assignment2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment2.dao.PersonService;
import com.assignment2.model.Person;

/**
 * Servlet implementation class DoSave
 */
@WebServlet("/DoSave")
public class DoSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pId = (int) Integer.parseInt(request.getParameter("personID").toString());
		Person oldPerson = PersonService.getInstance().getContainer().GetPerson(pId);
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		Person p = new Person(pId,fName, lName, address, phone,true);
		if(oldPerson == null)
		{
			//PersonNon existing, create new one
			PersonService.getInstance().createPerson(p);
		}
		else if(!oldPerson.IsEqual(p))
		{
			//person info modified, or created
			if(PersonService.getInstance().PersonExists(p))
			{
				PersonService.getInstance().updatePerson(p);
			}
		}
		response.sendRedirect("PersonController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
