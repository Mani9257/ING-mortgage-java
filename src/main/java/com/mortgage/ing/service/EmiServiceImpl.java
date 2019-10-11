package com.mortgage.ing.service;

import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mortgage.ing.dto.EmiRequestDto;
import com.mortgage.ing.entity.Emi;
import com.mortgage.ing.repository.EmiRepository;

@Service
public class EmiServiceImpl implements EmiService {

	@Autowired
	EmiRepository emiRespoitory;

	private static final Logger lOGGER = LoggerFactory.getLogger(EmiServiceImpl.class);
	private static DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * @author Shreya E Nair
	 * @param EmiRequestDto object
	 * @method calculateEmi : This method will calculate the emi for the customer based on Loan amount, rate of interest, tenure
	 * @return  eligibleLoanAmount, loanAmount and emi amount
	 */
	@Override
	public Double[] calculateEmi(EmiRequestDto emiRequestDto) {
		Double propertyValue = emiRequestDto.getPropertyValue();
		Double eligibleLoanAmount = propertyValue * 0.80;
		Double depositAmount = emiRequestDto.getDepositAmount();
		Double loanAmount = propertyValue - depositAmount;
		lOGGER.info("={}", loanAmount);
		lOGGER.info("EMI Calculation formula: EMI = P × r × (1 + r)n/((1 + r)n - 1)");
		Float roi = emiRequestDto.getRateOfInterest() / 100;
		Float tenure = emiRequestDto.getTerm() * 12;
		Double emi = (loanAmount * roi * (Math.pow((1 + roi), tenure))) / ((Math.pow((1 + roi), tenure)) - 1);
		Double emiAmount = Double.parseDouble(df.format(emi));
		lOGGER.info("={}", Math.pow((1 + roi), tenure));
		lOGGER.info("={}", (Math.pow((1 + roi), tenure)) - 1);
		lOGGER.info("={}", emi);
		Double[] arr = new Double[3];
		arr[0] = eligibleLoanAmount;
		arr[1] = loanAmount;
		arr[2] = emiAmount;
		return arr;

	}

	@Override
	public Emi saveEmi(Emi emi) {
		return emiRespoitory.save(emi);
	}

}