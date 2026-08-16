package com.example.banking.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.catalina.valves.LoadBalancerDrainingValve;
import org.springframework.stereotype.Service;

import com.example.banking.dto.customer.CreateUserRequest;
import com.example.banking.dto.customer.UpdateUserRequest;
import com.example.banking.dto.customer.UserResponse;
import com.example.banking.entity.Account;
import com.example.banking.entity.Customer;
import com.example.banking.enums.AccountType;
import com.example.banking.enums.CustomerStatus;
import com.example.banking.repository.AccountRepository;
import com.example.banking.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepo;
	private AccountRepository accountRepo;

	public CustomerServiceImpl(CustomerRepository customerRepo, AccountRepository accountRepo) {
		this.customerRepo = customerRepo;
		this.accountRepo = accountRepo;
	}

	@Override
	public UserResponse createUser(CreateUserRequest request) {
		Customer customer = new Customer();
		Account account = new Account();
		customer.setUserId(request.getUserId());
		customer.setFirstName(request.getFirstName());
		customer.setLastName(request.getLastName());
		customer.setPhoneNumber(request.getPhoneNumber());
		customer.setEmail(request.getEmail());
		customer.setDateOfBirth(request.getDateOfBirth());
		customer.setPassword(request.getPassword());
		customer.setCustomerStatus(CustomerStatus.ACTIVE);
		customer.setLastLogin(LocalDateTime.now());
		account.setAccountNumber(request.getAccountNumber());
		account.setAccountType(AccountType.SAVING);
		account.setBalance(BigDecimal.ZERO);
		customer.setAccount(account);
		Customer save = customerRepo.save(customer);
		accountRepo.save(account);
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
