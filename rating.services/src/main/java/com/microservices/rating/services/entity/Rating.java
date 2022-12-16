package com.microservices.rating.services.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name = "ratings")
public class Rating {

	@Id
	@Column(name = "ID")
	private String ratingId;
	
	@Column(name = "userId")
	private String userId;
	
	@Column(name = "companyId")
	private String companyId;
	
	@Column(name = "rating")
	private Integer rating;
	
	@Column(name = "feedback")
	private String feedback;
}
