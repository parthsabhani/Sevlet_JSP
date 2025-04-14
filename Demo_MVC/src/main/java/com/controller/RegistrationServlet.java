package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.RegistrationDAO;
import com.model.Student;
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Student s = new Student();
		s.setFirstname(request.getParameter("firstname"));
		s.setLastname(request.getParameter("lastname"));
		s.setUsername(request.getParameter("username"));
		s.setPassword(request.getParameter("password"));
		
		int x = new RegistrationDAO().studentRegistration(s);
		
		if(x > 0)
		{
			request.setAttribute("msg", "User Registration Successfully....");
			request.getRequestDispatcher("login.jsp").forward(request, response);;
		}
		else
		{
			request.setAttribute("msg", "Failed Registration ....");
			request.getRequestDispatcher("registration.jsp").forward(request, response);;
		}
	}
}
