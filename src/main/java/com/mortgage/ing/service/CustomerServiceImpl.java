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
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AccountService accountService;

	/**
	 * @author Shreya E Nair
	 * @param customer id
	 * @method customerMortgageValidation : This method will validate if the customer is eligible to take loan by validating their age, credit score and account type
	 * 
	 */
	@Override
	public String customerMortgageValidation(int customerId) {
		String message = null;
		Optional<Customer> customer = customerRepository.findById(customerId);
		if (customer.isPresent()) {
			Optional<Account> account = accountService.findByCustomerId(customerId);
			if (account.isPresent()) {
				LocalDate start = customer.get().getDateOfBirth();
				LocalDate end = LocalDate.now();
				long years = ChronoUnit.YEARS.between(start, end);
				message = years >= 18 &&  account.get().getCreditScore() >= 700
						&& customer.get().getOccupationType().equalsIgnoreCase("salaried")
								? IngMortgageMessageConstants.VALID
								: IngMortgageMessageConstants.INVALID;

			}
		}
		return message;
	}

	/**
	 * @author Shreya E Nair
	 * @param customer id
	 * @method findByCustomerId : This method will find the customer details by their customer id
	 * 
	 */
	@Override
	public Optional<Customer> findByCustomerId(Integer customerId) {
		return customerRepository.findById(customerId);
	}

}
