package com.microservices.rating.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.rating.services.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {

	List<Rating> findByUserId(String userId);

	List<Rating> findByCompanyId(String companyId);

}
