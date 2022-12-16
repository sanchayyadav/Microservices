package com.microservices.rating.services.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.microservices.rating.services.entity.Rating;
import com.microservices.rating.services.request.dto.RatingRequestDTO;
import com.microservices.rating.services.response.dto.RatingListResponseDTO;
import com.microservices.rating.services.response.dto.RatingResponseDTO;

@Mapper(componentModel = "spring")
public interface RatingMapper {

	RatingMapper RATING = Mappers.getMapper(RatingMapper.class);
	Rating mapToRating(RatingRequestDTO ratingRequestDTO);

	RatingResponseDTO mapToRatingResponseDTO(Rating rating);

	default RatingListResponseDTO mapToRatingListResponseDTO(List<Rating> ratings) {
		
		RatingListResponseDTO ratingListResponseDTO = new RatingListResponseDTO();
		
		List<RatingResponseDTO> ratingResponseDTOs = new ArrayList<>();
		
		for(Rating rating : ratings) {
			RatingResponseDTO ratingResponseDTO = this.mapToRatingResponseDTO(rating);
			ratingResponseDTOs.add(ratingResponseDTO);
		}
		
		ratingListResponseDTO.setRatingDetails(ratingResponseDTOs);
		return ratingListResponseDTO;
	}

}
