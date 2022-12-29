package com.microservices.userservices.response.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.microservices.userservices.entity.Rating;

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
public class UserResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 7533859268418874907L;
	private String userId;
	private String name;
	private String email;
	private String about;
	
	private List<Rating> ratings=new ArrayList<>();

}
