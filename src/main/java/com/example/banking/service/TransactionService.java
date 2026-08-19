package com.example.banking.service;

import com.example.banking.dto.transaction.CreateTransactionRequest;
import com.example.banking.dto.transaction.TransactionResponse;

public interface TransactionService {
	public TransactionResponse createTransaction(CreateTransactionRequest transactionRequest);
}