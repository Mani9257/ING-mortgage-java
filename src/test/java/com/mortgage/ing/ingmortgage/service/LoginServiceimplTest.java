package com.mortgage.ing.ingmortgage.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.mortgage.ing.dto.LoginRequestDto;
import com.mortgage.ing.dto.LoginResponseDTO;
import com.mortgage.ing.entity.Account;
import com.mortgage.ing.entity.Customer;
import com.mortgage.ing.repository.AccountRepository;
import com.mortgage.ing.repository.LoginRepository;
import com.mortgage.ing.service.LoginServiceimpl;

@RunWith(SpringRunner.class)
public class LoginServiceimplTest {

	@InjectMocks
	LoginServiceimpl loginServiceImpl;

	@Mock
	LoginRepository loginRepository;
	AccountRepository accountRepository;

	LoginRequestDto loginRequestDto;
	Customer customer;
	Account account;

	LoginResponseDTO loginResponseDto;

	@Before
	public void init() {
		
		customer =new  Customer();
		customer.setEmailId("ayyanar@gmail.com");
		customer.setPassword("ajith");
		customer.setCustomerId(1);
		customer.setCustomerName("Ajith");

		loginRequestDto = new LoginRequestDto();
		loginRequestDto.setPassword("Ajith");
		loginRequestDto.setEmailId("ayyanar@gmail.com");

		loginResponseDto = new LoginResponseDTO();
		loginResponseDto.setStatusCode(200);
		loginResponseDto.setCusomerId(1);
		loginResponseDto.setCustomerName("Ajith");
		loginResponseDto.setMessage("Logged in successfully");

	}

	@Test
	public void login() {

		Mockito.when(loginRepository.findByEmailIdAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Optional.of(customer));
		LoginResponseDTO loginResponseDto = loginServiceImpl.login(loginRequestDto);
		Assert.assertEquals(loginResponseDto.getCustomerName(), customer.getCustomerName());
		Assert.assertEquals(loginResponseDto.getCusomerId(),customer.getCustomerId());
	}

}
