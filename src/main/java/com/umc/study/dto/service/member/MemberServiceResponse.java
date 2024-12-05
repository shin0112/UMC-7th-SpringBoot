package com.umc.study.dto.service.member;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

public class MemberServiceResponse {

    @Builder
    public static record JoinResultDto(
        Long memberId,
        LocalDateTime createdAt
    ) {

    }
}
