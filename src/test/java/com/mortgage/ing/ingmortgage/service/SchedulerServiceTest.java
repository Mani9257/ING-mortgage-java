
package com.mortgage.ing.ingmortgage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.mortgage.ing.entity.Account;
import com.mortgage.ing.entity.Emi;
import com.mortgage.ing.entity.Mortgage;
import com.mortgage.ing.repository.AccountRepository;
import com.mortgage.ing.repository.CustomerRepository;
import com.mortgage.ing.repository.EmiRepository;
import com.mortgage.ing.repository.MortgageRepository;
import com.mortgage.ing.service.SchedulerServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SchedulerServiceTest {

	@Mock
	private AccountRepository accountRepository;

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private MortgageRepository mortgageRepository;

	@Mock
	private EmiRepository emiRepository;

	@InjectMocks
	private SchedulerServiceImpl schedulerServiceImpl;

	List<Integer> customerIds = new ArrayList<>();
	List<Account> listAccounts = new ArrayList<>();
	Account savingsAccount = new Account();
	Mortgage mortgageAccount = new Mortgage();
	Emi emi = new Emi();

	@Test
	public void testRunTask() {
		customerIds.add(1233);
		emi.setEmiAmount(12344.8);
		emi.setTerm(1.0f);
		mortgageAccount.setOutstandingBalance(7654654556.8);
		mortgageAccount.setMortgagaeId(1);
		savingsAccount.setBalance(7678756.8);
		listAccounts.add(savingsAccount);

		Mockito.when(customerRepository.getDistinctCustomerId()).thenReturn(customerIds);
		Mockito.when(accountRepository.findByCustomerId(Mockito.anyInt())).thenReturn(Optional.of(listAccounts));
		Mockito.when(mortgageRepository.findByCustomerId(Mockito.anyInt())).thenReturn(mortgageAccount);
		Mockito.when(emiRepository.findByMortgageId(Mockito.anyInt())).thenReturn(emi);
	
	}
}
