package com.umc.study.dto.controller.member;

import java.time.LocalDate;
import java.util.List;

public class MemberControllerRequest {

    public static record JoinDto(
        String email,
        String gender,
        LocalDate inactiveDate,
        String name,
        String nickname,
        String phone,
        List<Long> preferCategory
    ) {

    }
}
