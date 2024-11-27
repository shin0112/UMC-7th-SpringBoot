package com.umc.study.global.apiPayload.code.status;

import com.umc.study.global.apiPayload.code.BaseCode;
import com.umc.study.global.apiPayload.code.ReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    _OK(HttpStatus.OK, "COMMON200", "성공");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDto getReasonDto() {
        return ReasonDto.builder()
            .isSuccess(true)
            .code(code)
            .message(message)
            .build();
    }

    @Override
    public ReasonDto getReasonDto(final HttpStatus httpStatus) {
        return ReasonDto.builder()
            .isSuccess(true)
            .code(code)
            .message(message)
            .httpStatus(httpStatus)
            .build();
    }
}
