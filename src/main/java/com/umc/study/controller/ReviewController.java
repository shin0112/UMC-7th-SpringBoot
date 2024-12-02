package com.umc.study.controller;

import com.umc.study.converter.ReviewConverter;
import com.umc.study.dto.controller.ReviewControllerRequest.CreateDto;
import com.umc.study.global.apiPayload.ApiResponse;
import com.umc.study.service.review.ReviewService;
import com.umc.study.validation.annotation.ExistStore;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<Object> createReview(
        @ExistStore @PathVariable(name = "storeId") final Long storeId,
        @Valid @RequestBody final CreateDto request
    ) {
        reviewService.createReview(
            storeId,
            ReviewConverter.toReviewCreateServiceRequestDto(request)
        );

        return ApiResponse.success(null);
    }
}
