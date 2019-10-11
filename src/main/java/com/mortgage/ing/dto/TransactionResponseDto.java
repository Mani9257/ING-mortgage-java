package com.mortgage.ing.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class TransactionResponseDto {

	private Integer transactionId;
	private String transactionType;
	private LocalDateTime transactiondate;
	private Double transactionAmount;
	private String description;
	private Long accountNo;
	private Long mortgageAccountNo;

}
