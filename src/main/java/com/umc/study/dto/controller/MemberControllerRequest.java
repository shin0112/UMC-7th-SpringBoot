package com.umc.study.dto.controller;

import com.umc.study.domain.enums.Role;
import com.umc.study.validation.annotation.ExistCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class MemberControllerRequest {

    public record JoinDto(
        @NotBlank
        String email,
        @NotBlank
        String password,
        @NotNull
        String gender,
        @NotNull
        LocalDate inactiveDate,
        @NotNull
        String name,
        @NotNull
        String nickname,
        @NotNull
        String phone,
        @ExistCategory List<Long> preferCategory,
        @NotNull
        Role role
    ) {

    }
}
