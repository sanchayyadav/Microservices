package com.microservices.userservices.response.dto;

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
public class CompanyResponseDTO {

	private  String companyid;
    private  String name;
    private  String location;
    private  String about;
}
