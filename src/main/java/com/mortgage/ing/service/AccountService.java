package com.mortgage.ing.service;

import java.util.List;

import com.mortgage.ing.dto.AccountResponseDTO;

public interface AccountService {

	List<AccountResponseDTO> accountSummary(int customerId);

}
