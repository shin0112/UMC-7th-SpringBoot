package com.umc.study.converter;

import com.umc.study.dto.controller.ReviewControllerRequest;
import com.umc.study.dto.service.review.ReviewServiceRequest;

public class ReviewConverter {

    public static ReviewServiceRequest.Create toReviewCreateServiceRequestDto(
        ReviewControllerRequest.Create request
    ) {
        return ReviewServiceRequest.Create.builder()
            .memberId(request.memberId())
            .star(request.star())
            .content(request.content())
            .build();
    }
}
