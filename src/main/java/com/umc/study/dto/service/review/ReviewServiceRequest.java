package com.umc.study.dto.service.review;

import lombok.Builder;

public class ReviewServiceRequest {

    @Builder
    public record CreateDto(
        Long memberId,
        Float star,
        String content
    ) {

    }

}
