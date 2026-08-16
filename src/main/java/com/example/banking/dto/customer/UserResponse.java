package com.example.banking.dto.customer;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.banking.enums.CustomerStatus;

public class UserResponse {
	private String userId;
	private String first_name;
	private String last_name;
	private String phoneNumber;
	private LocalDate dateOfbirth;
	private CustomerStatus customerStatus;
	private LocalDateTime createdAt;
	private LocalDateTime lastLogin;
	
	public UserResponse() {
		
	}

	public UserResponse(String userId, String first_name, String last_name, String phoneNumber, LocalDate dateOfbirth,
			CustomerStatus customerStatus, LocalDateTime createdAt, LocalDateTime lastLogin) {
		this.userId = userId;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phoneNumber = phoneNumber;
		this.dateOfbirth = dateOfbirth;
		this.customerStatus = customerStatus;
		this.createdAt = createdAt;
		this.lastLogin = lastLogin;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfbirth() {
		return dateOfbirth;
	}

	public void setDateOfbirth(LocalDate dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}

	public CustomerStatus getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(CustomerStatus customerStatus) {
		this.customerStatus = customerStatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
}
