package com.example.banking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking.dto.transaction.CreateTransactionRequest;
import com.example.banking.dto.transaction.TransactionResponse;
import com.example.banking.service.TransactionService;

@RestController
public class TransactionController {
	private final TransactionService transactionService;

	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@PostMapping("/create-transaction")
	public ResponseEntity<TransactionResponse> createTransaction(
			@RequestBody CreateTransactionRequest transactionRequest) {
		transactionService.createTransaction(transactionRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.createTransaction(transactionRequest));
	}
}
