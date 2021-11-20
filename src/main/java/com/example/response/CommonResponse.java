package com.example.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class CommonResponse {

    private int returnCode;

    private int recordCount;

    private String messageText;

}
