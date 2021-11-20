package com.example.controller;

import com.example.AppException;
import com.example.response.CommonResponse;
import com.example.response.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<CommonResponse> coreServiceException(final AppException e) {
        return new ResponseEntity<>(e.getErrorResponse(), e.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse methodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return ValidationErrorResponse.builder()
                                      .returnCode(2)
                                      .messageText("validation error")
                                      .recordCount(0)
                                      .errorCount(e.getErrorCount())
                                      .errors(e.getBindingResult().getFieldErrors().stream().collect(
                                              Collectors.toMap(FieldError::getField, fe -> fe.getDefaultMessage())))
                                      .build();
    }

}

