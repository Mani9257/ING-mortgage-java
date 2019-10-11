package com.mortgage.ing.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.mortgage.ing.entity.Account;
import com.mortgage.ing.repository.AccountRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountServiceImplTest {

	@Mock
	AccountRepository accountRepository;
	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	Account account = null;

	@Before
	public void setUp() {
		account = new Account();
		account.setAccountNo(8867124205L);
		account.setBalance(1000000.0);
		account.setCreatedOn(LocalDate.of(2019, 10, 10));
		account.setCreditScore(550);
		account.setCustomerId(1);
	}

	@Test
	public void testPositiveFindByCustomerId() {
		Mockito.when(accountRepository.findByCustomerId(Mockito.anyInt())).thenReturn(Optional.of(account));
		Optional<Account> accountDetails = accountServiceImpl.findByCustomerId(1);
		assertEquals(account.getCreditScore(), accountDetails.get().getCreditScore());
	}

	@Test
	public void testNegativeFindByCustomerId() {
		Optional<Account> account = Optional.ofNullable(null);
		Mockito.when(accountRepository.findByCustomerId(Mockito.anyInt())).thenReturn(account);
		Optional<Account> accountDetails = accountServiceImpl.findByCustomerId(1);
		assertThat(accountDetails).isEmpty();
	}


}
