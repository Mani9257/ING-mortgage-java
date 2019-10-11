package com.mortgage.ing.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mortgage.ing.entity.Customer;

public interface LoginRepository extends JpaRepository<Customer, Integer>{

	Optional<Customer> findByEmailIdAndPassword(String emailId, String decodedPassword);

}
