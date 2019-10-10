package com.mortgage.ing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emi")
public class Emi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emi_id")
	private Integer emiId;
	@Column(name="rate_of_interest")
	private Float rateOfInterest;
	@Column(name="term")
	private Float term;
	@Column(name="emi_amount")
	private Double emiAmount;
	@Column(name="mortgage_id")
	private Integer mortgageId;
	
	public Emi() {
		super();
	}

	public Integer getEmiId() {
		return emiId;
	}

	public void setEmiId(Integer emiId) {
		this.emiId = emiId;
	}

	public Float getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public Float getTerm() {
		return term;
	}

	public void setTerm(Float term) {
		this.term = term;
	}

	public Double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(Double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public Integer getMortgageId() {
		return mortgageId;
	}

	public void setMortgageId(Integer mortgageId) {
		this.mortgageId = mortgageId;
	}

	public Emi(Integer emiId, Float rateOfInterest, Float term, Double emiAmount, Integer mortgageId) {
		super();
		this.emiId = emiId;
		this.rateOfInterest = rateOfInterest;
		this.term = term;
		this.emiAmount = emiAmount;
		this.mortgageId = mortgageId;
	}

	@Override
	public String toString() {
		return "Emi [emiId=" + emiId + ", rateOfInterest=" + rateOfInterest + ", term=" + term + ", emiAmount="
				+ emiAmount + ", mortgageId=" + mortgageId + "]";
	}

}
