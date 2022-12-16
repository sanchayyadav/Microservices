package com.microservices.company.services.exception.handler.response;

import java.io.Serializable;
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
@Builder
@ToString
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 5736109109470197064L;

	private String errorMessage;
}
