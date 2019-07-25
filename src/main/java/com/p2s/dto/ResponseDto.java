package com.p2s.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * @author pawanthapa 
 * ResponseDto objects pass message, errorCode, totalRecords,
 * data, status of the response
 */
public class ResponseDto {

	private String message;
	private int errorCode;
	private int totalRecords;
	private Object data;
	private String status;

}
