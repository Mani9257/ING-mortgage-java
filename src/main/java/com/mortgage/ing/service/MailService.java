package com.mortgage.ing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService {

	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(String emailId, String message) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(emailId);
		mail.setSubject("IngMortgage");

		mail.setText(" IngMortgageEmi \n " + message);
		javaMailSender.send(mail);
	}

}