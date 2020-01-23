package com.foodapp.controller;

import java.util.Scanner;

import com.foodapp.repository.AuthenticationRepository;

public class AuthenticationController {

	Scanner sc = new Scanner(System.in);
	AuthenticationRepository authenticationRepository = new AuthenticationRepository();
	
	public void login(){
		System.out.print("Enter your email: ");
		String email = sc.nextLine();
		System.out.print("Enter your password: ");
		String password = sc.nextLine();
		authenticationRepository.login(email, password);
	}
	public void register(){
		System.out.print("Enter your email: ");
		String email = sc.nextLine();
		System.out.print("Enter your password: ");
		String password = sc.nextLine();
		System.out.print("Enter your FirstName: ");
		String firstname = sc.nextLine();
		System.out.print("Enter your Lastname: ");
		String lastname = sc.nextLine();
		System.out.print("Enter your phone number: ");
		String phoneNumber = sc.nextLine();
		Integer rows = authenticationRepository.register(email, password,firstname,lastname,phoneNumber);
		if (rows>0){
			System.out.println("Successfully regitered,please proceed to login");
		}else{
			System.out.println("some error occured while registration,please try again later ");
		}
	}
}
