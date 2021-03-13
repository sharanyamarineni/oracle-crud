package com.zemoso.oraclecrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(value = {BookNotFoundException.class})
    public ResponseEntity<Object> handleInvalidParams(
            Exception ex,
            WebRequest webRequest
    ) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String uri = ((ServletWebRequest) webRequest).getRequest()
                .getRequestURI();
        ApiError error = new ApiError(status, ex.getMessage(), uri);
        return new ResponseEntity<>(error, status);
    }
}
