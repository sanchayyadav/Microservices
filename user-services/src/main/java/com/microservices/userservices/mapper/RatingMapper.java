package com.microservices.userservices.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.microservices.userservices.entity.Rating;
import com.microservices.userservices.response.dto.RatingResponseDTO;

@Mapper(componentModel = "spring")
public interface RatingMapper {

	RatingMapper RATING = Mappers.getMapper(RatingMapper.class);
	
//	Rating mapToRating(RatingResponseDTO ratingResponseDTO);

	List<Rating> mapToRating(List<RatingResponseDTO> list) ;
//	{
//		
//		List<RatingListResponseDTO> ratingListResponseDTOs = new ArrayList<>();
//		
//		Rating rating = new Rating();
//		
//		for(RatingResponseDTO ratingListResponseDTO_ : ratingListResponseDTO.getRatingDetails()) {
//			Rating ratingResponseDTO = this.mapToRating(ratingListResponseDTO_);
//			rating.setRating(ratingResponseDTO);
//
//			ratingListResponseDTOs.addAll(ratingResponseDTO);
//		}
//		
//		rating.setRating(ratingListResponseDTOs);
//		return ratingListResponseDTOs;
	}