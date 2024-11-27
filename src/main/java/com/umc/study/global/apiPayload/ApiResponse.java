package com.umc.study.global.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.umc.study.global.apiPayload.code.BaseCode;
import com.umc.study.global.apiPayload.code.status.SuccessStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {

    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(Include.NON_NULL)
    private final T result;

    public static <T> ApiResponse<T> success(final T result) {
        return new ApiResponse<>(
            true,
            SuccessStatus._OK.getCode(),
            SuccessStatus._OK.getMessage(),
            result
        );
    }

    public static <T> ApiResponse<T> of(
        final BaseCode code,
        final T result
    ) {
        return new ApiResponse<>(
            true,
            code.getReasonDto().getCode(),
            code.getReasonDto().getMessage(),
            result
        );
    }

    public static <T> ApiResponse<T> error(
        final String code,
        final String message,
        final T result
    ) {
        return new ApiResponse<>(
            false,
            code,
            message,
            result
        );
    }
}
