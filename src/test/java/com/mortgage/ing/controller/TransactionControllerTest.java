package com.mortgage.ing.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mortgage.ing.dto.TransactionResponseDto;
import com.mortgage.ing.entity.Transaction;
import com.mortgage.ing.service.TransactionServiceImpl;

@RunWith(SpringRunner.class)
public class TransactionControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	TransactionController transactionController;

	@Mock
	TransactionServiceImpl transactionServiceImpl;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(transactionController).build();
	}

	@Test
	public void testGetTransactions() throws Exception {

		Transaction transaction = new Transaction();

		transaction.setAccountNo(111);
		transaction.setDescription("emi for loan");
		transaction.setTransactionAmount(10000d);
		transaction.setTransactiondate(LocalDate.now());
		transaction.setTransactionId(1);
		transaction.setTransactionType("debited");

		Transaction transaction2 = new Transaction();

		transaction2.setAccountNo(111);
		transaction2.setDescription("emi for loan");
		transaction2.setTransactionAmount(20000d);
		transaction2.setTransactiondate(LocalDate.now());
		transaction2.setTransactionId(2);
		transaction2.setTransactionType("debited");

		List<Transaction> transactionList = new ArrayList<>();

		transactionList.add(transaction);
		transactionList.add(transaction2);

		TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
		transactionResponseDto.setAccountNo(111);
		transactionResponseDto.setDescription("emi for loan");
		transactionResponseDto.setTransactionAmount(10000d);
		transactionResponseDto.setTransactiondate(LocalDate.now());
		transactionResponseDto.setTransactionId(1);
		transactionResponseDto.setTransactionType("debited");

		TransactionResponseDto transactionResponseDto1 = new TransactionResponseDto();
		transactionResponseDto1.setAccountNo(111);
		transactionResponseDto1.setDescription("emi for loan");
		transactionResponseDto1.setTransactionAmount(10000d);
		transactionResponseDto1.setTransactiondate(LocalDate.now());
		transactionResponseDto1.setTransactionId(2);
		transactionResponseDto1.setTransactionType("debited");

		List<TransactionResponseDto> transactionResponseDtoList = new ArrayList<>();
		transactionResponseDtoList.add(transactionResponseDto);
		transactionResponseDtoList.add(transactionResponseDto1);

		Mockito.when(transactionServiceImpl.getTransactionByAccountNo(111)).thenReturn(transactionResponseDtoList);
		mockMvc.perform(MockMvcRequestBuilders.get("/accounts/111/transactions"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

}
