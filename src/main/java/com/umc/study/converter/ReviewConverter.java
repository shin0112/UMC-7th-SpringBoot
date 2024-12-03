package com.umc.study.converter;

import com.umc.study.dto.controller.ReviewControllerRequest;
import com.umc.study.dto.service.review.ReviewServiceRequest.CreateDto;

public class ReviewConverter {

    public static CreateDto toReviewCreateServiceRequestDto(
        ReviewControllerRequest.CreateDto request
    ) {
        return CreateDto.builder()
            .memberId(request.memberId())
            .star(request.star())
            .content(request.content())
            .build();
    }
}
