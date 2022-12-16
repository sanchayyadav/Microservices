package com.microservices.rating.services.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.rating.services.constants.ErrorMessageConstants;
import com.microservices.rating.services.entity.Rating;
import com.microservices.rating.services.exception.EntityNotFoundException;
import com.microservices.rating.services.mapper.RatingMapper;
import com.microservices.rating.services.repository.RatingRepository;
import com.microservices.rating.services.request.dto.RatingRequestDTO;
import com.microservices.rating.services.response.dto.RatingListResponseDTO;
import com.microservices.rating.services.response.dto.RatingResponseDTO;
import com.microservices.rating.services.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingMapper ratingMapper;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	@Transactional
	public RatingResponseDTO createRating(RatingRequestDTO ratingRequestDTO) {

		Rating rating = ratingMapper.mapToRating(ratingRequestDTO);
		String randomUserId = UUID.randomUUID().toString();
		rating.setRatingId(randomUserId);
		ratingRepository.save(rating);
		
		RatingResponseDTO RatingResponseDTO = ratingMapper.mapToRatingResponseDTO(rating);
		
		return RatingResponseDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public RatingListResponseDTO getAllRating() {

		List<Rating> ratings = ratingRepository.findAll();

		if(ratings.size()==0)
			throw new EntityNotFoundException(ErrorMessageConstants.ERROR_RATING_NOT_FOUND, new ArrayList<>());
		
		RatingListResponseDTO ratingResponseDTO = ratingMapper.mapToRatingListResponseDTO(ratings);
		return ratingResponseDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public RatingListResponseDTO getRatingsByUserId(String userId) {

		List<Rating> ratings = ratingRepository.findByUserId(userId);

		if(ratings.size()==0) {
			List<String> errorParameters = new ArrayList<>();
			errorParameters.add(String.valueOf(userId));
			
			throw new EntityNotFoundException(ErrorMessageConstants.ERROR_RATING_NOT_FOUND_FOR_USER_ID, errorParameters);
		}
		RatingListResponseDTO ratingResponseDTO = ratingMapper.mapToRatingListResponseDTO(ratings);
		return ratingResponseDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public RatingListResponseDTO getRatingsByCompanyId(String companyId) {
		List<Rating> ratings = ratingRepository.findByCompanyId(companyId);

		if(ratings.size()==0) {
			List<String> errorParameters = new ArrayList<>();
			errorParameters.add(String.valueOf(companyId));
			
			throw new EntityNotFoundException(ErrorMessageConstants.ERROR_RATING_NOT_FOUND_FOR_COMPANY_ID, errorParameters);
		}
		RatingListResponseDTO ratingResponseDTO = ratingMapper.mapToRatingListResponseDTO(ratings);
		return ratingResponseDTO;
	}

}
