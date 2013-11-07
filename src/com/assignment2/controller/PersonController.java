package com.assignment2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment2.model.PeopleContainer;
import com.assignment2.model.Person;

/**
 * Servlet implementation class PersonController
 */
@WebServlet("/PersonController")
public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UnitOfWork UOW;
    private PeopleContainer personList;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonController() {
        super();
        personList = new PeopleContainer();
        UOW = new UnitOfWork();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			Person p = new Person();
			p.setpId(100);
			p.setFirstName("Yo");
			p.setLastName("Nigga");
			personList.AddPerson(p);
			//Load Persons into personList;
			HttpSession session = request.getSession(true);
			session.setAttribute("currentpersonList",personList);
			
		}catch(Throwable theException){
			System.out.println(theException);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
