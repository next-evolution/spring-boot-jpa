package com.example.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class AccountInsertRequest {

    @NotBlank
    @Email
    String emailAddress;

    @NotBlank
    String nickName;

}
