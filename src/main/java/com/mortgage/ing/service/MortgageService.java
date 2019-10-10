package com.mortgage.ing.service;

import com.mortgage.ing.dto.MortgageRequestDto;
import com.mortgage.ing.entity.Mortgage;

public interface MortgageService {

	public Mortgage saveMortgage(MortgageRequestDto mortagageRequestDto);

}
