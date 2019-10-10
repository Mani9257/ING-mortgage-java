package com.mortgage.ing.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mortgage.ing.entity.Account;
import com.mortgage.ing.entity.Customer;
import com.mortgage.ing.repository.CustomerRepository;
import com.mortgage.ing.util.IngMortgageMessageConstants;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AccountService accountService;
	
	@Override
	public String customerMortgageValidation(int customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		Optional<Account> account = accountService.findByCustomerId(customerId);
		LocalDate start = customer.get().getDateOfBirth();
		LocalDate end = LocalDate.now();
		long years = ChronoUnit.YEARS.between(start, end);
		String message = years>=18 && account.get().getCreditScore()>=18 &&
				account.get().getCreditScore()<=700 && customer.get().getOccupationType().equalsIgnoreCase("salaried")
				?IngMortgageMessageConstants.VALID:IngMortgageMessageConstants.INVALID;
		return message;
	}

	@Override
	public Optional<Customer> findByCustomerId(Integer customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		return customer;
	}

}
