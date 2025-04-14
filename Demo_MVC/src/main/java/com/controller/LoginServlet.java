package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		int x = new LoginDAO().studentLogin(request.getParameter("username"), request.getParameter("password"));
		
		if(x > 0) 
		{
			request.setAttribute("msg", "Login Successfully");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}else
		{
			request.setAttribute("msg", "Login Failed");
			request.getRequestDispatcher("message.jsp").forward(request, response);	
		}
	}

}
