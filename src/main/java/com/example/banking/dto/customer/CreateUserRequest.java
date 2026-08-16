package com.example.banking.dto.customer;

import java.time.LocalDate;

import com.example.banking.enums.AccountType;

public class CreateUserRequest {

	// Variables required from Customer entity

	private String userId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private LocalDate dateOfBirth;
	private String password;

	// Variables required from Account entity

	private String accountNumber;
	private AccountType accountType;

	public CreateUserRequest() {

	}

	public CreateUserRequest(String userId, String firstName, String lastName, String phoneNumber, String email,
			LocalDate dateOfBirth, String password, String accountNumber, AccountType accountType) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
}
