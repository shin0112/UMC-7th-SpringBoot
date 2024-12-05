package com.umc.study.dto.controller;

import jakarta.validation.constraints.NotNull;

public class StoreControllerRequest {

    public record CreateDto(
        @NotNull
        String name,
        @NotNull
        String address
    ) {

    }

}
