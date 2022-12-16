package com.microservices.company.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.company.services.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

}
