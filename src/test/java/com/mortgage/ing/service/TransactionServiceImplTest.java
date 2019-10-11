package com.mortgage.ing.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mortgage.ing.dto.TransactionResponseDto;
import com.mortgage.ing.entity.Transaction;
import com.mortgage.ing.exception.NoAccountFoundException;
import com.mortgage.ing.repository.TransactionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionServiceImplTest {

	@Mock
	TransactionRepository transactionRepository;
	@InjectMocks
	TransactionServiceImpl transactionServiceImpl;

	@Test
	public void testGetTransactionByAccountNo() throws NoAccountFoundException {

		Transaction transaction = new Transaction();
		transaction.setAccountNo(2298);
		transaction.setDescription("emi for property loan ");
		transaction.setTransactiondate(LocalDate.now());
		transaction.setTransactionId(1);
		transaction.setTransactionType("debited");
		transaction.setTransactionAmount(100000d);

		List<Transaction> transactionList = new ArrayList<>();
		transactionList.add(transaction);

		Mockito.when(transactionRepository.findTransactionByAccountNo(2298)).thenReturn(transactionList);

		List<TransactionResponseDto> transactionByAccountNo = transactionServiceImpl.getTransactionByAccountNo(2298);

		List<TransactionResponseDto> responseTransactionDto = new ArrayList<>();
		for (Transaction t : transactionList) {
			TransactionResponseDto transactionResponseDto = new TransactionResponseDto();

			BeanUtils.copyProperties(t, transactionResponseDto);

			responseTransactionDto.add(transactionResponseDto);

		}

		assertEquals(responseTransactionDto.get(0).getAccountNo(), transactionByAccountNo.get(0).getAccountNo());

	}

}
