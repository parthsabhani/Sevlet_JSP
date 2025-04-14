package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.model.Student;
import com.util.ConnectionClass;

public class RegistrationDAO 
{	
	Connection c = null;
	
	public int studentRegistration(Student student)
	{
		int x=0;		
		
		String q = "insert into student (firstname, lastname, username, password) values (?,?,?,?)";
		try
		{			
			PreparedStatement ps = ConnectionClass.getConnection(q);
			ps.setString(1, student.getFirstname());
			ps.setString(2, student.getLastname());
			ps.setString(3, student.getUsername());
			ps.setString(4, student.getPassword());
			
			x = ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return x;
	}
}
