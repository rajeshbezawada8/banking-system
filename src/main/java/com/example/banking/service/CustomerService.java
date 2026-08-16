package com.example.banking.service;

import com.example.banking.dto.customer.CreateUserRequest;
import com.example.banking.dto.customer.UpdateUserRequest;
import com.example.banking.dto.customer.UserResponse;

public interface CustomerService {
	public UserResponse createUser(CreateUserRequest request);

	public UserResponse updateUser(UpdateUserRequest request);

	public UserResponse getUser(String userId);

	public String deleteUser(String userId);
}
