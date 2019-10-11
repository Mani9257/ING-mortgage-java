package com.mortgage.ing.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mortgage.ing.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("SELECT DISTINCT customerId FROM Customer")
	List<Integer> getDistinctCustomerId();

	Optional<Customer> findByCustomerId(Integer customerId);

}
