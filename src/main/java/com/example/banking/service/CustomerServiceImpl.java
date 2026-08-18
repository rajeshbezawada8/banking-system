package com.example.banking.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.banking.dto.customer.CreateUserRequest;
import com.example.banking.dto.customer.UpdateUserRequest;
import com.example.banking.dto.customer.UserResponse;
import com.example.banking.entity.Account;
import com.example.banking.entity.Customer;
import com.example.banking.enums.CustomerStatus;
import com.example.banking.mapper.UserMapper;
import com.example.banking.repository.AccountRepository;
import com.example.banking.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepo;
	private AccountRepository accountRepo;
	private final UserMapper userMapper;

	public CustomerServiceImpl(CustomerRepository customerRepo, AccountRepository accountRepo, UserMapper userMapper) {
		this.customerRepo = customerRepo;
		this.accountRepo = accountRepo;
		this.userMapper = userMapper;
	}

	@Override
	@Transactional
	public UserResponse createUser(CreateUserRequest request) {
		Customer customer = userMapper.toEntity(request);
		customer.setCustomerStatus(CustomerStatus.ACTIVE);
		customer.setLastLogin(LocalDateTime.now());
		customer.setCreatedAt(LocalDateTime.now());

		Account account = new Account();

		account.setAccountNumber(request.getAccountNumber());
		account.setAccountType(request.getAccountType());

		customer.setAccount(account);

		accountRepo.save(account);
		Customer save = customerRepo.save(customer);

		return convertToResponse(save);
	}

	@Override
	public UserResponse updateUser(UpdateUserRequest request) {
		Customer customer = new Customer();
		customer.setPhoneNumber(request.getPhoneNumber());
		customer.setEmail(request.getEmail());
		return convertToResponse(customer);
	}

	@Override
	public UserResponse getUser(String userId) {
		Optional<Customer> byId = customerRepo.findById(userId);
		if (!byId.isPresent()) {
			System.out.println("There is not user with " + byId);
		}

		Customer customer = byId.get();
		return convertToResponse(customer);
	}

	@Override
	public String deleteUser(String userId) {
		Optional<Customer> byId = customerRepo.findById(userId);
		if (!byId.isPresent()) {
			System.out.println("There is not user with " + byId);
		}
		Customer customer = byId.get();
		customerRepo.deleteById(userId);
		return customer + " is deleted";
	}

	private UserResponse convertToResponse(Customer customer) {
		return new UserResponse(customer.getUserId(), customer.getFirstName(), customer.getLastName(),
				customer.getPhoneNumber(), customer.getDateOfBirth(), customer.getCustomerStatus(),
				customer.getCreatedAt(), customer.getLastLogin());

	}
}
