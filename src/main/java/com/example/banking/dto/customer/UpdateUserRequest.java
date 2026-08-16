package com.example.banking.dto.customer;

public class UpdateUserRequest {
	private String phoneNumber;
	private String email;

	public UpdateUserRequest() {

	}

	public UpdateUserRequest(String phoneNumber, String email) {
		this.phoneNumber = phoneNumber;
		this.email = email;
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
}
