package com.microservices.userservices.service;

import java.util.List;

import com.microservices.userservices.entity.User;
import com.microservices.userservices.request.dto.UserRequestDTO;
import com.microservices.userservices.response.dto.UserListResponseDTO;
import com.microservices.userservices.response.dto.UserResponseDTO;

public interface UserService {

	
	UserResponseDTO createUser(UserRequestDTO user);
	
	UserListResponseDTO getAllUsers();
	
	UserResponseDTO getUser(String userId);

	User findById(String userId);
	
	//TODO: update
	//TODO: delete
}

