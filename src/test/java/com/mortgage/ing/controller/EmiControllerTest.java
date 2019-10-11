package com.mortgage.ing.controller;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import com.mortgage.ing.dto.EmiRequestDto;
import com.mortgage.ing.dto.EmiResponseDto;
import com.mortgage.ing.service.EmiService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmiControllerTest {

	@Mock
	EmiService emiService;
	@InjectMocks
	EmiController emiController;
	EmiRequestDto emiRequestDto = null;
	Double arr[] = null;

	@Before
	public void setUp() {
		emiRequestDto = new EmiRequestDto();
		emiRequestDto.setDepositAmount(200000.0);
		emiRequestDto.setPropertyValue(1000000.0);
		emiRequestDto.setRateOfInterest(2.7F);
		emiRequestDto.setTerm(10);

		arr = new Double[3];
		arr[0] = 800000.0;
		arr[1] = 600000.0;
		arr[2] = 20500.0;

	}

	@Test public void calculateEmi() {
	  Mockito.when(emiService.calculateEmi(Mockito.any())).thenReturn(arr);
	  ResponseEntity<EmiResponseDto> emiResponseDto = emiController.calculateEmi(emiRequestDto); 
	  assertEquals(200, emiResponseDto.getBody().getStatusCode().intValue()) ;
	
	 }

}
