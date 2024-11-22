package com.ahnsugyeong.dugout.common.response.status;

import org.springframework.http.HttpStatus;

public interface BaseStatus {

    HttpStatus getHttpStatus();
    int getCode();
    String getMessage();

}
