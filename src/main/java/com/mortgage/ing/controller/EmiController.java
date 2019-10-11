package com.mortgage.ing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mortgage.ing.dto.EmiRequestDto;
import com.mortgage.ing.dto.EmiResponseDto;
import com.mortgage.ing.service.EmiService;
import com.mortgage.ing.util.IngMortgageMessageConstants;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class EmiController {

	@Autowired
	EmiService emiService;

	/**
	 * @author Shreya E Nair
	 * @param EmiRequestDto object
	 * @method calculateEmi : This method will calculate the emi for the customer
	 *         based on Loan amount, rate of interest, tenure
	 * @return EmiResponseDto object
	 */
	@PostMapping("/emi")
	public ResponseEntity<EmiResponseDto> calculateEmi(@RequestBody EmiRequestDto emiRequestDto) {
		EmiResponseDto emiResponseDto = new EmiResponseDto();
		Double[] arr = emiService.calculateEmi(emiRequestDto);
		emiResponseDto.setEligibleLoanAmount(arr[0]);
		emiResponseDto.setActualLoanAmount(arr[1]);
		emiResponseDto.setEmiAmount(arr[2]);
		emiResponseDto.setStatusCode(200);
		emiResponseDto.setMessage(IngMortgageMessageConstants.VALID_DEPOSIT_AMOUNT);
		return new ResponseEntity<>(emiResponseDto, HttpStatus.OK);
	}

}
