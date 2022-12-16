package com.microservices.userservices.request.dto;

import java.io.Serializable;
import java.util.List;

import com.microservices.userservices.entity.Rating;

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
public class UserRequestDTO implements Serializable {

	private static final long serialVersionUID = -3019700678539773849L;

	private String name;
	private String email;
	private String about;

//	private List<Rating> rating;
}
