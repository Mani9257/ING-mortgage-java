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
@Table(name = "emi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Emi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emi_id")
	private Integer emiId;
	@Column(name = "rate_of_interest")
	private Float rateOfInterest;
	@Column(name = "term")
	private Float term;
	@Column(name = "emi_amount")
	private Double emiAmount;

	@Column(name = "mortgage_id")
	private Integer mortgageId;

}
