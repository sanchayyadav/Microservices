package com.microservices.userservices.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Rating {

	private String ratingId;
	private String userId;
	private String companyId;
	private Integer rating;
	private String feedback;
	private Company company;

}
