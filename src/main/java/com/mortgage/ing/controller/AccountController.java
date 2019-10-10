package com.mortgage.ing.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.ing.dto.AccountResponseDto;

@RestController
public class AccountController {

	@GetMapping("/customers/{customerId}/accounts")
	public ResponseEntity<AccountResponseDto> accountSummary(@PathVariable("customerId") int customerId){
		
		return null;
	}
}
