package com.microservices.userservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.userservices.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
