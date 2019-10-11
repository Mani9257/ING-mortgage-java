package com.mortgage.ing.service;

import com.mortgage.ing.dto.LoginRequestDto;
import com.mortgage.ing.dto.LoginResponseDTO;

/**
 * 
 * @author Ajith
 *
 */
public interface LoginService {

	LoginResponseDTO login(LoginRequestDto loginRequestDto);

}
