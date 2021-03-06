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
 * Servlet implementation class EditPersonInfo
 */
@WebServlet("/EditPersonInfo")
public class EditPersonInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPersonInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int pId = (int) Integer.parseInt(request.getParameter("personID").toString());
		Person p = PersonService.getInstance().getExistingPerson(pId);
		
		if(!p.isLazyLoaded())
		{
			//Lazy load the person
			p =  PersonService.getInstance().getAllPersonInfo(pId);
		}
			
		session.setAttribute("personToEdit",p);
		response.sendRedirect("EditPersonPage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
