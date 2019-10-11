package com.mortgage.ing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mortgage")
public class Mortgage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mortgage_id")
	private Integer mortgagaeId;
	@Column(name = "mortgage_account_no")
	private Long mortgageAccountNo;
	@Column(name = "mortgage_loan_amount")
	private Double mortgageLoanAmount;
	@Column(name = "property_name")
	private String propertyName;
	@Column(name = "property_type")
	private String propertyType;
	@Column(name = "property_value")
	private Double propertyValue;
	@Column(name = "mortgage_status")
	private String mortgageStatus;
	@Column(name = "outstanding_balance")
	private Double outstandingBalance;
	@Column(name = "deposit_amount")
	private Double depositAmount;
	@Column(name="customer_id")
	private Integer customerId;

	public Mortgage() {
		super();
	}
	
	public Integer getMortgagaeId() {
		return mortgagaeId;
	}

	public void setMortgagaeId(Integer mortgagaeId) {
		this.mortgagaeId = mortgagaeId;
	}

	public Long getMortgageAccountNo() {
		return mortgageAccountNo;
	}

	public void setMortgageAccountNo(Long mortgageAccountNo) {
		this.mortgageAccountNo = mortgageAccountNo;
	}

	public Double getMortgageLoanAmount() {
		return mortgageLoanAmount;
	}

	public void setMortgageLoanAmount(Double mortgageLoanAmount) {
		this.mortgageLoanAmount = mortgageLoanAmount;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public Double getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(Double propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getMortgageStatus() {
		return mortgageStatus;
	}

	public void setMortgageStatus(String mortgageStatus) {
		this.mortgageStatus = mortgageStatus;
	}

	public Double getOutstandingBalance() {
		return outstandingBalance;
	}

	public void setOutstandingBalance(Double outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}

	public Double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Mortgage [mortgagaeId=" + mortgagaeId + ", mortgageAccountNo=" + mortgageAccountNo
				+ ", mortgageLoanAmount=" + mortgageLoanAmount + ", propertyName=" + propertyName + ", propertyType="
				+ propertyType + ", propertyValue=" + propertyValue + ", mortgageStatus=" + mortgageStatus
				+ ", outstandingBalance=" + outstandingBalance + ", depositAmount=" + depositAmount + ", customerId="
				+ customerId + "]";
	}

}
