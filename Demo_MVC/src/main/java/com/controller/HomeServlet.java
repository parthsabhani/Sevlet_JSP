package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.HomeDAO;
import com.model.Student;

@WebServlet("/HomeServlet.do")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		if(action.equals("showstudent"))
		{
			int sid = Integer.parseInt(request.getParameter("sid"));
			Student s = new HomeDAO().verifyStudent(sid);
			request.setAttribute("model", s);
			request.getRequestDispatcher("home.jsp").forward(request, response);

		}else if(action.equals("editstudent"))
		{
			int sid = Integer.parseInt(request.getParameter("sid"));
			Student s = new HomeDAO().verifyStudent(sid);
			request.setAttribute("model", s);
			request.getRequestDispatcher("home.jsp").forward(request, response);

		}else if(action.equals("deletestudent"))
		{
			int sid = Integer.parseInt(request.getParameter("sid"));
			int x = new HomeDAO().deleteStudent(sid);
			if(x> 0)
			{
				request.setAttribute("msg", "Your student is Deleted.....");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Student std = new Student();
		std.setSid(Integer.parseInt(request.getParameter("sid")));
		std.setFirstname(request.getParameter("firstname"));
		std.setLastname(request.getParameter("lastname"));
		std.setUsername(request.getParameter("username"));
		std.setPassword(request.getParameter("password"));
		
		int x = new HomeDAO().editStudent(std);
		if(x > 0)
		{
			response.sendRedirect("HomeServlet.do?action=showstudent&sid="+std.getSid());
		}
	}

}

