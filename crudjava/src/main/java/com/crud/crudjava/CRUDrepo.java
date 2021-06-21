package com.crud.crudjava;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import org.apache.catalina.User;

public class CRUDrepo {

	String username="root";
	String password="root";
	Connection con=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/maven",username,password);
	
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	List<Users> users;
	public Userrepo() {
		users=new ArrayList<>();
		Users u1=new Users();
		u1.setName("Mustafa");
		u1.setScore(100);
		
		Users u2=new Users();
		u2.setName("Java");
		u2.setScore(30);
		users.add(u1);
		users.add(u2);
	}
	
	public Users getUser(int score) {
		String sql="Select * from users where score="+score;
		try {
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery(sql);
		if(rs.next()) {
			Users u=new Users();
			u.setName(rs.getString(1));
			u.setScore(rs.getInt(2));
			u.setScore(40);
			return u;
		}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	public void create(Users user) {
		String sql="insert into values(?,?,?)";
		 
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,user.getName());
			st.setInt(2, user.getScore());
			st.executeUpdate();
			

			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}

	public List<Users> getUsers() {
		List<Users> u5=new ArrayList<>();
		
		String sql="Select * from users";
		try {
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			Users u=new Users();
			u.setName("Mustafa");
			u.setScore(40);
			
			users.add(u);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public void update(Users u) {
		String sql="update user set name=?, score=?";
		 
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,u.getName());
			st.setInt(2, u.getScore());
			st.executeUpdate();
			

			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}

	public void delete(int score) {
		String sql="delete from users where score=?";
		 
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, score);
			st.executeUpdate();
			

			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}
}
