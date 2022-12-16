package com.microservices.userservices.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Table(name = "users")
public class User {

	@Id
	@Column(name = "ID")
	private String userId;
	
	@Column(name = "name", nullable=false, length=25)
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "about",  nullable=false)
	private String about;
	
	@Column(name = "phone_no", length=12)
	private Integer phoneNo;

	@Transient
	private List<Rating> ratings=new ArrayList<>();
}
