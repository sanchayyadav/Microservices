package com.microservices.userservices.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.microservices.userservices.entity.User;
import com.microservices.userservices.request.dto.UserRequestDTO;
import com.microservices.userservices.response.dto.UserListResponseDTO;
import com.microservices.userservices.response.dto.UserResponseDTO;

@Mapper(componentModel="spring")
public interface UserMapper {

	UserMapper USER = Mappers.getMapper(UserMapper.class);
	
//	@Mapping(target= "phoneNo", ignore = true)
	User mapToUser(UserRequestDTO userRequestDTO);

//	@Mapping(source="", target = "", ignore=true)
	UserResponseDTO mapToUserResponseDTO(User user);

	default UserListResponseDTO mapToUserListResponseDTO(List<User> users) {
		
		UserListResponseDTO userListResponseDTO = new UserListResponseDTO();
		
		List<UserResponseDTO> userReponseDTOs = new ArrayList<>();
		
		for(User user : users) {
			UserResponseDTO userReponseDTO = this.mapToUserResponseDTO(user);
			userReponseDTOs.add(userReponseDTO);
		}
	
		userListResponseDTO.setUserDetails(userReponseDTOs);
		return userListResponseDTO;
	}
}
