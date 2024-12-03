package com.umc.study.dto.controller;

import com.umc.study.validation.annotation.ExistStore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MissionControllerRequest {

    public record CreateDto(
        @NotNull
        @ExistStore
        Long storeId,
        @NotNull
        int money,
        @NotNull
        int point,
        @NotBlank
        String name
    ) {

    }

    public record ChallengeDto(
        @NotNull
        Long memberId,
        @NotNull
        Long missionId
    ) {

    }
}
