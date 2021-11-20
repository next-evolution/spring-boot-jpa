package com.example.service;

import com.example.AppException;
import com.example.response.CommonResponse;
import org.springframework.http.HttpStatus;

public class ServiceBase {

    public AppException createAppException(final String messageText,
                                           final HttpStatus httpStatus) {
        return new AppException(CommonResponse.builder()
                                              .returnCode(2)
                                              .recordCount(0)
                                              .messageText(messageText)
                                              .build(),
                                httpStatus);
    }

}
