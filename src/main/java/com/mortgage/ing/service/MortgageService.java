package com.mortgage.ing.service;

import com.mortgage.ing.dto.MortgageRequestDto;
import java.util.Optional;
import com.mortgage.ing.entity.Mortgage;

public interface MortgageService {

	Optional<Mortgage> getMortgageDetailsByCustomerId(Integer customerId);

	public Mortgage saveMortgage(MortgageRequestDto mortagageRequestDto);

}
