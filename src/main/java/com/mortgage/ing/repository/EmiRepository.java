package com.mortgage.ing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mortgage.ing.entity.Emi;

public interface EmiRepository extends JpaRepository<Emi, Integer> {

	Emi findByMortgageId(Integer mortgagaeId);

	Emi findByTerm(Float term);

}
