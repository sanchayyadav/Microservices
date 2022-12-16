package com.microservices.company.services.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.company.services.constants.ErrorMessageConstants;
import com.microservices.company.services.entity.Company;
import com.microservices.company.services.exception.EntityNotFoundException;
import com.microservices.company.services.mapper.CompanyMapper;
import com.microservices.company.services.repository.CompanyRepository;
import com.microservices.company.services.request.dto.CompanyRequestDTO;
import com.microservices.company.services.response.dto.CompanyListResponseDTO;
import com.microservices.company.services.response.dto.CompanyResponseDTO;
import com.microservices.company.services.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired 
	private CompanyMapper companyMapper; 
	
	@Override
	@Transactional
	public CompanyResponseDTO createCompany(CompanyRequestDTO companyRequestDTO) {
		
		Company company = companyMapper.mapToCompany(companyRequestDTO);
		
		String randomCompanyId = UUID.randomUUID().toString();
		company.setCompanyid(randomCompanyId);
		companyRepository.save(company);
		
		CompanyResponseDTO companyResponseDTO =  companyMapper.mapToCompanyResponseDTO(company);
		
		return companyResponseDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public CompanyResponseDTO getCompany(String companyId) {

		Company company = this.findById(companyId);
		CompanyResponseDTO companyResponseDTO =  companyMapper.mapToCompanyResponseDTO(company);

		return companyResponseDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public CompanyListResponseDTO getAllCompany() {

		List<Company> companies = companyRepository.findAll();
		if(companies.size()==0)
			throw new EntityNotFoundException(ErrorMessageConstants.ERROR_COMPANY_NOT_FOUND, new ArrayList<>());

		CompanyListResponseDTO companyListResponseDTO = companyMapper.mapToCompanyListResponseDTO(companies);
		return companyListResponseDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public Company findById(String companyId) {
		List<String> errorParameters = new ArrayList<>();
		errorParameters.add(companyId);
		
		Company company = companyRepository.findById(companyId)
									.orElseThrow(() -> new EntityNotFoundException(ErrorMessageConstants.ERROR_COMPANY_ID_NOT_FOUND, errorParameters));
		return company;
	}

}
