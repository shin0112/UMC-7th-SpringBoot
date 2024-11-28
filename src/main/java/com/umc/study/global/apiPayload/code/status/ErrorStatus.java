package com.umc.study.global.apiPayload.code.status;

import com.umc.study.global.apiPayload.code.BaseCode;
import com.umc.study.global.apiPayload.code.ReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseCode {
    // 공통
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청"),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "권한 없음"),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청"),
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러"),

    // 회원
    _NOT_FOUND_MEMBER(HttpStatus.NOT_FOUND, "MEMBER4001", "회원 정보 없음"),
    _ALREADY_EXIST_EMAIL(HttpStatus.BAD_REQUEST, "MEMBER4002", "이메일 중복"),

    // 음식
    _NOT_FOUND_FOOD(HttpStatus.NOT_FOUND, "FOOD4001", "음식 정보 없음"),

    // 지역
    _NOT_FOUND_REGION(HttpStatus.NOT_FOUND, "REGION4001", "지역 정보 없음"),

    // 미션
    _NOT_FOUND_MISSION_STATUS(HttpStatus.NOT_FOUND, "MISSION4001", "미션 상태 정보 없음"),
    ;

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
    public ReasonDto getReasonHttpStatusDto() {
        return ReasonDto.builder()
            .isSuccess(false)
            .code(code)
            .message(message)
            .httpStatus(httpStatus)
            .build();
    }
}
