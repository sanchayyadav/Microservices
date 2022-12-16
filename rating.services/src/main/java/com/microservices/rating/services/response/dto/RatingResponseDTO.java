package com.microservices.rating.services.response.dto;

import java.io.Serializable;

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
public class RatingResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 4533859268358874907L;
	private String ratingId;

	private String userId;

	private String companyId;

	private Integer rating;

	private String feedback;
}
