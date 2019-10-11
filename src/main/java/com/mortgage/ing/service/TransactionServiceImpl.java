package com.mortgage.ing.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mortgage.ing.dto.TransactionResponseDto;
import com.mortgage.ing.entity.Account;
import com.mortgage.ing.entity.Customer;
import com.mortgage.ing.entity.Mortgage;
import com.mortgage.ing.entity.Transaction;
import com.mortgage.ing.exception.NoAccountFoundException;
import com.mortgage.ing.repository.AccountRepository;
import com.mortgage.ing.repository.MortgageRepository;
import com.mortgage.ing.repository.TransactionRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Abhishek
 *
 */
@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

	/***
	 * this transactionRepository will get transaction list based on customeAccNo
	 */
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	CustomerService customerService;
	/***
	 * this mortgageRepository will get mortgage details based on customerId we will
	 * get customerId from accountRepository
	 */

	@Autowired
	private MortgageRepository mortgageRepository;

	/***
	 * this accountRepository will get account details based on customerAccNo
	 */
	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<TransactionResponseDto> getTransactionByAccountNo(Long accountNo) throws NoAccountFoundException {

		log.info("getting account no{}", accountNo);
		Optional<Account> findById = accountRepository.findById(accountNo);

		log.info("getting account details{}", findById.get());

		Integer cid = 0;
		if (findById.isPresent()) {
			Account account = findById.get();
			Optional<Customer> customer = customerService
					.findByCustomerId(account.getCustomerId());/* account.getCustomer(); */
			if (customer.isPresent()) {
				cid = customer.get().getCustomerId();
			}
		} else {
			throw new NoAccountFoundException("no account with accounNo " + accountNo);
		}

		log.debug("customer id is{}", cid);

		List<Transaction> transactionList = transactionRepository.findTransactionByAccountNo(accountNo);

		if (transactionList.isEmpty()) {
			throw new NoAccountFoundException("no account with accounNo " + accountNo);
		}

		Optional<Mortgage> findByCustomerId = mortgageRepository.findByCustomerId(cid);
		Mortgage mortgage = null;
		if (findByCustomerId.isPresent()) {
			mortgage = findByCustomerId.get();
		}

		Long mortgageAccountNo = mortgage.getMortgageAccountNo();

		log.debug("getting data from repository {}", transactionList);

		List<TransactionResponseDto> transactionResponseDto = transactionList.stream()
				.map(new Function<Transaction, TransactionResponseDto>() {

					@Override
					public TransactionResponseDto apply(Transaction transaction) {
						return new TransactionResponseDto(transaction.getTransactionId(),
								transaction.getTransactionType(), transaction.getTransactionDate(),
								transaction.getTransactionAmount(), transaction.getDescription(),
								transaction.getAccountNo(), mortgageAccountNo);
					}
				}).collect(Collectors.toList());

		log.debug("dto conversion done {}", transactionResponseDto);

		return transactionResponseDto;
	}

}
