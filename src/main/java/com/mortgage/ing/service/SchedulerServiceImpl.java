package com.mortgage.ing.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mortgage.ing.entity.Account;
import com.mortgage.ing.entity.Emi;
import com.mortgage.ing.entity.Mortgage;
import com.mortgage.ing.entity.Transaction;
import com.mortgage.ing.repository.AccountRepository;
import com.mortgage.ing.repository.CustomerRepository;
import com.mortgage.ing.repository.EmiRepository;
import com.mortgage.ing.repository.MortgageRepository;
import com.mortgage.ing.repository.TransactionSummaryRepository;
import com.mortgage.ing.util.IngMortgageConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Ajith
 * @desc This service will take care of all transaction from account to mortgage
 *       account
 *
 */
@Service
@Slf4j
@Transactional
public class SchedulerServiceImpl implements SchedulerService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private MailService mailService;

	@Autowired
	private IngMortgageConstants ingMortgageConstants;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private TransactionSummaryRepository txnRepository;

	@Autowired
	private MortgageRepository mortgageRepository;

	@Autowired
	private EmiRepository emiRepository;

	@Override
	public void runTask() {

		log.info("SchedulerServiceImpl :: runTask - starts");

		List<Integer> customerIds = customerRepository.getDistinctCustomerId();
		customerIds.stream().forEach(customerId -> {

			log.info("SchedulerServiceImpl :: runTask - userId : ");

			Account account = accountRepository.findAccountByCustomerId(customerId);
			log.info("inside account={}", account.getAccountNo());
			Mortgage mortgage = mortgageRepository.findMortgageByCustomerId(customerId);
			Emi emi = emiRepository.findByMortgageId(mortgage.getMortgagaeId());

			Float tenure = emi.getTerm() * 12;
			log.info("Tenure in years={}", emi.getTerm());
			log.info("total tenure={}", tenure);

			if (account.getBalance() > emi.getEmiAmount()) {
				if ((mortgage.getOutstandingBalance() - emi.getEmiAmount()) >= 0) {

					mortgage.setOutstandingBalance(mortgage.getOutstandingBalance() - emi.getEmiAmount());
					mortgageRepository.save(mortgage);

					account.setBalance(account.getBalance() - emi.getEmiAmount());
					account.setBalance(account.getBalance() + IngMortgageConstants.MONTHLY_INCOME);
					accountRepository.save(account);

					Transaction accountTransaction = new Transaction();
					accountTransaction.setAccountNo(account.getAccountNo());
					accountTransaction.setTransactionAmount(account.getBalance() - emi.getEmiAmount());
					accountTransaction.setDescription("Savings Account Debit!");
					accountTransaction.setTransactionDate(LocalDateTime.now());
					accountTransaction.setTransactionType("DEBITED");
					txnRepository.save(accountTransaction);

					Transaction mortgageTransaction = new Transaction();
					mortgageTransaction.setAccountNo(mortgage.getMortgageAccountNo());
					mortgageTransaction.setTransactionAmount(mortgage.getOutstandingBalance());
					mortgageTransaction.setDescription("Mortgage Account Credit!");
					mortgageTransaction.setTransactionDate(LocalDateTime.now());
					mortgageTransaction.setTransactionType("CREDITED");
					txnRepository.save(mortgageTransaction);

					tenure--;
					log.info("total remaining tenure={}", tenure);
					emi.setTerm(tenure / 12);
					log.info("latest term={}", emi.getTerm());
					emiRepository.save(emi);
					log.info("latest term in db={}", emi.getTerm());

					int responseTenure = ingMortgageConstants.tenure(tenure);
					if (responseTenure <= 3) {
						mailService.sendEmail("ayyanarajith7@gmail.com", "Last " + tenure + "month EMI is peding");
					}
				}
			}

		});

		log.info("SchedulerServiceImpl :: runTask - END");
	}
}
