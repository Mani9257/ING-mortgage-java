package com.mortgage.ing.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import com.mortgage.ing.entity.Customer;
import com.mortgage.ing.repository.CustomerRepository;
import com.mortgage.ing.util.IngMortgageMessageConstants;


@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerServiceImplTest {
	
	@Mock
	CustomerRepository customerRepository;
	@Mock
	AccountService accountService;
	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	Customer validCustomer = null;
	Optional<Customer> validCustomerDetails = null;
	Customer invalidCustomer = null;
	Optional<Customer> invalidCustomerDetails = null;
	Account validCustomerAcccount = null;
	Optional<Account> validCustomerAccountDetails = null;
	Account invalidCustomerAccount = null;
	Optional<Account> invalidCustomerAccountDetails = null;
	
	@Before
	public void setUp() {
		validCustomer = new Customer();
		validCustomer.setAadharNo(888866664444L);
		validCustomer.setCustomerId(1);
		validCustomer.setCustomerName("Purabi Sutradar");
		validCustomer.setDateOfBirth(LocalDate.of(1993, 10, 26));
		validCustomer.setEmailId("purabi.s@hcl.com");
		validCustomer.setOccupationType("Salaried");
		validCustomer.setPassword("purabi.s");
	    validCustomerDetails = Optional.of(validCustomer);
		
		validCustomerAcccount = new Account();
		validCustomerAcccount.setAccountNo(8867124205L);
		validCustomerAcccount.setBalance(1000000.0);
		validCustomerAcccount.setCreatedOn(LocalDate.of(2019, 10, 10));
		validCustomerAcccount.setCreditScore(800);
		validCustomerAcccount.setCustomerId(1);
		validCustomerAccountDetails = Optional.of(validCustomerAcccount);
		
		invalidCustomer = new Customer();
		invalidCustomer.setAadharNo(888866664444L);
		invalidCustomer.setCustomerId(1);
		invalidCustomer.setCustomerName("Purabi Sutradar");
		invalidCustomer.setDateOfBirth(LocalDate.of(2016, 10, 26));
		invalidCustomer.setEmailId("purabi.s@hcl.com");
		invalidCustomer.setOccupationType("Salaried");
		invalidCustomer.setPassword("purabi.s");
	    invalidCustomerDetails = Optional.of(invalidCustomer);
		
	    invalidCustomerAccount = new Account();
	    invalidCustomerAccount.setAccountNo(8867124205L);
	    invalidCustomerAccount.setBalance(1000000.0);
	    invalidCustomerAccount.setCreatedOn(LocalDate.of(2019, 10, 10));
	    invalidCustomerAccount.setCreditScore(800);
	    invalidCustomerAccount.setCustomerId(1);
	    invalidCustomerAccountDetails = Optional.of(invalidCustomerAccount);
	}
	
	@Test
	public void testPositiveCustomerMortgageValidation() {
		Mockito.when(customerRepository.findById(Mockito.anyInt())).thenReturn(validCustomerDetails);
		Mockito.when(accountService.findByCustomerId(Mockito.anyInt())).thenReturn(validCustomerAccountDetails);
		String message = customerServiceImpl.customerMortgageValidation(1);
		assertEquals(IngMortgageMessageConstants.VALID,message);
		
	}

	@Test
	public void testNegativeCustomerMortgageValidation() {
		Mockito.when(customerRepository.findById(Mockito.anyInt())).thenReturn(invalidCustomerDetails);
		Mockito.when(accountService.findByCustomerId(Mockito.anyInt())).thenReturn(invalidCustomerAccountDetails);
		String message = customerServiceImpl.customerMortgageValidation(1);
		assertEquals(IngMortgageMessageConstants.INVALID,message);
		
	}
	
	  @Test
	  public void testPositiveFindByCustomerId() {
		  Mockito.when(customerRepository.findById(Mockito.anyInt())).thenReturn(validCustomerDetails);
		  Optional<Customer> customer = customerServiceImpl.findByCustomerId(1);
		  assertNotNull(customer.get());
	  }
	  
	  @Test
	  public void testNegativeFindByCustomerId() {
		  Optional<Customer> customer = Optional.ofNullable(null);
		  Mockito.when(customerRepository.findById(Mockito.anyInt())).thenReturn(customer);
		  Optional<Customer> customerDetails = customerServiceImpl.findByCustomerId(1);
		  assertThat(customerDetails).isEmpty();

	  }
	 

}
