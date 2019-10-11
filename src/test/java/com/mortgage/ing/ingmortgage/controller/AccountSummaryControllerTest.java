package com.mortgage.ing.ingmortgage.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mortgage.ing.controller.AccountController;
import com.mortgage.ing.dto.AccountResponseDTO;
import com.mortgage.ing.service.AccountServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccountSummaryControllerTest {

	@InjectMocks
	AccountController accountSummaryController;

	private MockMvc mockMvc;

	@Mock
	AccountServiceImpl accountServiceimpl;

	@Before
	public void setUp() {

		mockMvc = MockMvcBuilders.standaloneSetup(accountSummaryController).build();
	}

	@Test
	public void testAccountSummary() throws JsonProcessingException, Exception {

		List<AccountResponseDTO> list = new ArrayList<>();
		AccountResponseDTO accountSummaryResponseDto = new AccountResponseDTO();
		accountSummaryResponseDto.setAccountCreationDate(LocalDate.now());
		accountSummaryResponseDto.setAccountNo(876487678234l);
		accountSummaryResponseDto.setBalance(245454545.5);
		accountSummaryResponseDto.setCreditScore(757);
		list.add(accountSummaryResponseDto);
		when(accountServiceimpl.accountSummary(Mockito.anyInt())).thenReturn(list);
		mockMvc.perform(MockMvcRequestBuilders.get("api/customers/1/accounts").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(new ObjectMapper().writeValueAsString(""))).andReturn();

		ResponseEntity<List<AccountResponseDTO>> actual = accountSummaryController.accountSummary(1);
		assertEquals(200, actual.getStatusCodeValue());

	}

}
