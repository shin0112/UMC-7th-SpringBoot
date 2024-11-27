package com.umc.study.global.apiPayload.code.status;

import com.umc.study.global.apiPayload.code.BaseCode;
import com.umc.study.global.apiPayload.code.ReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseCode {
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청"),
    _NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON400", "존재하지 않은 객체");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDto getReasonDto() {
        return ReasonDto.builder()
            .isSuccess(false)
            .code(code)
            .message(message)
            .build();
    }

    @Override
    public ReasonDto getReasonDto(final HttpStatus httpStatus) {
        return ReasonDto.builder()
            .isSuccess(false)
            .code(code)
            .message(message)
            .httpStatus(httpStatus)
            .build();
    }
}
