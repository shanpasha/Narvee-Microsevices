package com.narvee.usit.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestApiResponse {
	private String status;
	private String message;
	private Object data;

}