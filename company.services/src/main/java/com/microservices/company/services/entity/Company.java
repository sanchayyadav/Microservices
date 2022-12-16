package com.microservices.company.services.entity;

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
@Table(name = "company")
public class Company {

	@Id
	@Column(name = "ID")
    private  String companyid;
	
	@Column(name = "name", nullable=false, length=25)
    private  String name;
	
	@Column(name = "location")
    private  String location;
	
	@Column(name = "about", nullable=false)
    private  String about;
}
