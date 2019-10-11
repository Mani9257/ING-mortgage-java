package com.mortgage.ing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.ing.dto.LoginRequestDto;
import com.mortgage.ing.dto.LoginResponseDTO;
import com.mortgage.ing.service.LoginService;

/**
 * 
 * @author Ajith
 *
 */
@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDto loginRequestDto) {
		LOGGER.info("inside MORTGAGE LOGIN");
		LoginResponseDTO loginResponseDto = loginService.login(loginRequestDto);
		return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
	}

}
