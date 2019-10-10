package com.mortgage.ing.service;

import com.mortgage.ing.dto.EmiRequestDto;
import com.mortgage.ing.entity.Emi;

public interface EmiService {
	
	public Double[] calculateEmi(EmiRequestDto emiRequestDto);

	public Emi saveEmi(Emi emi);


}
