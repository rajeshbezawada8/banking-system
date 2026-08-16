package com.example.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banking.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
