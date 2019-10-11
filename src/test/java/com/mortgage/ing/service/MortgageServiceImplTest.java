package com.mortgage.ing.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.mail.javamail.JavaMailSender;

import com.mortgage.ing.dto.MortgageRequestDto;
import com.mortgage.ing.entity.Customer;
import com.mortgage.ing.entity.Emi;
import com.mortgage.ing.entity.Mortgage;
import com.mortgage.ing.repository.MortgageRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class MortgageServiceImplTest {

	@Mock
	EmiService emiService;
	@Mock
	MortgageRepository mortgageRepository;
	@Mock
	private JavaMailSender javaMailSender;
	@Mock
	private CustomerService customerService;
	@InjectMocks
	MortgageServiceImpl mortgageServiceImpl;
	Mortgage mortgage = null;
	Emi emi = null;
	MortgageRequestDto mortgageRequestDto = null;
	Customer customer = null;
	Optional<Customer> customerDetails = null;
	final Logger lOGGER = LoggerFactory.getLogger(MortgageServiceImpl.class);
	
	@Before
	public void setUp() {
		mortgageRequestDto = new MortgageRequestDto();
		mortgageRequestDto.setCustomerId(1);
		mortgageRequestDto.setDepositAmount(200000.0);
		mortgageRequestDto.setEmiAmount(25000.0);
		mortgageRequestDto.setMortgageLoanAmount(800000.0);
		mortgageRequestDto.setMortgageStatus("Approved");
		mortgageRequestDto.setPropertyName("ABC Mall");
		mortgageRequestDto.setPropertyType("Commercial");
		mortgageRequestDto.setPropertyValue(1000000.0);
		mortgageRequestDto.setRateOfInterest(2.7F);
		mortgageRequestDto.setTerm(10F);
		mortgage = new Mortgage();
		BeanUtils.copyProperties(mortgageRequestDto, mortgage);
		mortgage.setMortgagaeId(101);
		emi = new Emi();
		BeanUtils.copyProperties(mortgageRequestDto, emi);
		emi.setMortgageId(mortgage.getMortgagaeId());
		
		customer = new Customer();
		customer.setAadharNo(888866664444L);
		customer.setCustomerId(1);
		customer.setCustomerName("Purabi Sutradar");
		customer.setDateOfBirth(LocalDate.of(1993, 10, 26));
		customer.setEmailId("purabi.s@hcl.com");
		customer.setOccupationType("Salaried");
		customer.setPassword("purabi.s");
	    customerDetails = Optional.of(customer);
		
	}
	
	@Test	
	public void testPositiveSaveMortgage() {
		Mockito.when(mortgageRepository.save(Mockito.any())).thenReturn(mortgage);
		Mockito.when(emiService.saveEmi(Mockito.any())).thenReturn(emi);
		Mockito.when(customerService.findByCustomerId(Mockito.anyInt())).thenReturn(customerDetails);
		Mortgage mortgageDetails = mortgageServiceImpl.saveMortgage(mortgageRequestDto);
		assertNotNull(mortgageDetails);

	}
	@Test(expected=NullPointerException.class)	
	public void testNegativeSaveMortgage() {
		Mortgage mortgage=null;
		Mockito.when(mortgageRepository.save(Mockito.any())).thenReturn(mortgage);
		Mortgage mortgageDetails = mortgageServiceImpl.saveMortgage(mortgageRequestDto);
		assertNull(mortgageDetails);

	}
	
	
}
