package com.umc.study.dto.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReviewControllerRequest {

    public record Create(
        @NotNull
        Long memberId,
        @NotNull
        Float star,
        @NotBlank
        String content
    ) {

    }

}
