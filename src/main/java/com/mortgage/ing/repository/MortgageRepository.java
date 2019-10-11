package com.mortgage.ing.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mortgage.ing.entity.Mortgage;

@Repository
public interface MortgageRepository extends JpaRepository<Mortgage, Integer> {

	Optional<Mortgage> findByCustomerId(Integer customerId);
}
