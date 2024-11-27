package com.umc.study.global.apiPayload.exception;

import com.umc.study.global.apiPayload.code.BaseCode;
import com.umc.study.global.apiPayload.code.ReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseCode code;

    public ReasonDto getErrorReasonDto() {
        return code.getReasonDto();
    }

    public ReasonDto getErrorReasonHttpStatusDto() {
        return code.getReasonHttpStatusDto();
    }
}
