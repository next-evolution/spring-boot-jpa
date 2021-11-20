package com.example.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class AccountUpdateRequest {

    @Positive
    Long accountNumber;

    @NotBlank
    @Email
    String emailAddress;

    @NotBlank
    String nickName;

}
