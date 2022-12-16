package com.microservices.rating.services.request.dto;

import java.io.Serializable;

import javax.persistence.Column;

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
public class RatingRequestDTO implements Serializable {

	private static final long serialVersionUID = -3019700678539793849L;

	private String userId;

	private String companyId;

	private int rating;

	private String feedback;
}
