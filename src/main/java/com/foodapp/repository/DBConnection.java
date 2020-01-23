package com.foodapp.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	static Connection connection;

	public static Connection makeJDBCConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapp", "root", "");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return connection;
	}
}
