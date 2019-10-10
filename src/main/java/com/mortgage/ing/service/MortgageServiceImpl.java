package com.mortgage.ing.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.mortgage.ing.dto.MortgageRequestDto;
import com.mortgage.ing.entity.Customer;
import com.mortgage.ing.entity.Emi;
import com.mortgage.ing.entity.Mortgage;
import com.mortgage.ing.repository.MortgageRepository;
import com.mortgage.ing.util.IngMortgageMessageConstants;
import com.mortgage.ing.util.MailSender;

@Service
public class MortgageServiceImpl implements MortgageService {

	@Autowired
	EmiService emiService;
	@Autowired
	MortgageRepository mortgageRepository;
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private CustomerService customerService;
	
	final Logger lOGGER = LoggerFactory.getLogger(MortgageServiceImpl.class);
	
	@Override
	public Mortgage saveMortgage(MortgageRequestDto mortagageRequestDto) {
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		Mortgage mortgage = new Mortgage();
		BeanUtils.copyProperties(mortagageRequestDto, mortgage);
		mortgage.setMortgageAccountNo(number);
		mortgage.setMortgageStatus(IngMortgageMessageConstants.APPROVED_MORTGAGE_STATUS);
		mortgage.setOutstandingBalance(mortagageRequestDto.getMortgageLoanAmount());
		Mortgage savedMortgage = mortgageRepository.save(mortgage);
		Emi emi = new Emi();
		BeanUtils.copyProperties(mortagageRequestDto, emi);
		emi.setMortgageId(savedMortgage.getMortgagaeId());
		Emi savedEmi = emiService.saveEmi(emi);
		Optional<Customer> customer = customerService.findByCustomerId(mortagageRequestDto.getCustomerId());
		MailSender mailSender = new MailSender();
		try {
			mailSender.sendEmail(javaMailSender, customer.get().getEmailId(), savedMortgage, savedEmi, customer.get().getCustomerName());
		} catch (Exception e) {
			lOGGER.info(IngMortgageMessageConstants.MAIL_TRIGGER_FAILED);
		}
		return savedMortgage;

	}

}
