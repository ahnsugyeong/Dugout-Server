package com.ahnsugyeong.dugout.global.response.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.OK;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseStatus {

    SUCCESS(OK, 2000, "성공");

    private final HttpStatus httpStatus;
    private final int code;
    private final String message;

}