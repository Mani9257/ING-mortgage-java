package com.mortgage.ing.service;

import java.util.Optional;

import com.mortgage.ing.entity.Account;

public interface AccountService {

	public Optional<Account> findByCustomerId(int customerId);

}
