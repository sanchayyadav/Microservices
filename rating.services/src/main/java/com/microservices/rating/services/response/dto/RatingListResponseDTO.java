package com.microservices.rating.services.response.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RatingListResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 8933859268418874907L;
	List<RatingResponseDTO> ratingDetails;
}
