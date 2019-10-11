package com.mortgage.ing.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mortgage.ing.dto.LoginRequestDto;
import com.mortgage.ing.dto.LoginResponseDTO;
import com.mortgage.ing.entity.Customer;
import com.mortgage.ing.exception.InvalidCredentialsException;
import com.mortgage.ing.repository.LoginRepository;
import com.mortgage.ing.util.IngMortgageConstants;

/**
 * 
 * @author Sushil
 *
 */
@Service
public class LoginServiceimpl implements LoginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceimpl.class);

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	IngMortgageConstants ingMortgageConstants;

	public LoginResponseDTO login(LoginRequestDto loginRequestDto) {
		LOGGER.info("inside LoginServiceImpl of logincontroller");
		LoginResponseDTO loginResponseDto = new LoginResponseDTO();
		Optional<Customer> login = loginRepository.findByEmailIdAndPassword(loginRequestDto.getEmailId(),
				loginRequestDto.getPassword());

		if (login.isPresent()) {
			loginResponseDto.setMessage(IngMortgageConstants.LOGIN_SUCCESSFUL_MESSASGE);
			loginResponseDto.setStatusCode(HttpStatus.OK.value());
			loginResponseDto.setCusomerId(login.get().getCustomerId());
			loginResponseDto.setCustomerName(login.get().getCustomerName());
		} else {
			throw new InvalidCredentialsException(IngMortgageConstants.INVALID_CREDENTIALS_MESSAGE);
		}
		return loginResponseDto;
	}
}
