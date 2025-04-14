package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionClass 
{
	static Connection c=null;
	static PreparedStatement ps;
	public static PreparedStatement getConnection(String query) 
	{
		try 
		{	
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo_mvc","postgres","root");
			ps = c.prepareStatement(query);
			System.out.println("Connection established....");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return ps;
	}
}
