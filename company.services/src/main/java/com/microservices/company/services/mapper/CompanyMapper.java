package com.microservices.company.services.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.microservices.company.services.entity.Company;
import com.microservices.company.services.request.dto.CompanyRequestDTO;
import com.microservices.company.services.response.dto.CompanyListResponseDTO;
import com.microservices.company.services.response.dto.CompanyResponseDTO;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
	
	CompanyMapper COMPANY = Mappers.getMapper(CompanyMapper.class);

	Company mapToCompany(CompanyRequestDTO companyRequestDTO);

	CompanyResponseDTO mapToCompanyResponseDTO(Company company);

	default CompanyListResponseDTO mapToCompanyListResponseDTO(List<Company> companies) {
		 
		CompanyListResponseDTO companyListResponseDTO = new CompanyListResponseDTO();
		
		List<CompanyResponseDTO> companyResponseDTOS = new ArrayList<>();
		
		for(Company company : companies) {
			CompanyResponseDTO companyResponseDTO = this.mapToCompanyResponseDTO(company);
			companyResponseDTOS.add(companyResponseDTO);
		}
		companyListResponseDTO.setCompanyDetails(companyResponseDTOS);
		
		return companyListResponseDTO;
	}

}
