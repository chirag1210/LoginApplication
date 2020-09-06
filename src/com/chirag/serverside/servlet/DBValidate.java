package com.chirag.serverside.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBValidate {

	public static boolean validate(String username, String password) {

		boolean status = false;

		try {
			Class.forName("com.mysql.jdbc.Driver");
            
			//pass database name userloginapplication
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userloginapplication", "root",
					"admin");

			PreparedStatement preparedStatement = con
					.prepareStatement("select * from user where username=? and password=?");

			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}
}
