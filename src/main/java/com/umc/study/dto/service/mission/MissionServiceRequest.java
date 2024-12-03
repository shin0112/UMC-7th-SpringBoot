package com.umc.study.dto.service.mission;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

public class MissionServiceRequest {

    @Builder
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
