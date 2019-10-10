package com.mortgage.ing.dto;

public class MortgageRequestDto {
	
	private Integer customerId;
	private String propertyName;
	private String propertyType;
	private Double propertyValue;
	private Float term;
	private Float rateOfInterest;
	private Double emiAmount;
	private String mortgageStatus;
	private Double depositAmount;
	private Double mortgageLoanAmount;
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
	public Float getTerm() {
		return term;
	}
	public void setTerm(Float term) {
		this.term = term;
	}
	public Float getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(Float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public String getMortgageStatus() {
		return mortgageStatus;
	}
	public void setMortgageStatus(String mortgageStatus) {
		this.mortgageStatus = mortgageStatus;
	}
	public Double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public Double getMortgageLoanAmount() {
		return mortgageLoanAmount;
	}
	public void setMortgageLoanAmount(Double mortgageLoanAmount) {
		this.mortgageLoanAmount = mortgageLoanAmount;
	}
	public Double getEmiAmount() {
		return emiAmount;
	}
	public void setEmiAmount(Double emiAmount) {
		this.emiAmount = emiAmount;
	}
}
