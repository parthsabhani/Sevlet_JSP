package com.controller;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("*.do")
public class AuthenticationFilter extends HttpFilter implements Filter {
       
    public AuthenticationFilter() 
    {
        super();
        // TODO Auto-generated constructor stub
    }
	public void destroy() 
	{

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
	
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		System.out.println("Now Start filtering request.....");
		
		if(req.getSession(false) == null)
		{
			req.setAttribute("msg", "Your session is expired try again LOGIN....");
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}else
		{
			chain.doFilter(request, response);
			System.out.println("Now Start filtering response......");
		}
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{
	
	}

}
