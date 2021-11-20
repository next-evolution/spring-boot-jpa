package com.example.controller;

import com.example.AppException;
import com.example.request.AccountInsertRequest;
import com.example.request.AccountUpdateRequest;
import com.example.response.AccountListResponse;
import com.example.response.AccountResponse;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/list")
    public ResponseEntity<AccountListResponse> list() {
        return new ResponseEntity<>(accountService.list(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<AccountResponse> get(@RequestParam(name = "emailAddress") String emailAddress) {
        return new ResponseEntity<>(accountService.get(emailAddress), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccountResponse> post(@Validated @RequestBody AccountInsertRequest accountInsertRequest)
    throws AppException {
        try {
            return new ResponseEntity<>(accountService.insert(accountInsertRequest), HttpStatus.OK);
        } catch (AppException e) {
            throw e;
        }
    }

    @PutMapping
    public ResponseEntity<AccountResponse> put(@Validated @RequestBody AccountUpdateRequest accountUpdateRequest)
    throws AppException {
        try {
            return new ResponseEntity<>(accountService.update(accountUpdateRequest), HttpStatus.OK);
        } catch (AppException e) {
            throw e;
        }
    }

}
