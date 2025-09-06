package com.inspireapi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidPatchFieldNameException extends RuntimeException {

    public InvalidPatchFieldNameException(String message, Throwable causeErr) {
        super(message, causeErr);
    }

    public InvalidPatchFieldNameException(String message) {
        super(message);
    }

}
