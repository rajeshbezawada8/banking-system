package com.example.banking.service.implementation;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.banking.dto.transaction.CreateTransactionRequest;
import com.example.banking.dto.transaction.TransactionResponse;
import com.example.banking.entity.Account;
import com.example.banking.entity.Transaction;
import com.example.banking.enums.TransactionType;
import com.example.banking.repository.AccountRepository;
import com.example.banking.repository.TransactionRepository;
import com.example.banking.service.TransactionService;

import jakarta.transaction.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {
	private final AccountRepository accountRepository;
	private final TransactionRepository transactionRepository;

	public TransactionServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
		this.accountRepository = accountRepository;
		this.transactionRepository = transactionRepository;
	}

	@Override
	@Transactional
	public TransactionResponse createTransaction(CreateTransactionRequest transactionRequest) {
		// Source account validation

		Account fromAccount = accountRepository.findByAccountNumber(transactionRequest.getFromAccount()).orElseThrow(
				() -> new RuntimeException("Source account is not found: " + transactionRequest.getFromAccount()));

		// Destination account validation

		Account toAccount = accountRepository.findByAccountNumber(transactionRequest.getToAccount()).orElseThrow(
				() -> new RuntimeException("Destination account is not found: " + transactionRequest.getToAccount()));

		// Prevent transfer to same account

		if (transactionRequest.getFromAccount().equals(transactionRequest.getToAccount())) {
			throw new RuntimeException("Source and destination accounts cannot be the same");
		}

		if (transactionRequest.getAmount() == null || transactionRequest.getAmount().signum() <= 0) {
			throw new RuntimeException("Amount must be greater than zero");
		}

		// Balance validation

		if (fromAccount.getBalance().compareTo(transactionRequest.getAmount()) < 0) {
			throw new RuntimeException("Insufficient balance");
		}

		// Debit from source account

		fromAccount.setBalance(fromAccount.getBalance().subtract(transactionRequest.getAmount()));

		// Credit to destination account

		toAccount.setBalance(toAccount.getBalance().add(transactionRequest.getAmount()));

		accountRepository.save(fromAccount);
		accountRepository.save(toAccount);

		LocalDateTime transactionDate = LocalDateTime.now();

		Transaction FromTransaction = new Transaction();
		FromTransaction.setAccount(fromAccount);
		FromTransaction.setAmount(transactionRequest.getAmount());
		FromTransaction.setTransactionType(TransactionType.DEBIT);
		FromTransaction.setTransactionDate(transactionDate);

		Transaction toTransaction = new Transaction();
		toTransaction.setAccount(toAccount);
		toTransaction.setAmount(transactionRequest.getAmount());
		toTransaction.setTransactionType(TransactionType.CREDIT);
		toTransaction.setTransactionDate(transactionDate);

		transactionRepository.save(FromTransaction);
		transactionRepository.save(toTransaction);

		return new TransactionResponse(toTransaction.getId(), fromAccount.getAccountNumber(),
				toAccount.getAccountNumber(), toTransaction.getAmount(), "Success", transactionDate);
	}

}