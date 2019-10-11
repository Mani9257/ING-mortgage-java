package com.mortgage.ing.util;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class IngMortgageConstants {
	
	public static final String CUSTOMER_NOT_APPLICABLE_FOR_MORTGAGE ="Customer is not applicable for mortgage";
	public static final String CUSTOMER_APPLICABLE_FOR_MORTGAGE ="Customer is applicable for mortgage";
	public static final String VALID = "valid";
	public static final String INVALID = "invalid";
	public static final String LOGIN_SUCCESSFUL_MESSASGE="Logged in successful";
	public static final Integer HTTPSTATUS_OK_VALUE= HttpStatus.OK.value();
	public static final Integer HTTPSTATUS_CREATED_VALUE=HttpStatus.CREATED.value();
	public static final Integer HTTPSTATUS_BADREQUEST_VALUE=HttpStatus.BAD_REQUEST.value();
	public static final String INVALID_CREDENTIALS_MESSAGE="EmailId/Password is incorrect";
	public static final Integer MONTHLY_INCOME=300000;
	public static final String MORTGAGE_AMOUNT_CLEARED="Your Mortgage debt has been cleared";
	public static final String ACCOUNT_BALANCE_INSUFFICIENT="your account balance is insufficient to pay the emi";
	
	public int tenure(float tenure) {
		int responseTenure= (int)tenure;
		return responseTenure;
		
	}
	
}
