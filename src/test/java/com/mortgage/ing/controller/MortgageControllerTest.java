package com.mortgage.ing.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;

import com.mortgage.ing.dto.MortgageRequestDto;
import com.mortgage.ing.dto.MortgageResponseDto;
import com.mortgage.ing.entity.Mortgage;
import com.mortgage.ing.exception.ResponseDto;
import com.mortgage.ing.service.CustomerService;
import com.mortgage.ing.service.MortgageService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class MortgageControllerTest {

	@Mock
	CustomerService customerService;
	@Mock
	MortgageService mortgageService;
	@InjectMocks
	MortgageController mortgageController;
	MortgageRequestDto mortgageRequestDto = null;
	Mortgage mortgage = null;
	MortgageResponseDto mortgageResponseDto = null;

	@Before
	public void setUp() {
		mortgageRequestDto = new MortgageRequestDto();
		mortgageRequestDto.setCustomerId(1);
		mortgageRequestDto.setDepositAmount(200000.0);
		mortgageRequestDto.setEmiAmount(25000.0);
		mortgageRequestDto.setMortgageLoanAmount(800000.0);
		mortgageRequestDto.setMortgageStatus("Approved");
		mortgageRequestDto.setPropertyName("ABC Mall");
		mortgageRequestDto.setPropertyType("Commercial");
		mortgageRequestDto.setPropertyValue(1000000.0);
		mortgageRequestDto.setRateOfInterest(2.7F);
		mortgageRequestDto.setTerm(10F);
		mortgage = new Mortgage();
		BeanUtils.copyProperties(mortgageRequestDto, mortgage);
		mortgage.setMortgagaeId(101);
		mortgage.setMortgageAccountNo(9980153177L);

	}

	@Test
	public void testPositiveCustomerMortgageValidation() {
		Mockito.when(customerService.customerMortgageValidation(Mockito.anyInt())).thenReturn("valid");
		ResponseEntity<ResponseDto> responseDto = mortgageController.customerMortgageValidation(1);
		ResponseDto responseBody = responseDto.getBody();
		assertEquals(200, responseBody.getStatusCode().intValue());
	}

	@Test
	public void testNegativeCustomerMortgageValidation() {
		Mockito.when(customerService.customerMortgageValidation(Mockito.anyInt())).thenReturn("invalid");
		ResponseEntity<ResponseDto> responseDto = mortgageController.customerMortgageValidation(1);
		ResponseDto responseBody = responseDto.getBody();
		assertEquals(400, responseBody.getStatusCode().intValue());
	}

	@Test
	public void testSaveMortgage() {
		Mockito.when(mortgageService.saveMortgage(Mockito.any())).thenReturn(mortgage);
		ResponseEntity<MortgageResponseDto> mortgageResponseDto = mortgageController.saveMortgage(mortgageRequestDto);
		assertEquals(200, mortgageResponseDto.getStatusCode().value());

	}

}