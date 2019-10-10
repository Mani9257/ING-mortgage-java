package com.mortgage.ing.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mortgage.ing.entity.Account;
import com.mortgage.ing.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Optional<Account> findByCustomerId(int customerId) {
		return accountRepository.findByCustomerId(customerId);
	}
	
	

}
