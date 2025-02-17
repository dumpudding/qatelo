package com.qatelo.backend.exception;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorObject {
	private Integer status;
	private String message;
	private Date timestamp;
}
