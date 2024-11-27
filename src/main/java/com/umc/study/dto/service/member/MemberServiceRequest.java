package com.umc.study.dto.service.member;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;

public class MemberServiceRequest {

    @Builder
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
