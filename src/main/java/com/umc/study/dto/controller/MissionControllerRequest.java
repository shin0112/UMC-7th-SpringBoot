package com.umc.study.dto.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MissionControllerRequest {

    public record CreateDto(
        @NotNull
        Long storeId,
        @NotNull
        int money,
        @NotNull
        int point,
        @NotBlank
        String name
    ) {

    }

}
