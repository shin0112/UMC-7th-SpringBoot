package com.umc.study.service.review;

import com.umc.study.dto.service.review.ReviewServiceRequest.CreateDto;

public interface ReviewService {

    void createReview(final Long storeId, CreateDto request);
}
