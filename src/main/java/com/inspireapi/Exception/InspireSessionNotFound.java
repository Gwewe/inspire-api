package com.inspireapi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InspireSessionNotFound extends RuntimeException {

    public InspireSessionNotFound(String message, Throwable causeErr) {
        super(message, causeErr);
    }

    public InspireSessionNotFound(String message){
        super(message);
    }

}
