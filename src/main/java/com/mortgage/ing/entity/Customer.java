package com.mortgage.ing.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Integer customerId;
	@Column(name="customer_name")
	private String customerName;
	@Column(name="email_id")
	private String emailId;
	@Column(name="password")
	private String password;
	@Column(name="occupation_type")
	private String occupationType;
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	@Column(name="aadhar_no")
	private Long aadharNo;
	@OneToOne(mappedBy="customer")
	private Account account;
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOccupationType() {
		return occupationType;
	}
	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Customer() {
		super();
	}
	public Customer(Integer customerId, String customerName, String emailId, String password, String occupationType,
			LocalDate dateOfBirth, Long aadharNo, Account account) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.emailId = emailId;
		this.password = password;
		this.occupationType = occupationType;
		this.dateOfBirth = dateOfBirth;
		this.aadharNo = aadharNo;
		this.account = account;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", emailId=" + emailId
				+ ", password=" + password + ", occupationType=" + occupationType + ", dateOfBirth=" + dateOfBirth
				+ ", aadharNo=" + aadharNo + ", account=" + account + "]";
	}
	
}
