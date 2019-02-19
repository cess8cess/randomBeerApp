package com.nrc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** The Class BeerNotFoundException. */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Beer Not Found")
public class BeerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
