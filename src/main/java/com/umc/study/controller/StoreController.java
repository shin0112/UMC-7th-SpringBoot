package com.umc.study.controller;

import com.umc.study.dto.controller.StoreControllerRequest;
import com.umc.study.dto.service.store.StoreServiceResponse;
import com.umc.study.global.apiPayload.ApiResponse;
import com.umc.study.service.store.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    @PostMapping("")
    public ApiResponse<StoreServiceResponse.CreateDto> createStore(
        @RequestParam(name = "region") final String region,
        @RequestBody @Valid final StoreControllerRequest.CreateDto request
    ) {
        return ApiResponse.success(storeService.createStore(region, request));
    }
}
