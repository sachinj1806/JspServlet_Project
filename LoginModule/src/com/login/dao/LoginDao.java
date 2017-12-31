package com.login.dao;

import java.sql.*;



public class LoginDao {
	
	
	public boolean checkCredentials(String username,String password) {
		
		String sql="select * from login where uname=? and pass=?;";

		try {
			System.out.println("*******Inside LoginDao class");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("*******After driver registration");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza","root","root");
			System.out.println("*******After connection creation*******");
			PreparedStatement st = con.prepareStatement(sql);
			System.out.println("*******After preparedStatemet*********");
			st.setString(1,username);
			st.setString(2,password);
			System.out.println("*******After setting values***********");
			ResultSet rs = st.executeQuery();
			System.out.println("*******After Resultset execution*******");
			
			if(rs.next())
			{
				return true;
			}
			else return false;

			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		return false;
		
	}

}
