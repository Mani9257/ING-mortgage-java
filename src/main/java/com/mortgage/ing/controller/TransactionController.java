package com.mortgage.ing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.ing.dto.TransactionResponseDto;
import com.mortgage.ing.exception.NoAccountFoundException;
import com.mortgage.ing.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping(value = "/accounts/{accountNo}/transactions", produces = "application/json")
	public ResponseEntity<List<TransactionResponseDto>> getTransaction(@PathVariable("accountNo") Integer accountNo)
			throws NoAccountFoundException {
		return new ResponseEntity<>(transactionService.getTransactionByAccountNo(accountNo),
				HttpStatus.OK);
	}

}
