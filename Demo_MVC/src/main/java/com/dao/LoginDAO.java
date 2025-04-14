package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.ConnectionClass;

public class LoginDAO 
{
Connection c = null;
	
	public int studentLogin(String username, String password)
	{
		int x=0;		
		
		String q = "select sid, firstname, lastname from student where username = ? and password= ?";
		try
		{			
			PreparedStatement ps = ConnectionClass.getConnection(q);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				 int sid = rs.getInt("sid");
                 String fname = rs.getString("firstname");
                 String lname = rs.getString("lastname");

                 System.out.println("Login successful for: " + fname + " " + lname);
                 x =1;
			}else {
                System.out.println("Invalid credentials.");
            }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return x;
	}
}
