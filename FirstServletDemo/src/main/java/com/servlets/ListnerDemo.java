package com.servlets;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ListnerDemo implements ServletContextListener 
{
    public ListnerDemo() 
    {    }
    
    public void contextInitialized(ServletContextEvent sce)  
    { 
    	System.out.println("Context Initialized......"); 
    }

	public void contextDestroyed(ServletContextEvent sce)  
	{ 
		System.out.println("Context Destroyed......");
    }
	
}
