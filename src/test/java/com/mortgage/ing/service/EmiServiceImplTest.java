package com.mortgage.ing.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.mortgage.ing.dto.EmiRequestDto;
import com.mortgage.ing.entity.Emi;
import com.mortgage.ing.repository.EmiRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmiServiceImplTest {

	@Mock
	EmiRepository emiRespoitory;
	@InjectMocks
	EmiServiceImpl emiServiceImpl;
	EmiRequestDto emiRequestDto = null;
	Double eligibleLoanAmount = null;
	Double emiAmount = null;
	Double loanAmount = null;
	Emi emiDetails = null;

	@Before
	public void setUp() {
		emiRequestDto = new EmiRequestDto();
		emiRequestDto.setDepositAmount(200000.0);
		emiRequestDto.setPropertyValue(1000000.0);
		emiRequestDto.setRateOfInterest(2.7F);
		emiRequestDto.setTerm(10);
		DecimalFormat df = new DecimalFormat("0.00");
		Double propertyValue = emiRequestDto.getPropertyValue();
		eligibleLoanAmount = propertyValue * 0.80;
		Double depositAmount = emiRequestDto.getDepositAmount();
		loanAmount = propertyValue - depositAmount;
		Float roi = 0.8F;/*emiRequestDto.getRateOfInterest() / 100;*/
		Float tenure = emiRequestDto.getTerm() * 12;
		Double emi = (loanAmount * roi * (Math.pow((1 + roi), tenure))) / ((Math.pow((1 + roi), tenure)) - 1);
		emiAmount = Double.parseDouble(df.format(emi));

		emiDetails = new Emi();
		emiDetails.setEmiAmount(emiAmount);
		emiDetails.setEmiId(1);
		emiDetails.setMortgageId(101);
		emiDetails.setRateOfInterest(roi);
		emiDetails.setTerm(tenure);

	}

	@Test
	public void testCalculateEmi() {
		Double arr[] = emiServiceImpl.calculateEmi(emiRequestDto);
		assertNotNull(arr[0]);
		assertEquals(emiAmount, arr[2]);
	}

	@Test
	public void testPositiveSaveEmi() {
		Mockito.when(emiRespoitory.save(Mockito.any())).thenReturn(emiDetails);
		Emi emi = emiServiceImpl.saveEmi(emiDetails);
		assertNotNull(emi);
	}

}