package com.example;

import com.example.response.CommonResponse;
import org.springframework.http.HttpStatus;

public class AppException extends Exception {

    private final CommonResponse errorResponse;

    private final HttpStatus httpStatus;

    public AppException(final CommonResponse errorResponse, final HttpStatus httpStatus) {
        super(errorResponse.getMessageText());
        this.httpStatus = httpStatus;
        this.errorResponse = errorResponse;
    }

    public CommonResponse getErrorResponse() {
        return this.errorResponse;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

}
