package com.assignment2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment2.dao.PersonService;

/**
 * Servlet implementation class PersonController
 */
@WebServlet("/PersonController")

public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UnitOfWork UOW;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonController() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{

			HttpSession session = request.getSession(true);
			
			if(PersonService.getInstance().isEmpty())
			{
				//Get initial information from database, get's called once.
				session.setAttribute("currentpersonList",PersonService.getInstance().getAllFirstLastNamesIds());
			}
			
			response.sendRedirect("ShowPeopleInfo.jsp");
			
		}catch(Throwable theException){
			System.out.println(theException);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
