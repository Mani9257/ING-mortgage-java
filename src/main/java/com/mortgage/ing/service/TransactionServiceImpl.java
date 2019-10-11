package com.mortgage.ing.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mortgage.ing.dto.TransactionResponseDto;
import com.mortgage.ing.entity.Transaction;
import com.mortgage.ing.exception.NoAccountFoundException;
import com.mortgage.ing.repository.TransactionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public List<TransactionResponseDto> getTransactionByAccountNo(Integer accountNo)throws NoAccountFoundException{
		

		List<Transaction> transactionList = transactionRepository.findTransactionByAccountNo(accountNo);
		
		if(transactionList.isEmpty()) {
			throw new NoAccountFoundException("no account with accounNo " +accountNo);
		}
		
		//log.debug("getting data from repository {}", transactionList);
		
		
		List<TransactionResponseDto> transactionResponseDto =
				  transactionList.stream().map(new Function<Transaction,TransactionResponseDto>(){

					@Override
					public TransactionResponseDto apply(Transaction transaction) {
						 return new TransactionResponseDto(transaction.getTransactionId(),transaction.getTransactionType(),transaction.getTransactiondate(),transaction.getTransactionAmount(),transaction.getDescription(),transaction.getAccountNo());}
				  }).collect(Collectors.toList());
				  
				  
		//log.debug("dto conversion done {}",transactionResponseDto);
		return transactionResponseDto;
	}

}
