package com.mortgage.ing.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mortgage.ing.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

	Optional<List<Account>> findByCustomerId(Integer customerId);

	Account findAccountByCustomerId(Integer customerId);

}
