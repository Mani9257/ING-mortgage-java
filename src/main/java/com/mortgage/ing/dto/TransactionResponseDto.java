package com.mortgage.ing.dto;

import java.time.LocalDate;

public class TransactionResponseDto {

	private Integer transactionId;
	private String transactionType;
	private LocalDate transactiondate;
	private Double transactionAmount;
	private String description;
	private Integer accountNo;

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDate getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(LocalDate transactiondate) {
		this.transactiondate = transactiondate;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "TransactionResponseDto [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", transactiondate=" + transactiondate + ", transactionAmount=" + transactionAmount + ", description="
				+ description + ", accountNo=" + accountNo + "]";
	}

	public TransactionResponseDto(Integer transactionId, String transactionType, LocalDate transactiondate,
			Double transactionAmount, String description, Integer accountNo) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.transactiondate = transactiondate;
		this.transactionAmount = transactionAmount;
		this.description = description;
		this.accountNo = accountNo;
	}

	public TransactionResponseDto() {
		super();
	}

}
