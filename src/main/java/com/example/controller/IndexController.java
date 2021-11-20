package com.example.controller;

import com.example.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class IndexController {

    @GetMapping("/")
    public ResponseEntity<CommonResponse> index() {
        return new ResponseEntity<>(CommonResponse.builder()
                                                  .returnCode(0)
                                                  .recordCount(1)
                                                  .messageText(String.format("hello - %s", LocalDateTime.now()))
                                                  .build(),
                                    HttpStatus.OK);
    }

}
