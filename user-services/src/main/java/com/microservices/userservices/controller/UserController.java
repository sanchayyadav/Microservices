package com.microservices.userservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.userservices.request.dto.UserRequestDTO;
import com.microservices.userservices.response.dto.UserListResponseDTO;
import com.microservices.userservices.response.dto.UserResponseDTO;
import com.microservices.userservices.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired 
	private UserService userService;
	
	@PostMapping(value="",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO){
		
		UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);
		
	    return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/{userId}",
			produces=MediaType.APPLICATION_JSON_VALUE)
	@CircuitBreaker(name = "companyRatingBreaker", fallbackMethod = "companyRatingBreakerFallback")
	public ResponseEntity<UserResponseDTO> getUsers(@PathVariable String userId){
		
		UserResponseDTO userResponseDTO = userService.getUser(userId);

	    return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserListResponseDTO> getAllUsers(){
		
		UserListResponseDTO userResponseDTO = userService.getAllUsers();
		
	    return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
	}
	
	public ResponseEntity<UserResponseDTO> companyRatingBreakerFallback(String user, Exception ex){
		UserResponseDTO userResponseDTO = UserResponseDTO.
														builder()
														.userId("5458-sudebadinf-sjdhb4jbjb-u")
														.email("sanchayyadav@gmail.com")
														.name("sanchay")
														.about("from India")
														.build();
		
		return new ResponseEntity<UserResponseDTO>(userResponseDTO, HttpStatus.OK);
	}
	
}
