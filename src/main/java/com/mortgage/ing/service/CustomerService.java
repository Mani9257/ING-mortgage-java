package com.mortgage.ing.service;

import java.util.Optional;

import com.mortgage.ing.entity.Customer;

public interface CustomerService {

	public String customerMortgageValidation(int customerId);

	public Optional<Customer> findByCustomerId(Integer customerId);

}
