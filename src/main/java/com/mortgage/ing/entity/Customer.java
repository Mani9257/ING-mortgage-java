package com.mortgage.ing.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "customer")
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer customerId;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "password")
	private String password;
	@Column(name = "occupation_type")
	private String occupationType;
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	@Column(name = "aadhar_no")
	private Long aadharNo;

}
