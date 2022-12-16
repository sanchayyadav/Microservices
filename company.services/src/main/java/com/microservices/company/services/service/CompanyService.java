package com.microservices.company.services.service;

import com.microservices.company.services.entity.Company;
import com.microservices.company.services.request.dto.CompanyRequestDTO;
import com.microservices.company.services.response.dto.CompanyListResponseDTO;
import com.microservices.company.services.response.dto.CompanyResponseDTO;

public interface CompanyService {

	CompanyResponseDTO createCompany(CompanyRequestDTO companyRequestDTO);

	CompanyResponseDTO getCompany(String companyId);

	CompanyListResponseDTO getAllCompany();

	Company findById(String companyId);
	
	//TODO: update
	//TODO: delete
}
