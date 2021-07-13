package com.fpt.main.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.fpt.main.exception.TokenRefreshException;
import com.fpt.main.payload.response.MessageResponse;

@RestControllerAdvice
public class TokenControllerAdvice {

  @ExceptionHandler(value = TokenRefreshException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public ResponseEntity<?> handleTokenRefreshException(TokenRefreshException ex, WebRequest request) {
    return ResponseEntity.badRequest()
    		.body(new MessageResponse(ex.getMessage()));
       
  }
}
