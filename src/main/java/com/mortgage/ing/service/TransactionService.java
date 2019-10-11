package com.mortgage.ing.service;

import java.util.List;

import com.mortgage.ing.dto.TransactionResponseDto;
import com.mortgage.ing.exception.NoAccountFoundException;

public interface TransactionService {
	
	List<TransactionResponseDto> getTransactionByAccountNo(Integer accountNo) throws NoAccountFoundException ;

}
