package com.mortgage.ing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mortgage")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Mortgage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mortgage_id")
	private Integer mortgagaeId;
	@Column(name = "mortgage_account_no")
	private Long mortgageAccountNo;
	@Column(name = "mortgage_loan_amount")
	private Double mortgageLoanAmount;
	@Column(name = "property_name")
	private String propertyName;
	@Column(name = "property_type")
	private String propertyType;
	@Column(name = "property_value")
	private Double propertyValue;
	@Column(name = "mortgage_status")
	private String mortgageStatus;
	@Column(name = "outstanding_balance")
	private Double outstandingBalance;
	@Column(name = "deposit_amount")
	private Double depositAmount;
	@Column(name = "customer_id")
	private Integer customerId;

}
