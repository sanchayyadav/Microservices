package com.microservices.rating.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.rating.services.request.dto.RatingRequestDTO;
import com.microservices.rating.services.response.dto.RatingListResponseDTO;
import com.microservices.rating.services.response.dto.RatingResponseDTO;
import com.microservices.rating.services.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	
	@PostMapping(value="",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<RatingResponseDTO> createRating(@RequestBody RatingRequestDTO ratingRequestDTO){
		
		RatingResponseDTO RatingResponseDTO = ratingService.createRating(ratingRequestDTO);
		
		return new ResponseEntity<>(RatingResponseDTO, HttpStatus.CREATED);
	}
	
	@GetMapping(value="",
			produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<RatingListResponseDTO> getAllRating(){
		
		RatingListResponseDTO RatingListResponseDTO = ratingService.getAllRating();

		return new ResponseEntity<>(RatingListResponseDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/users/{userId}")
	ResponseEntity<RatingListResponseDTO> getRatingsByUserId(@PathVariable String userId){
		
		RatingListResponseDTO RatingListResponseDTO = ratingService.getRatingsByUserId(userId);

		return new ResponseEntity<>(RatingListResponseDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/companies/{companyId}")
	ResponseEntity<RatingListResponseDTO> getRatingsByCompanyId(@PathVariable String companyId){
		
		RatingListResponseDTO RatingListResponseDTO = ratingService.getRatingsByCompanyId(companyId);

		return new ResponseEntity<>(RatingListResponseDTO, HttpStatus.OK);
	}
}
