package com.mortgage.ing.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mortgage.ing.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	Optional<Account> findByCustomerId(int customerId);

}
