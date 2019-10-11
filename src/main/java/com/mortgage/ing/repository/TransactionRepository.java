package com.mortgage.ing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mortgage.ing.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findTransactionByAccountNo(Long accountNo);

}
