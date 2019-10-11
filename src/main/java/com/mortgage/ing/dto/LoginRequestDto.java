package com.mortgage.ing.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LoginRequestDto {
	private String emailId;
	private String password;

}
