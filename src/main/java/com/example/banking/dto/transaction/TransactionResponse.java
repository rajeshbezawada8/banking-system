package com.example.banking.dto.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {
	private Long transactionId;
	private String fromAccount;
	private String toAccount;
	private BigDecimal amount;
	private String status;
	private LocalDateTime transactionDate;

	public TransactionResponse() {

	}

	public TransactionResponse(Long transactionId, String fromAccount, String toAccount, BigDecimal amount,
			String status, LocalDateTime transactionDate) {
		this.transactionId = transactionId;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.status = status;
		this.transactionDate = transactionDate;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
}
