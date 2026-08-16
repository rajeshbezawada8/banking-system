package com.example.banking.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking.dto.customer.CreateUserRequest;
import com.example.banking.service.CustomerService;

@RestController
public class AccountController {
	
	private CustomerService customerService;

	public AccountController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping("/createAccount")
	public String createAccount(@RequestBody CreateUserRequest request) {
		try {
			customerService.createUser(request);
		}
		catch(Exception e) {
			return "error occoured ->"+ e.getMessage();
		}
		return "Insertion Successful";
	}
	
	
}