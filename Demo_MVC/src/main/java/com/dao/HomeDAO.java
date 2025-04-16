package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Student;
import com.util.ConnectionClass;

public class HomeDAO 
{
	public Student verifyStudent(int sid)
	{
		Student s = null;
		
		String q = "select * from student where sid=?";
		
		try 
		{
			PreparedStatement ps = ConnectionClass.getConnection(q);
			ps.setInt(1, sid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				s= new Student();
				s.setSid(rs.getInt(1));
				s.setFirstname(rs.getString("firstname"));
				s.setLastname(rs.getString("lastname"));
				s.setUsername(rs.getString("username"));
				s.setPassword(rs.getString("password"));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return s;
	}
	
	public int editStudent(Student s)
	{
		int x=0;
		String q = "update student set firstname=?, lastname=?, username=?, password=? where sid=?";
		
		try
		{
			PreparedStatement ps = ConnectionClass.getConnection(q);
			ps.setString(1, s.getFirstname());
			ps.setString(2, s.getLastname());
			ps.setString(3, s.getUsername());
			ps.setString(4, s.getPassword());
			ps.setInt(5, s.getSid());
			x = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}
	
	public int deleteStudent(int sid)
	{
		int x=0;
		String q = "delete from student where sid=?";
		
		try
		{
			PreparedStatement ps = ConnectionClass.getConnection(q);
			ps.setInt(1, sid);
			x = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}
}
