package com.mortgage.ing.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author abhishek
 *
 */
/**
 * this transaction entity will capture transaction info
 *
 */
@Entity
@Table(name = "transaction")
public class Transaction {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	private String transactionType;
	private LocalDate transactiondate;
	private Double transactionAmount;
	private String description;
	private Long accountNo;

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

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", transactiondate=" + transactiondate + ", transactionAmount=" + transactionAmount + ", description="
				+ description + ", accountNo=" + accountNo + "]";
	}

	public Transaction(Integer transactionId, String transactionType, LocalDate transactiondate,
			Double transactionAmount, String description, Long accountNo) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.transactiondate = transactiondate;
		this.transactionAmount = transactionAmount;
		this.description = description;
		this.accountNo = accountNo;
	}

	public Transaction() {
		super();
	}

}
