package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Student;
import com.util.ConnectionClass;

public class LoginDAO 
{
Connection c = null;
	
	public Student studentLogin(String username, String password)
	{
		Student s = null;
		String q = "select sid, firstname, lastname from student where username = ? and password= ?";
		try
		{			
			PreparedStatement ps = ConnectionClass.getConnection(q);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				 s = new Student();
				 
				 s.setSid(rs.getInt("sid"));
                 s.setFirstname(rs.getString("firstname"));
                 s.setLastname(rs.getString("lastname"));
                 s.setUsername(rs.getString("username"));
                 s.setPassword(rs.getString("password"));
                 
			}else {
                System.out.println("Invalid credentials.");
            }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return s;
	}
}
