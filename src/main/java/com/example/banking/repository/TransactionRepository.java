package com.example.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banking.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
