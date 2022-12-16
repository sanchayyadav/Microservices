package com.microservices.company.services.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.HttpHeaders;

@RestController
@RequestMapping("/employees")
public class EmployessController {

	@GetMapping(value="")
	public ResponseEntity<List<String>> getEmployees(){
		List<String> employees = Arrays.asList("Sanchay", "Ajay", "Shubham");
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
}
