package com.microservices.rating.services.service;

import com.microservices.rating.services.request.dto.RatingRequestDTO;
import com.microservices.rating.services.response.dto.RatingListResponseDTO;
import com.microservices.rating.services.response.dto.RatingResponseDTO;

public interface RatingService {

	RatingResponseDTO createRating(RatingRequestDTO ratingRequestDTO);

	RatingListResponseDTO getAllRating();

	RatingListResponseDTO getRatingsByUserId(String userId);

	RatingListResponseDTO getRatingsByCompanyId(String companyId);

}
