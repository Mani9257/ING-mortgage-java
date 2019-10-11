package com.mortgage.ing.ingmortgage.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mortgage.ing.controller.LoginController;
import com.mortgage.ing.dto.LoginRequestDto;
import com.mortgage.ing.dto.LoginResponseDTO;
import com.mortgage.ing.service.LoginServiceimpl;


@RunWith(SpringJUnit4ClassRunner.class)
public class LoginControllerTest {

	
	
	@InjectMocks
	LoginController loginControllerMock;

	private MockMvc mockMvc;
	
	@Mock
	LoginServiceimpl loginServiceimpl;
	
	@Before
	public void setUp() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(loginControllerMock).build();
	}

	
	
	
	
	@Test
	public void testLogin() {

		LoginResponseDTO loginResponseDto=new LoginResponseDTO();
		loginResponseDto.setMessage("Login Success");
	
		loginResponseDto.setStatusCode(200);
		
		when(loginServiceimpl.login(Mockito.any())).thenReturn(loginResponseDto);
		
		LoginRequestDto loginRequestDto=new LoginRequestDto();
		loginRequestDto.setPassword("ok");
		loginRequestDto.setEmailId("ayyanarajith7@gmail.com");
		ResponseEntity<LoginResponseDTO> actual=loginControllerMock.login(loginRequestDto);
		
		
		assertEquals(200, actual.getStatusCodeValue());
		assertEquals("Login Success", actual.getBody().getMessage());
	
	}

}
