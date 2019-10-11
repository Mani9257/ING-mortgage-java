package com.mortgage.ing.service;

import java.util.List;
import java.util.Optional;

import com.mortgage.ing.dto.AccountResponseDTO;
import com.mortgage.ing.entity.Account;

public interface AccountService {
	public Optional<Account> findByCustomerId(int customerId);

	List<AccountResponseDTO> accountSummary(int customerId);

}
