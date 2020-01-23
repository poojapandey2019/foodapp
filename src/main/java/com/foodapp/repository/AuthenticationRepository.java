package com.foodapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AuthenticationRepository {
	
	Connection connection;
	PreparedStatement preparedStatement;
	
	public void login(String email, String password){
		try{
			String sqlQuery = "SELECT * FROM customer WHERE EmailId='"+email+"' AND Password='"+password+"'"; 
			connection = DBConnection.makeJDBCConnection();
			preparedStatement = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next() == false){
				System.out.println("Invalid email or password!");
			}else{	
				do{
					String fname = resultSet.getString("FirstName");
					String lname = resultSet.getString("LastName");
					String phone = resultSet.getString("PhoneNumber");
					System.out.println("Welcome "+fname+" "+lname);
				}
				while(resultSet.next());
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	public Integer register(String email,String password,String firstname,String lastname,String phonenumber){
		Integer rows = 0;
		try{
			String sqlQuery= "INSERT INTO Customer(emailId,password,firstname,lastname,phonenumber) VALUES"
					+ " ('"+email+"','"+password+"','"+firstname+"','"+lastname+"','"+phonenumber+"')";
			connection= DBConnection.makeJDBCConnection();
			preparedStatement = connection.prepareStatement(sqlQuery);
			rows = preparedStatement.executeUpdate();
		}catch (Exception ex){
			ex.printStackTrace();
		}
		
		return rows;
	}

}
