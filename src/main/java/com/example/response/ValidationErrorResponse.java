package com.example.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ValidationErrorResponse extends CommonResponse {

    private int errorCount;

    private Map<String, String> errors;

}
