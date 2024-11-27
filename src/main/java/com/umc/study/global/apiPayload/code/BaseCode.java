package com.umc.study.global.apiPayload.code;

import org.springframework.http.HttpStatus;

public interface BaseCode {

    ReasonDto getReasonDto();

    ReasonDto getReasonHttpStatusDto();
}
