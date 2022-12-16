package com.microservices.userservices.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.microservices.userservices.entity.Company;
import com.microservices.userservices.response.dto.CompanyListResponseDTO;
import com.microservices.userservices.response.dto.CompanyResponseDTO;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
	
	CompanyMapper COMPANY = Mappers.getMapper(CompanyMapper.class);

	
	Company mapToCompanyResponseDTO(CompanyResponseDTO companyResponseDTO);

}
