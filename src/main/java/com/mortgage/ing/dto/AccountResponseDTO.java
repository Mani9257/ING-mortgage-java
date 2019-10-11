package com.mortgage.ing.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AccountResponseDTO {
	private long accountNo;
	private Double balance;
	private LocalDate accountCreationDate;
	private int creditScore;


}
