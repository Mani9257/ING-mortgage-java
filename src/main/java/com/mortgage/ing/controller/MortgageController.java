package com.mortgage.ing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.ing.dto.MortgageRequestDto;
import com.mortgage.ing.dto.MortgageResponseDto;
import com.mortgage.ing.entity.Mortgage;
import com.mortgage.ing.exception.ResponseDto;
import com.mortgage.ing.service.CustomerService;
import com.mortgage.ing.service.MortgageService;
import com.mortgage.ing.util.IngMortgageMessageConstants;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class MortgageController {

	@Autowired
	CustomerService customerService;
	@Autowired
	MortgageService mortgageService;

	/**
	 * @author Shreya E Nair
	 * @param customer id
	 * @method customerMortgageValidation : This method will validate if the customer is eligible to take loan by validating their age, credit score and account type
	 * @return  ResponseDto object
	 */
	@GetMapping("/customers/{customerId}/mortgages")
	public ResponseEntity<ResponseDto> customerMortgageValidation(@PathVariable("customerId") int customerId) {
		String message = customerService.customerMortgageValidation(customerId);
		ResponseDto responseDto = new ResponseDto();
		if (message.equalsIgnoreCase(IngMortgageMessageConstants.INVALID)) {
			responseDto.setMessage(IngMortgageMessageConstants.CUSTOMER_NOT_APPLICABLE_FOR_MORTGAGE);
			responseDto.setStatusCode(400);
			return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
		} else {
			responseDto.setMessage(IngMortgageMessageConstants.CUSTOMER_APPLICABLE_FOR_MORTGAGE);
			responseDto.setStatusCode(200);
			return new ResponseEntity<>(responseDto, HttpStatus.OK);
		}
	}	
	

	/**
	 * @author Shreya E Nair
	 * @param MortgageRequestDto object
	 * @method saveMortgage : This method will save the mortgage details applied by a customer
	 * @return  MortgageResponseDto object
	 */
	@PostMapping("/mortgages")
	public ResponseEntity<MortgageResponseDto> saveMortgage(@RequestBody MortgageRequestDto mortagageRequestDto) {
		Mortgage mortgage = mortgageService.saveMortgage(mortagageRequestDto);
		MortgageResponseDto mortgageResponseDto= new MortgageResponseDto();
		mortgageResponseDto.setMessage(IngMortgageMessageConstants.MORTGAGE_ACCOUNT_CREATED);
		mortgageResponseDto.setStatusCode(200);
		mortgageResponseDto.setMortgageId(mortgage.getMortgagaeId());
		mortgageResponseDto.setMortgageAccountNo(mortgage.getMortgageAccountNo());
		return new ResponseEntity<>(mortgageResponseDto, HttpStatus.OK);
		
	}

}