package com.microservices.company.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerProperties.HealthCheck;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.company.services.request.dto.CompanyRequestDTO;
import com.microservices.company.services.response.dto.CompanyListResponseDTO;
import com.microservices.company.services.response.dto.CompanyResponseDTO;
import com.microservices.company.services.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService; 
	
	private final HealthCheck health = new HealthCheck();


    @GetMapping("/status")
    public String status() {
        return "status: " + health.getRepeatHealthCheck();
    }
	@PostMapping(value = "",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyResponseDTO> createCompany(@RequestBody CompanyRequestDTO companyRequestDTO){
		
		CompanyResponseDTO CompanyResponseDTO = companyService.createCompany(companyRequestDTO);
		
		return new ResponseEntity<> (CompanyResponseDTO, HttpStatus.CREATED); 
	}
	
	@GetMapping(value="/{companyId}",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyResponseDTO> getCompany(@PathVariable String companyId){
		
		CompanyResponseDTO CompanyResponseDTO = companyService.getCompany(companyId);
		
		return new ResponseEntity<> (CompanyResponseDTO, HttpStatus.OK); 
	}
	
	@GetMapping(value="",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyListResponseDTO> getAllCompany(){
		
		CompanyListResponseDTO companyListResponseDTO = companyService.getAllCompany();
		
		return new ResponseEntity<> (companyListResponseDTO, HttpStatus.OK); 
	}
}
