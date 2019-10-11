package com.mortgage.ing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mortgage.ing.entity.Transaction;

public interface TransactionSummaryRepository extends JpaRepository<Transaction, Integer> {

}
