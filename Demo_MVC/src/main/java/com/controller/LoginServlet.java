package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.LoginDAO;
import com.model.Student;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		Student std = new LoginDAO().studentLogin(request.getParameter("username"), request.getParameter("password"));
		
		if(std != null) 
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("model", std);
			session.setMaxInactiveInterval(60*2);
			response.sendRedirect("HomeServlet.do?action=showstudent&sid="+std.getSid());
		}else
		{
			request.setAttribute("msg", "Invalid Username or Password");
			request.getRequestDispatcher("login.jsp").forward(request, response);	
		}
	}

}
