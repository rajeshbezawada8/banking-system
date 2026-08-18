package com.example.banking.mapper;

import org.mapstruct.Mapper;

import com.example.banking.dto.customer.CreateUserRequest;
import com.example.banking.dto.customer.UserResponse;
import com.example.banking.entity.Customer;

@Mapper(componentModel = "spring")
public interface UserMapper {
	Customer toEntity(CreateUserRequest request);

	UserResponse toResponse(Customer customer);
}
