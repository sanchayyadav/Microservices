package com.microservices.userservices.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.userservices.response.dto.CompanyResponseDTO;

@FeignClient(name = "COMPANY-SERVICES")
public interface CompanyService {

	@GetMapping(value = "/{companyId}")
	CompanyResponseDTO getCompany(@PathVariable String userId);
}