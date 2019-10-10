package com.mortgage.ing.dto;

public class EmiResponseDto {
	
	private Double emiAmount;
	private Double actualLoanAmount;
	private String message;
	private Integer statusCode;
	private Double eligibleLoanAmount;
	
	public Double getEmiAmount() {
		return emiAmount;
	}
	public void setEmiAmount(Double emiAmount) {
		this.emiAmount = emiAmount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public Double getActualLoanAmount() {
		return actualLoanAmount;
	}
	public void setActualLoanAmount(Double actualLoanAmount) {
		this.actualLoanAmount = actualLoanAmount;
	}
	public Double getEligibleLoanAmount() {
		return eligibleLoanAmount;
	}
	public void setEligibleLoanAmount(Double eligibleLoanAmount) {
		this.eligibleLoanAmount = eligibleLoanAmount;
	}
	
	
}
