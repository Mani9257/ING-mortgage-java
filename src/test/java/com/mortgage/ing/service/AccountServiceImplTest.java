package com.mortgage.ing.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mortgage.ing.dto.AccountResponseDTO;
import com.mortgage.ing.entity.Account;
import com.mortgage.ing.entity.Customer;
import com.mortgage.ing.repository.AccountRepository;
import com.mortgage.ing.repository.CustomerRepository;
import com.mortgage.ing.service.AccountServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceImplTest {

	@Mock
	private AccountRepository accountRespository;

	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private AccountServiceImpl accountServiceimpl;

	@Test
	public void accountSummaryTest() {

		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("Ajith");

		Account account = new Account();
		account.setAccountNo(8797687687L);
		account.setBalance(18876867.9);
		account.setCreatedOn(LocalDate.now());
		account.setCustomerId(1);
		account.setCreditScore(768);

		List<Account> listAcount = new ArrayList<>();
		listAcount.add(account);

		when(accountRespository.findByCustomerId(Mockito.anyInt())).thenReturn(Optional.of(listAcount));
		List<AccountResponseDTO> AccountSummaryResponseDto = accountServiceimpl.accountSummary(1);
		AccountSummaryResponseDto.get(0).setCreditScore(account.getCreditScore());
		assertEquals(8797687687L, AccountSummaryResponseDto.get(0).getAccountNo());

	}

}
