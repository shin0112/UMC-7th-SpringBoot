package com.umc.study.service.review;

import com.umc.study.dto.service.review.ReviewServiceRequest;

public interface ReviewService {

    void createReview(final Long storeId, ReviewServiceRequest.Create request);
}
