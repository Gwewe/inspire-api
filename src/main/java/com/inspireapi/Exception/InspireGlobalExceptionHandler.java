package com.inspireapi.Exception;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class InspireGlobalExceptionHandler {

    private static final Logger loggerErr = LoggerFactory.getLogger(InspireGlobalExceptionHandler.class);

    private ResponseEntity<Object> buildResponse(HttpStatus status, String message, WebRequest request) {
        Map<String, Object> bodymessage = new LinkedHashMap<>();
        bodymessage.put("timestamp", Instant.now().truncatedTo(ChronoUnit.MILLIS));
        bodymessage.put("status", status.value());
        bodymessage.put("error", status.getReasonPhrase());
        bodymessage.put("message", message);
        bodymessage.put("path", request.getDescription(false).replace("uri=", ""));
        return new ResponseEntity<>(bodymessage, status);
    }

    @ExceptionHandler(InspireSessionNotFound.class)
    public ResponseEntity<Object> handleInspireSessionNotFound(InspireSessionNotFound except, WebRequest request) {
        loggerErr.warn("The provided Inspire session was not found", except);
        return buildResponse(HttpStatus.NOT_FOUND, except.getMessage(), request);
    }

    @ExceptionHandler(InvalidModuleTypeException.class)
    public ResponseEntity<Object> handleInvalidModuleTypeException(InvalidModuleTypeException except, WebRequest request) {
        loggerErr.warn("The provided module type is invalid", except);
        return buildResponse(HttpStatus.BAD_REQUEST, except.getMessage(), request);
    }

    @ExceptionHandler(ModuleNotFoundException.class)
    public ResponseEntity<Object> handleModuleNotFoundException (ModuleNotFoundException except, WebRequest request) {
        loggerErr.warn("The provided module type was not found", except);
        return buildResponse(HttpStatus.NOT_FOUND, except.getMessage(), request);
    }
    
    @ExceptionHandler(InvalidPatchFieldNameException.class)
    public ResponseEntity<Object> handleInvalidPatchFieldNameException(InvalidPatchFieldNameException except, WebRequest request) {
        loggerErr.warn("The provided patch field name is invalid", except);
        return buildResponse(HttpStatus.BAD_REQUEST, except.getMessage(), request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllOthersException(Exception except, WebRequest request) {
        loggerErr.error("Unhandled exception: ", except);
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "My apologies, an unexpected error occurred", request);
    }

}
