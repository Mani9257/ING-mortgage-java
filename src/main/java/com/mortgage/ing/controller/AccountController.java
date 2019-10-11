package com.mortgage.ing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.ing.dto.AccountResponseDTO;
import com.mortgage.ing.service.AccountService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Ajith
 *
 */
@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@Slf4j
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("customers/{customerId}/accounts")
	public ResponseEntity<List<AccountResponseDTO>> accountSummary(@PathVariable int customerId) {
		log.info("accountSummary-->");
		List<AccountResponseDTO> accounts = accountService.accountSummary(customerId);
		return new ResponseEntity<>(accounts, HttpStatus.OK);
	}
}
