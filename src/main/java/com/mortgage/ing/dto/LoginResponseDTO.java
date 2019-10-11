package com.mortgage.ing.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LoginResponseDTO {
	private String message;
	private Integer statusCode;
	private Integer cusomerId;
	private String customerName;

}
