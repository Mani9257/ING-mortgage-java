package com.mortgage.ing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmiRequestDto {
	
	private Double depositAmount;
	private Double propertyValue;
	private float rateOfInterest;
	private float term;
	
	
}