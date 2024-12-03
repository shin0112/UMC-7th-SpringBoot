package com.umc.study.dto.service.store;

import lombok.Builder;

public class StoreServiceResponse {

    @Builder
    public record CreateDto(
        String name,
        String address
    ) {}
}
