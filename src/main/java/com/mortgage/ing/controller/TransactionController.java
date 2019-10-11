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

import lombok.extern.slf4j.Slf4j;

/**
 * @author Abhishek this TransactionController will return transactionList based
 *         on customer account no
 * 
 *
 */
@RestController
@Slf4j
public class TransactionController {

	/***
	 * the TransactionService will call TransactionRepository to get transaction
	 * List
	 */
	@Autowired
	private TransactionService transactionService;

	/***
	 * 
	 * @param accountNo
	 * @return
	 * @throws NoAccountFoundException this getTransaction api will fetch
	 *                                 transaction details based on given account no
	 * 
	 */
	@GetMapping(value = "/accounts/{accountNo}/transactions", produces = "application/json")
	public ResponseEntity<List<TransactionResponseDto>> getTransaction(@PathVariable("accountNo") Long accountNo)
			throws NoAccountFoundException {

		log.info("getting accountNo{}", accountNo);
		return new ResponseEntity<>(transactionService.getTransactionByAccountNo(accountNo), HttpStatus.OK);

	}

}
