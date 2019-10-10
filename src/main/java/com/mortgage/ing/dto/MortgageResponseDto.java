package com.mortgage.ing.dto;

public class MortgageResponseDto {
	
	private Integer mortgageId;
	private Long mortgageAccountNo;
	private String message;
	private Integer statusCode;
	public Integer getMortgageId() {
		return mortgageId;
	}
	public void setMortgageId(Integer mortgageId) {
		this.mortgageId = mortgageId;
	}
	public Long getMortgageAccountNo() {
		return mortgageAccountNo;
	}
	public void setMortgageAccountNo(Long mortgageAccountNo) {
		this.mortgageAccountNo = mortgageAccountNo;
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
	
}
