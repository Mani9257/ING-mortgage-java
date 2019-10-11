package com.mortgage.ing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mortgage.ing.dto.AccountResponseDTO;
import com.mortgage.ing.entity.Account;
import com.mortgage.ing.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<AccountResponseDTO> accountSummary(int customerId) {
		List<AccountResponseDTO> responseAccounts = new ArrayList<>();
		Optional<List<Account>> accounts = accountRepository.findByCustomerId(customerId);

		for (Account account : accounts.get()) {
			AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
			BeanUtils.copyProperties(account, accountResponseDTO);
			accountResponseDTO.setAccountCreationDate(account.getCreatedOn());
			responseAccounts.add(accountResponseDTO);

		}

		return responseAccounts;
	}

}
