package com.microservices.userservices.response.dto;

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
public class UserListResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 4534859268418874907L;
	List<UserResponseDTO> userDetails;
}
