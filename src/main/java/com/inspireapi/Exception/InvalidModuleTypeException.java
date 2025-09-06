package com.inspireapi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidModuleTypeException extends RuntimeException {

    public InvalidModuleTypeException(String message, Throwable causeErr) {
        super(message, causeErr);
    }

    public InvalidModuleTypeException(String message) {
        super(message);
    }

}
