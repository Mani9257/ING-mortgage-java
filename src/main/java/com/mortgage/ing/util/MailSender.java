package com.mortgage.ing.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.mortgage.ing.entity.Emi;
import com.mortgage.ing.entity.Mortgage;

public class MailSender {

	public void sendEmail(JavaMailSender javaMailSender, String customerEmailId, Mortgage mortgage, Emi emi, String customerName) {

		// SimpleMailMessage msg = new SimpleMailMessage();
		final Logger lOGGER = LoggerFactory.getLogger(MailSender.class);
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, "utf-8");
		String message = "<html><body>" + "<p>Hi "+customerName+" ,<p>"
				+ "<p>Your mortgage account has been created with ING. Please find the mortgage details below:</p>"
				+ "<p>Mortage ID: " + mortgage.getMortgagaeId() + "</p>" + "<p>Mortage Account Number: "
				+ mortgage.getMortgageAccountNo() + "</p>" + "<p>Property Name: " + mortgage.getPropertyName() + "</p>"
				+ "<p>Property Type: " + mortgage.getPropertyType() + "</p>" + "<p>Property Value: "
				+ mortgage.getPropertyValue() + "</p>" + "<p>Deposit Amount: " + mortgage.getDepositAmount() + "</p>"
				+ "<p>Loan Amount: " + mortgage.getMortgageLoanAmount() + "</p>" + "<p>EMI: " + emi.getEmiAmount()
				+ "<p>" + "<p>Rate Of Interest(%): " + emi.getRateOfInterest() + "</p>" + "<p>Term (years): "
				+ emi.getTerm() + "</p>" 
				+"<p><b>Thanks & Regards<b></p>"
				+"<p><b>ING Bank</b></p>"
				+"</body>" + "</html>";
		try {
			msg.setTo(customerEmailId);
			msg.setSubject("Mortgage account created with ING");
			msg.setText(message, true);
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e1) {
			lOGGER.info(IngMortgageMessageConstants.MAIL_TRIGGER_FAILED);
		}

	}

}
