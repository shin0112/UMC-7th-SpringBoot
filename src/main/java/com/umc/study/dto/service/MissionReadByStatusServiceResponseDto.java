package com.umc.study.dto.service;

import lombok.Builder;

@Builder
public record MissionReadByStatusServiceResponseDto(
    Long id,
    String name,
    int money,
    int point,
    String status
) {

}
