package com.mortgage.ing.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@Column(name = "account_no")
	private Long accountNo;
	@Column(name = "balance")
	private Double balance;
	@Column(name = "created_on")
	private LocalDate createdOn;
	@Column(name = "credit_score")
	private Integer creditScore;
	@Column(name = "customer_id") 
	private Integer customerId;
	/*
	 * @OneToOne(cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn(name="customer_id") private Customer customer;
	 */

	/*
	 * public Customer getCustomer() { return customer; }
	 * 
	 * public void setCustomer(Customer customer) { this.customer = customer; }
	 */

	public Account() {
		super();
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

}
