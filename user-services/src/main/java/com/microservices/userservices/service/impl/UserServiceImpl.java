package com.microservices.userservices.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import com.microservices.userservices.constants.ErrorMessageConstants;
import com.microservices.userservices.entity.Company;
import com.microservices.userservices.entity.Rating;
import com.microservices.userservices.entity.User;
import com.microservices.userservices.exception.EntityNotFoundException;
import com.microservices.userservices.external.services.CompanyService;
import com.microservices.userservices.mapper.CompanyMapper;
import com.microservices.userservices.mapper.RatingMapper;
import com.microservices.userservices.mapper.UserMapper;
import com.microservices.userservices.repository.UserRepository;
import com.microservices.userservices.request.dto.UserRequestDTO;
import com.microservices.userservices.response.dto.CompanyResponseDTO;
import com.microservices.userservices.response.dto.RatingListResponseDTO;
import com.microservices.userservices.response.dto.UserListResponseDTO;
import com.microservices.userservices.response.dto.UserResponseDTO;
import com.microservices.userservices.service.UserService;

@Service
//@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private UserMapper userMapper;
	
	@Autowired
	private  RatingMapper ratingMapper;
	
	@Autowired
	private CompanyMapper companyMapper;
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired 
	private RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	private CompanyService companyService;
	
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
	@Override
	@Transactional
	public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {

		User user= userMapper.mapToUser(userRequestDTO);
		
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
		user = userRepository.save(user);
		
		UserResponseDTO userResponseDTO = userMapper.mapToUserResponseDTO(user);
		
		return userResponseDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(String userId) {
		
		List<String> errorParameters = new ArrayList<>();
		errorParameters.add(userId);
		
		User user = userRepository.findById(userId)
									.orElseThrow(() -> new EntityNotFoundException(ErrorMessageConstants.ERROR_USER_ID_NOT_FOUND, errorParameters));
		return user;
	}

	@Override
	@Transactional(readOnly = true)
	public UserResponseDTO getUser(String userId) {

		User user = this.findById(userId);
		RatingListResponseDTO ratingsOfUser = null;
		
		try {
			 ratingsOfUser = restTemplateBuilder.build().getForObject("http://127.0.0.1:8083/rating/users/" + user.getUserId() ,  RatingListResponseDTO.class);
		} catch (ResourceAccessException e) {
		    logger.info("Failed to get remote resource because: " + e.getRootCause());
		}
	     
		logger.info("{} ", ratingsOfUser);

		List<Rating> ratings = ratingMapper.mapToRating(ratingsOfUser.getRatingDetails());

		List<Rating> ratingList = ratings.stream().map(rating -> {
			CompanyResponseDTO companyResponseDTO = null;
			try {
	     companyResponseDTO = restTemplateBuilder.build().getForObject("http://127.0.0.1:8082/company/"+rating.getCompanyId(), CompanyResponseDTO.class);
			}
			catch (ResourceAccessException e) {
			    logger.info("Failed to get remote resource because: " + e.getRootCause());
			}
	    Company company = companyMapper.mapToCompanyResponseDTO(companyResponseDTO);

	            rating.setCompany(company);
	            return rating;
	        }).collect(Collectors.toList());

        user.setRatings(ratingList);
		UserResponseDTO userResponseDTO = userMapper.mapToUserResponseDTO(user);
		
		return userResponseDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public UserListResponseDTO getAllUsers() throws EntityNotFoundException{

		List<User> users = userRepository.findAll();
			
		if(users.size() == 0) {
			throw new EntityNotFoundException(ErrorMessageConstants.ERROR_USER_NOT_FOUND, new ArrayList<>());
		}
		UserListResponseDTO userResponseDTO = userMapper.mapToUserListResponseDTO(users);

		return userResponseDTO;
	}
}
